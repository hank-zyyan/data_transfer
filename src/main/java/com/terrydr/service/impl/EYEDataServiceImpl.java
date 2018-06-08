package com.terrydr.service.impl;

import com.terrydr.Util;
import com.terrydr.dao.eye.*;
import com.terrydr.domain.eye.*;
import com.terrydr.service.EYEDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyyan@terrydr.com
 * @version 1.0.0
 * @desc 描述 <br>
 * <p>
 * Copyright: Copyright (c)
 * <p>
 * Company: 南京泰立瑞信息科技有限公司
 * <p>
 */
@Service
@Transactional(value = "eyeTransactionManager")
public class EYEDataServiceImpl implements EYEDataService {

    private Logger logger = LoggerFactory.getLogger(EYEDataServiceImpl.class);

    @Resource
    private AITaskDAO aiTaskDAO;

    @Resource
    private AnteriorSegmentDAO anteriorSegmentDAO;

    @Resource
    private ConsultationDAO consultationDAO;

    @Resource
    private CustomerDAO customerDAO;

    @Resource
    private EncounterDAO encounterDAO;

    @Resource
    private FundusDAO fundusDAO;

    @Resource
    private GeneralExaminationDAO generalExaminationDAO;

    @Resource
    private MedicalRecordDAO medicalRecordDAO;

    @Resource
    private ReportDAO reportDAO;

    @Resource
    private ScreenIntervalDAO screenIntervalDAO;

    @Value("${spring.profiles.active}")
    private String profiles;

