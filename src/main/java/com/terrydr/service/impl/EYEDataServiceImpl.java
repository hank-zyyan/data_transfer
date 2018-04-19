package com.terrydr.service.impl;

import com.mysql.jdbc.StringUtils;
import com.terrydr.dao.basic.*;
import com.terrydr.dao.eye.*;
import com.terrydr.domain.*;
import com.terrydr.domain.eye.*;
import com.terrydr.service.EYEDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
    private EYEAIResultDAO eyeaiResultDAO;

    @Resource
    private AIResultDAO aiResultDAO;

    @Resource
    private EYEAITaskDAO eyeaiTaskDAO;

    @Resource
    private AITaskDAO aiTaskDAO;

    @Resource
    private EYEScreenIntervalDAO eyeScreenIntervalDAO;

    @Resource
    private ScreenIntervalDAO screenIntervalDAO;

    @Override
    public void importCommonData() {
        logger.info("开始迁移眼科普通数据...");

        logger.info("Step0:清空目标数据库数据");
        logger.info("共清空目标数据库AI_Result数据：" + eyeaiResultDAO.deleteAll() + "条");
        logger.info("共清空目标数据库AI_Task数据：" + eyeaiTaskDAO.deleteAll() + "条");
        logger.info("共清空目标数据库Screen_Interval数据：" + eyeScreenIntervalDAO.deleteAll() + "条");

        logger.info("Step1:插入AI_Result数据");
        int c = aiResultDAO.count();
        int realC = 0;//实际插入记录数
        int noData = 0;//非数据数量
        if (c > 1000) {
            logger.info("AI_Result超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<AIResult> results = aiResultDAO.selectPerPage(currentOffset, 1000);
                for (AIResult r : results) {//遍历AI Task
                    EYEAIResult result = new EYEAIResult(r);
                    if (result.check()) { //判断是否为废数据
                        eyeaiResultDAO.insertSelective(result);
                        logger.info("成功插入:" + result.toString());
                        realC++;
                    } else {
                        noData++;
                    }
                }
                currentOffset += 1000;//偏移量+1000
                loopTime--;//循环-1
            }
        } else { //小于1000条数据，直接查询
            logger.info("病历表少于1000条，直接全部查询出来");
            List<AIResult> results = aiResultDAO.selectAll();
            for (AIResult r : results) {//遍历病历
                EYEAIResult result = new EYEAIResult(r);
                if (result.check()) { //判断是否为废数据
                    eyeaiResultDAO.insertSelective(result);
                    logger.info("成功插入:" + result.toString());
                    realC++;
                } else {
                    noData++;
                }
            }
        }
        logger.info("Step1:插入AI_Result数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);

        logger.info("Step2:插入AI_Task数据");
        c = aiTaskDAO.count();
        realC = 0;//实际插入记录数
        noData = 0;//非数据数量
        if (c > 1000) {
            logger.info("AI_Task超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<AITask> results = aiTaskDAO.selectPerPage(currentOffset, 1000);
                for (AITask r : results) {//遍历AI Task
                    EYEAITask result = new EYEAITask(r);
                    if (result.check()) { //判断是否为废数据
                        eyeaiTaskDAO.insertSelective(result);
                        logger.info("成功插入:" + result.toString());
                        realC++;
                    } else {
                        noData++;
                    }
                }
                currentOffset += 1000;//偏移量+1000
                loopTime--;//循环-1
            }
        } else { //小于1000条数据，直接查询
            logger.info("病历表少于1000条，直接全部查询出来");
            List<AITask> results = aiTaskDAO.selectAll();
            for (AITask r : results) {//遍历病历
                EYEAITask result = new EYEAITask(r);
                if (result.check()) { //判断是否为废数据
                    eyeaiTaskDAO.insertSelective(result);
                    logger.info("成功插入:" + result.toString());
                    realC++;
                } else {
                    noData++;
                }
            }
        }
        logger.info("Step2:插入AI_Task数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);

        logger.info("Step3:插入Screen_Interval数据");
        c = screenIntervalDAO.count();
        realC = 0;//实际插入记录数
        noData = 0;//非数据数量
        if (c > 1000) {
            logger.info("Screen_Interval超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<ScreenInterval> results = screenIntervalDAO.selectPerPage(currentOffset, 1000);
                for (ScreenInterval r : results) {//遍历AI Task
                    EYEScreenInterval result = new EYEScreenInterval(r);
                    if (result.check()) { //判断是否为废数据
                        eyeScreenIntervalDAO.insertSelective(result);
                        logger.info("成功插入:" + result.toString());
                        realC++;
                    } else {
                        noData++;
                    }
                }
                currentOffset += 1000;//偏移量+1000
                loopTime--;//循环-1
            }
        } else { //小于1000条数据，直接查询
            logger.info("病历表少于1000条，直接全部查询出来");
            List<ScreenInterval> results = screenIntervalDAO.selectAll();
            for (ScreenInterval r : results) {//遍历病历
                EYEScreenInterval result = new EYEScreenInterval(r);
                if (result.check()) { //判断是否为废数据
                    eyeScreenIntervalDAO.insertSelective(result);
                    logger.info("成功插入:" + result.toString());
                    realC++;
                } else {
                    noData++;
                }
            }
        }
        logger.info("Step3:插入Screen_Interval数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);
        logger.info("眼科普通数据迁移完毕");

//        int i = 1 / 0;
    }

    /**
     * 返回循环次数
     *
     * @param rows  每次显示的数量
     * @param count 总数
     * @return
     */
    private int returnLoopTime(int rows, int count) {
        return count % rows > 0 ? (count / rows) + 1 : count / rows;
    }

    @Resource
    private MedicalRecordDAO medicalRecordDao;

    @Resource
    private EyeMedicalRecordDAO eyeMedicalRecordDAO;


    @Override
    public void importMedicalData() {
        logger.info("开始迁移眼科病历数据...");

        logger.info("Step0:清空目标数据库数据");
        logger.info("共清空目标数据库数据：" + eyeMedicalRecordDAO.deleteAll() + "条");

        logger.info("Step1:插入基础数据");
        int c = medicalRecordDao.countByType(new int[]{4, 23});
        int realC = 0;//实际插入记录数
        int noData = 0;//非数据数量
        if (c > 1000) {
            logger.info("病历表超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<MedicalRecordDetail> records = medicalRecordDao.selectPerPageByType(currentOffset, 1000, new int[]{4, 23});
                for (MedicalRecordDetail r : records) {//遍历病历
                    EyeMedicalRecord emr = new EyeMedicalRecord(r);
                    if (emr.check()) { //判断是否为废数据
                        eyeMedicalRecordDAO.insertSelective(emr);
                        logger.info("成功插入:" + emr.toString());
                        realC++;
                    } else {
                        noData++;
                    }
                }
                currentOffset += 1000;//偏移量+1000
                loopTime--;//循环-1
            }
        } else { //小于1000条数据，直接查询
            logger.info("病历表少于1000条，直接全部查询出来");
            List<MedicalRecordDetail> records = medicalRecordDao.selectAllByType(new int[]{4, 23});
            for (MedicalRecordDetail r : records) {//遍历病历
                EyeMedicalRecord emr = new EyeMedicalRecord(r);
                if (emr.check()) { //判断是否为废数据
                    eyeMedicalRecordDAO.insertSelective(emr);
                    logger.info("成功插入:" + emr.toString());
                    realC++;
                } else {
                    noData++;
                }
            }
        }
        logger.info("Step1:插入基础数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);

        logger.info("Step2:更新病历表Attr Value");
        logger.info("开始更新eyeLeftImg数据");
        List<EYEMedicalRecord_UpdateAttrValue> eyeLeftImg = medicalRecordDao.selectAttrValue4EyeLeftImg();
        for (EYEMedicalRecord_UpdateAttrValue value : eyeLeftImg) {
            EyeMedicalRecord emr = new EyeMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getEyeLeftImg()))
                continue;
            eyeMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新eyeLeftImg数据完成");
        logger.info("开始更新eyeLeftVideo数据");
        List<EYEMedicalRecord_UpdateAttrValue> eyeLeftViedo = medicalRecordDao.selectAttrValue4EyeLeftVideo();
        for (EYEMedicalRecord_UpdateAttrValue value : eyeLeftViedo) {
            EyeMedicalRecord emr = new EyeMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getEyeLeftVideo()))
                continue;
            eyeMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新eyeLeftVideo数据完成");
        logger.info("开始更新eyeLeftVision数据");
        List<EYEMedicalRecord_UpdateAttrValue> eyeLeftVision = medicalRecordDao.selectAttrValue4EyeLeftVision();
        for (EYEMedicalRecord_UpdateAttrValue value : eyeLeftVision) {
            EyeMedicalRecord emr = new EyeMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getEyeLeftVision()))
                continue;
            logger.info("RecordId:" + emr.getRecordId() + ",EyeLeftVision:" + emr.getEyeLeftVision());
            eyeMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新eyeLeftVision数据完成");
        logger.info("开始更新eyeRightImg数据");
        List<EYEMedicalRecord_UpdateAttrValue> eyeRightImg = medicalRecordDao.selectAttrValue4EyeRightImg();
        for (EYEMedicalRecord_UpdateAttrValue value : eyeRightImg) {
            EyeMedicalRecord emr = new EyeMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getEyeRightImg()))
                continue;
            logger.info("EyeRightImg:" + emr.getEyeRightImg());
            eyeMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新eyeRightImg数据完成");
        logger.info("开始更新eyeRightVideo数据");
        List<EYEMedicalRecord_UpdateAttrValue> eyeRightVideo = medicalRecordDao.selectAttrValue4EyeRightVideo();
        for (EYEMedicalRecord_UpdateAttrValue value : eyeRightVideo) {
            EyeMedicalRecord emr = new EyeMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getEyeRightVideo()))
                continue;
            eyeMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新eyeRightVideo数据完成");
        logger.info("开始更新eyeRightVision数据");
        List<EYEMedicalRecord_UpdateAttrValue> eyeRightVision = medicalRecordDao.selectAttrValue4EyeRightVision();
        for (EYEMedicalRecord_UpdateAttrValue value : eyeRightVision) {
            EyeMedicalRecord emr = new EyeMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getEyeRightVision()))
                continue;
            eyeMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新eyeRightVision数据完成");
        logger.info("Step2:更新病历表Attr Value结束");

        /*logger.info("Step3:更新病历表冗余数据");
        List<MedicalRecord_UpdateRedundant> redundants = medicalRecordDao.selectRedundant4EYEMedicalRecord();
        for (MedicalRecord_UpdateRedundant r : redundants){
            EyeMedicalRecord emr = new EyeMedicalRecord(r);
            eyeMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("Step3:更新病历表冗余数据结束");*/

        logger.info("眼科病历数据迁移完毕");