    @Override
    public void importCommonData() {
        logger.info("开始迁移眼科数据...");

        Map<String, Integer> map1 = new HashMap<String, Integer>();

        Map<String, Integer> map2 = new HashMap<String, Integer>();

        logger.info("Step0:清空目标数据库数据");
        try {
            generalExaminationDAO.dropAll();
            generalExaminationDAO.dropOptometry();
            generalExaminationDAO.dropVisionExam();
            anteriorSegmentDAO.drop();
            fundusDAO.drop();
            encounterDAO.drop();
            customerDAO.drop();

            customerDAO.createTable();
            encounterDAO.createTable();
            generalExaminationDAO.createTableAll();
            generalExaminationDAO.createTableOptometry();
            generalExaminationDAO.createTableVisionExam();
            anteriorSegmentDAO.createTable();
            fundusDAO.createTable();
        }catch (Exception e){
            logger.info("表格已创建");
        }

        logger.info("共清空目标数据库GeneralExamination数据：" + generalExaminationDAO.deleteAll() + "条");
        logger.info("共清空目标数据库Optometry数据：" + generalExaminationDAO.deleteOptometry() + "条");
        logger.info("共清空目标数据库VisionExam数据：" + generalExaminationDAO.deleteVisionExam() + "条");
        logger.info("共清空目标数据库AnteriorSegment数据：" + anteriorSegmentDAO.deleteAll() + "条");
        logger.info("共清空目标数据库Fundus数据：" + fundusDAO.deleteAll() + "条");
        logger.info("共清空目标数据库Encounter数据：" + encounterDAO.deleteAll() + "条");
        logger.info("共清空目标数据库Customer数据：" + customerDAO.deleteAll() + "条");

        logger.info("Step1:更新表结构");
        try {
            generalExaminationDAO.modifyAITask();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("AITask表已更新");
        }
        try {
            generalExaminationDAO.modifyConsultation();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Consultation表已更新");
        }
        try {
            generalExaminationDAO.modifyReport();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Report表已更新");
        }
        try {
            generalExaminationDAO.modifyScreenInterval();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("ScreenInterval表已更新");
        }

        try {
            generalExaminationDAO.modifyAIResult();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("AIResult表已更新");
        }

        logger.info("Step2:迁移数据");
        List<Detail> details = null;
        if("pro".equals(profiles)){
            details = medicalRecordDAO.selectDetailsPro();
            logger.info("Step1:迁移数据（PRO）");
        }else if("beta".equals(profiles)){
            details = medicalRecordDAO.selectDetailsTest();
            logger.info("Step1:迁移数据（BETA）");
        }else if("dev".equals(profiles)){
            details = medicalRecordDAO.selectDetailsDev();
            logger.info("Step1:迁移数据（DEV）");
        }else{
            return;
        }
        for (Detail detail : details) {
            String pid = detail.getPatientId() == null ? "NULL" : detail.getPatientId().toString();
            String did = detail.getDoctorId() == null ? "NULL" : detail.getDoctorId().toString();
            String pdId = pid + "-" +  did;
            String md = String.valueOf(detail.getMedicalDate().getTime() / (1000 * 3600 * 24));
            String pdtId = md + "-" + pdId;

//            logger.info("Step1-1:创建customer和encounter");
            if (detail.getPatientId() == null || map1.get(pdId) == null) { //pid为null或pdid不存在于map
                Customer customer = createCustomer(detail);
                customerDAO.insertSelective(customer);
                Integer cId = customer.getId();
                map1.put(pdId, cId);

                Encounter encounter = createEncounter(detail, cId);
                encounterDAO.insertSelective(encounter);
                Integer eId = encounter.getId();
                map2.put(pdtId, eId);


                if(detail.getPatientId() == null){
                    String ccptId = customerDAO.getEncryptId(cId);
                    String ecptId = encounterDAO.getEncryptId(eId);
                    if(detail.getEyeRightVision() != null || detail.getEyeLeftVision() != null){ //创建一般检查数据
                        GeneralExamination generalExamination = createGeneralExamination(detail, eId, ecptId);
                        generalExaminationDAO.insertSelective(generalExamination);
                    }
                    if (detail.getType() == 23){
                        Fundus fundus = createFundus(detail, eId, ecptId);
                        fundusDAO.insertSelective(fundus);
                        Integer fId = fundus.getId();
                        updateRelated(detail.getRecordId(),fId, 3, fundus.getEncryptId(), eId, ecptId, cId, ccptId);
                    }else if(detail.getType() == 4){
                        AnteriorSegment anteriorSegment = createAnteriorSegment(detail, eId, ecptId);
                        anteriorSegmentDAO.insertSelective(anteriorSegment);
                        Integer aId = anteriorSegment.getId();
                        updateRelated(detail.getRecordId(),aId, 2, anteriorSegment.getEncryptId(), eId, ecptId, cId, ccptId);
                    }
                }
            } else { //计算pid+did存在于map，不创建customer
                Integer cId = map1.get(pdId);
                Integer eId = map2.get(pdtId);
                if (eId == null) { //创建encounter
                    Encounter encounter = createEncounter(detail, cId);
                    encounterDAO.insertSelective(encounter);
                    map2.put(pdtId, encounter.getId());
                }
            }

            if(detail.getPatientId() != null){
                Integer cId = map1.get(pdId);
                String ccptId = customerDAO.getEncryptId(cId);
                Integer eId = map2.get(pdtId);
                String ecptId = encounterDAO.getEncryptId(eId);
//            logger.info("Step1-2:创建检查");
                if(detail.getEyeRightVision() != null || detail.getEyeLeftVision() != null){ //创建一般检查数据
                    GeneralExamination generalExamination = createGeneralExamination(detail, eId, ecptId);
                    generalExaminationDAO.insertSelective(generalExamination);
                }
                if (detail.getType() == 23){//3
                    Fundus fundus = createFundus(detail, eId, ecptId);
                    fundusDAO.insertSelective(fundus);
                    Integer fId = fundus.getId();
                    updateRelated(detail.getRecordId(),fId, 3, fundus.getEncryptId(), eId, ecptId, cId, ccptId);
                }else if(detail.getType() == 4){ //2
                    AnteriorSegment anteriorSegment = createAnteriorSegment(detail, eId, ecptId);
                    anteriorSegmentDAO.insertSelective(anteriorSegment);
                    Integer aId = anteriorSegment.getId();
                    updateRelated(detail.getRecordId(),aId, 2, anteriorSegment.getEncryptId(), eId, ecptId, cId, ccptId);
                }
            }

        }
        logger.info("Step1:迁移数据结束");

        logger.info("眼科数据迁移完毕");

//        int i = 1 / 0;
    }

    private void updateRelated(Integer rId, Integer examId, Integer examType, String examEncryptId, Integer eId, String ecptId, Integer cId, String ccptId){
        AITask aiTask = new AITask();
        aiTask.setId(rId.toString());
        aiTask.setExamineId(examId);
        aiTask.setExamineType(examType);
        aiTask.setExamineEncryptId(examEncryptId);
        aiTaskDAO.updateByPrimaryKeySelective(aiTask);

        Consultation consultation = new Consultation();
        consultation.setId(rId);
        consultation.setExamineId(examId);
        consultation.setExamineType(examType);
        consultation.setExamineEncryptId(examEncryptId);
        consultationDAO.updateByPrimaryKeySelective(consultation);

        Report report = new Report();
        report.setReportId(rId);
        report.setExamineId(examId);
        report.setExamineType(examType);
        report.setExamineEncryptId(examEncryptId);
        report.setEncounterId(eId);
        report.setEncounterEncryptId(ecptId);
        report.setCustomerId(cId);
        report.setCustomerEncryptId(ccptId);
        logger.info(report.toString());
        reportDAO.updateByPrimaryKeySelective(report);

        ScreenInterval screenInterval = new ScreenInterval();
        screenInterval.setId(rId);
        screenInterval.setExamineId(examId);
        screenInterval.setExamineEncryptId(examEncryptId);
        screenIntervalDAO.updateByPrimaryKeySelective(screenInterval);
    }

    private AnteriorSegment createAnteriorSegment(Detail detail, Integer eId, String ecptId){
        AnteriorSegment fundus = new AnteriorSegment();
        fundus.setEncryptId(detail.getShareId());
        fundus.setEncounterId(eId);
        fundus.setEncounterEncryptId(ecptId);
        fundus.setLeftImg(detail.getEyeLeftImg());
        fundus.setLeftVideo(detail.getEyeLeftVideo());
        fundus.setRightImg(detail.getEyeRightImg());
        fundus.setRightVideo(detail.getEyeRightVideo());
        fundus.setCollectFile(detail.getMedicalPictures());
        fundus.setCover(detail.getMedicalCover());
        fundus.setIsDelete(detail.getIsDeleted());
        fundus.setReportStatus(detail.getReportStatus());
        fundus.setRemark(detail.getMedicalConclusion());
        fundus.setCreateTime(detail.getMedicalDate());
        fundus.setLastUpdateTime(detail.getMedicalDate());
        return fundus;
    }

    private Fundus createFundus(Detail detail, Integer eId, String ecptId){
        Fundus fundus = new Fundus();
        fundus.setEncryptId(detail.getShareId());
        fundus.setEncounterId(eId);
        fundus.setEncounterEncryptId(ecptId);
        fundus.setLeftImg(detail.getEyeLeftImg());
        fundus.setLeftVideo(detail.getEyeLeftVideo());
        fundus.setRightImg(detail.getEyeRightImg());
        fundus.setRightVideo(detail.getEyeRightVideo());
        fundus.setCollectFile(detail.getMedicalPictures());
        fundus.setCover(detail.getMedicalCover());
        fundus.setIsDelete(detail.getIsDeleted());
        fundus.setReportStatus(detail.getReportStatus());
        fundus.setRemark(detail.getMedicalConclusion());
        fundus.setCreateTime(detail.getMedicalDate());
        fundus.setLastUpdateTime(detail.getMedicalDate());
        return fundus;
    }