//        int i = 1 / 0;
    }

    @Resource
    private EyeReportDAO eyeReportDAO;

    @Resource
    private ReportDAO reportDAO;

    @Override
    public void importReportData() {
        logger.info("开始迁移眼科报告数据...");

        logger.info("Step0:清空目标数据库数据");
        logger.info("共清空目标数据库数据：" + eyeReportDAO.deleteAll() + "条");

        logger.info("Step1:插入基础数据");
        int c = reportDAO.countByType(new int[]{4, 23});
        int realC = 0;//实际插入记录数
        int noData = 0;//非数据数量
        if (c > 1000) {
            logger.info("报告表超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<ReportDetail> records = reportDAO.selectPerPageByType(currentOffset, 1000, new int[]{4, 23});
                for (ReportDetail r : records) {//遍历病历
                    EyeReport emr = new EyeReport(r);
                    if (emr.check()) { //判断是否为废数据
                        eyeReportDAO.insertSelective(emr);
                        logger.info("成功插入:" + emr.toString());
                        realC++;
                    } else {
                        noData++;
                    }
                }
                currentOffset += 1000;//偏移量+1000
                loopTime--;//循环-1
            }
        } else { //小于1000条数据，直接查询
            logger.info("报告表少于1000条，直接全部查询出来");
            List<ReportDetail> records = reportDAO.selectAllByType(new int[]{4, 23});
            for (ReportDetail r : records) {//遍历病历
                EyeReport emr = new EyeReport(r);
                if (emr.check()) { //判断是否为废数据
                    eyeReportDAO.insertSelective(emr);
                    logger.info("成功插入:" + emr.toString());
                    realC++;
                } else {
                    noData++;
                }
            }
        }
        logger.info("Step1:插入基础数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);

        logger.info("Step2:更新眼科报告表Attr Value");
        logger.info("开始更新clinicalSymptom数据");
        List<EYEReport_UpdateAttrValue> clinicalSymptom = reportDAO.selectAttrValue4ClinicalSymptom();
        for (EYEReport_UpdateAttrValue value : clinicalSymptom) {
            EyeReport emr = new EyeReport(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getClinicalSymptom()))
                continue;
            eyeReportDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新clinicalSymptom数据完成");

        logger.info("开始更新eyeLeftVision数据");
        List<EYEReport_UpdateAttrValue> eyeLeftVision = reportDAO.selectAttrValue4EyeLeftVision();
        for (EYEReport_UpdateAttrValue value : eyeLeftVision) {
            EyeReport emr = new EyeReport(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getEyeLeftVision()))
                continue;
            eyeReportDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新eyeLeftVision数据完成");

        logger.info("开始更新eyeRightVision数据");
        List<EYEReport_UpdateAttrValue> eyeRightVision = reportDAO.selectAttrValue4EyeRightVision();
        for (EYEReport_UpdateAttrValue value : eyeRightVision) {
            EyeReport emr = new EyeReport(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getEyeRightVision()))
                continue;
            eyeReportDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新eyeRightVision数据完成");

        logger.info("开始更新eyeRightImg数据");
        List<EYEReport_UpdateAttrValue> eyeRightImg = reportDAO.selectAttrValue4EyeRightImg();
        for (EYEReport_UpdateAttrValue value : eyeRightImg) {
            EyeReport emr = new EyeReport(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getEyeRightImg()))
                continue;
            eyeReportDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新eyeRightImg数据完成");

        logger.info("开始更新eyeLeftImg数据");
        List<EYEReport_UpdateAttrValue> eyeLeftImg = reportDAO.selectAttrValue4EyeLeftImg();
        for (EYEReport_UpdateAttrValue value : eyeLeftImg) {
            EyeReport emr = new EyeReport(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getEyeLeftImg()))
                continue;
            eyeReportDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新eyeLeftImg数据完成");
        logger.info("Step2:更新病历表Attr Value结束");

        logger.info("Step3:更新报告表封面数据");
        realC = 0;//实际插入记录数
        noData = 0;//非数据数量
        if (c > 1000) {
            logger.info("报告表超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<EyeReport> records = eyeReportDAO.selectPerPage(currentOffset, 1000);
                for (EyeReport r : records) {//遍历病历
                    String cover = null;
                    try{
                        if(r.getEyeRightImg() != null && r.getEyeRightImg().length() > 0){
                            cover = r.getEyeRightImg().split(",")[0];
                        }else if(r.getEyeLeftImg() != null && r.getEyeLeftImg().length() > 0){
                            cover = r.getEyeLeftImg().split(",")[0];
                        }
                    }catch (IndexOutOfBoundsException e){
                        logger.info("无效的封面值:" + r.toString());
                        noData++;
                    }
                    if (cover != null){
                        eyeReportDAO.updateReportCoverByReportId(r.getReportId(),cover);
                        logger.info("成功更新封面:" + r.toString());
                        realC++;
                    }
                }
                currentOffset += 1000;//偏移量+1000
                loopTime--;//循环-1
            }
        } else { //小于1000条数据，直接查询
            logger.info("报告表少于1000条，直接全部查询出来");
            List<EyeReport> records = eyeReportDAO.selectAll();
            for (EyeReport r : records) {//遍历病历
                String cover = null;
                try{
                    if(r.getEyeRightImg() != null && r.getEyeRightImg().length() > 0){
                        cover = r.getEyeRightImg().split(",")[0];
                    }else if(r.getEyeLeftImg() != null && r.getEyeLeftImg().length() > 0){
                        cover = r.getEyeLeftImg().split(",")[0];
                    }
                }catch (IndexOutOfBoundsException e){
                    logger.info("无效的封面值:" + r.toString());
                    noData++;
                }
                if (cover != null){
                    eyeReportDAO.updateReportCoverByReportId(r.getReportId(),cover);
                    logger.info("成功更新封面:" + r.toString());
                    realC++;
                }
            }
        }
        logger.info("Step3:更新报告表封面数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);

        logger.info("眼科病报告数据迁移完毕");


//        int i = 1 / 0;
    }

    @Resource
    private EYEConsultationDAO eyeConsultationDAO;

    @Override
    public void importConsultationData() {
        logger.info("开始迁移眼科会诊数据...");
        logger.info("Step0:清空眼科会诊数据");
        logger.info("共清空目标数据库t_consultation数据：" + eyeConsultationDAO.deleteAll() + "条");
        logger.info("Step0:清空眼科会诊数据结束");
        logger.info("Step1:插入眼科会诊数据");
        List<EYEConsultation> consultations = medicalRecordDao.selectEyeConsultationFromProcess();
        int[] cIds = new int[consultations.size()];
        for(int i = 0; i < consultations.size(); i++){
            EYEConsultation c = consultations.get(i);
            eyeConsultationDAO.insertSelective(c);
            logger.info("成功插入:" + c.toString());
            cIds[i] = c.getRecordId();
        }
        logger.info("Step1:插入眼科会诊数据结束");

        logger.info("Step2:更新眼科报告数据");
        eyeReportDAO.updateReportTypeByRecordId(cIds);
        logger.info("Step2:更新眼科报告数据结束");
        logger.info("眼科会诊数据迁移完毕");
//        int i = 1 / 0;
    }


}