    private GeneralExamination createGeneralExamination(Detail detail, Integer eId, String ecptId){
        GeneralExamination generalExamination = new GeneralExamination();
        generalExamination.setEncryptId(detail.getShareId());
        generalExamination.setEncounterId(eId);
        generalExamination.setEncounterEncryptId(ecptId);
        generalExamination.setlNv(detail.getEyeLeftVision());
        generalExamination.setrNv(detail.getEyeRightVision());
        generalExamination.setCreateTime(detail.getMedicalDate());
        generalExamination.setLastUpdateTime(detail.getMedicalDate());
        generalExamination.setIsDelete(detail.getIsDeleted());
        return generalExamination;
    }

    private Customer createCustomer(Detail detail) {
        Customer customer = new Customer();
        customer.setEncryptId(Util.getEncryptId());
        customer.setDoctorId(detail.getDoctorId());
        customer.setDoctorName(detail.getDoctorName());
        customer.setHospitalId(detail.getHospitalId());
        customer.setHospitalName(detail.getHospitalName());
        if(detail.getPatientId() == null){
            String n = detail.getRpn();
            if(n == null || n.length() == 0){
                n = "匿名";
            }
            customer.setName(n);
            customer.setSex(detail.getRps());
            customer.setTeleno(detail.getRpt());
        }else{
            String n = detail.getPatientName();
            if(n == null || n.length() == 0){
                n = "匿名";
            }
            customer.setName(n);
            customer.setSex(detail.getPatientSex());
            customer.setBirthday(detail.getPatientBirthday());
            customer.setTeleno(detail.getPatientTeleno());
            customer.setPatientId(detail.getPatientId());
        }
        customer.setCreateTime(detail.getMedicalDate());
        customer.setLastUpdateTime(detail.getMedicalDate());
        if (detail.getC1Id() != null) { //县级
            customer.setLpAreaId(detail.getC3Id());
            customer.setLpAreaName(detail.getC3Name());
            customer.setLpCityId(detail.getC2Id());
            customer.setLpCityName(detail.getC2Name());
            customer.setLpProvId(detail.getC1Id());
            customer.setLpProvName(detail.getC1Name());
        } else if (detail.getC2Id() != null) { //市级
            customer.setLpCityId(detail.getC3Id());
            customer.setLpCityName(detail.getC3Name());
            customer.setLpProvId(detail.getC2Id());
            customer.setLpProvName(detail.getC2Name());
        } else if (detail.getC3Id() != null) { //省会
            customer.setLpProvId(detail.getC3Id());
            customer.setLpProvName(detail.getC3Name());
        }
        return customer;
    }

    private Encounter createEncounter(Detail detail, Integer cId) {
        Encounter encounter = new Encounter();
        encounter.setEncryptId(Util.getEncryptId());
        encounter.setCustomerId(cId);
        encounter.setCustomerEncryptId(customerDAO.getEncryptId(cId));
        encounter.setEyeType(eyeTypeJudger(detail));
        encounter.setDoctorId(detail.getDoctorId());
        encounter.setDoctorName(detail.getDoctorName());
        encounter.setDoctorTeleno(detail.getDoctorTeleno());
        encounter.setDoctorAvatar(detail.getDoctorAvatar());
        encounter.setHospitalId(detail.getHospitalId());
        encounter.setHospitalName(detail.getHospitalName());
        encounter.setCover(detail.getMedicalCover());
        encounter.setVisitDate(detail.getMedicalDate());
        encounter.setDepartmentId(detail.getDepartmentId());
        encounter.setDepartmentName(detail.getDepartmentName());
        encounter.setCreateTime(detail.getMedicalDate());
        encounter.setLastUpdateTime(detail.getMedicalDate());
        return encounter;
    }

    private Integer eyeTypeJudger(Detail detail) {
        String l = detail.getEyeLeftImg() + detail.getEyeLeftVideo() + detail.getEyeLeftVision();
        String r = detail.getEyeRightImg() + detail.getEyeRightVideo() + detail.getEyeRightVision();
        if (l != null && r == null) {
            return 1;
        } else if (r != null && l == null) {
            return 2;
        } else if (l != null && r != null) {
            return 3;
        } else {
            return null;
        }
    }

}
