package com.terrydr.service.impl;

import com.mysql.jdbc.StringUtils;
import com.terrydr.dao.basic.*;
import com.terrydr.dao.pathology.*;
import com.terrydr.domain.*;
import com.terrydr.domain.PathologyAnnotation;
import com.terrydr.domain.PathologyConsultation;
import com.terrydr.domain.pathology.*;
import com.terrydr.service.PathologyDataService;
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
@Transactional(value = "pathologyTransactionManager")
public class PathologyDataServiceImpl implements PathologyDataService {

    private Logger logger = LoggerFactory.getLogger(PathologyDataServiceImpl.class);

    @Resource
    private PathologyAnnotationDAO pA;

    @Resource
    private PathAnnotationDAO ppA;

    @Resource
    private PathologyConsultationDAO pC;

    @Resource
    private PathConsultationDAO ppC;

    @Resource
    private PathologyInfoDAO p;

    @Resource
    private PathPathologyInfoDAO pp;

    @Resource
    private PathologyInfoDetailDAO pD;

    @Resource
    private PathPathologyInfoDetailDAO ppD;

    @Override
    public void importCommonData() {
        logger.info("开始迁移镜下普通数据...");

        logger.info("Step0:清空目标数据库数据");
        logger.info("共清空目标数据库Annotation数据：" + ppA.deleteAll() + "条");
        logger.info("共清空目标数据库Consultation数据：" + ppC.deleteAll() + "条");
        logger.info("共清空目标数据库Pathology数据：" + pp.deleteAll() + "条");
        logger.info("共清空目标数据库Pathology_Detail数据：" + ppD.deleteAll() + "条");

       logger.info("Step1:插入Pathology数据");
        int c = p.count();
        int realC = 0;//实际插入记录数
        int noData = 0;//非数据数量
         if (c > 1000) {
            logger.info("Pathology超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<PathologyInfo> results = p.selectPerPage(currentOffset, 1000);
                for (PathologyInfo r : results) {//遍历AI Task
                    Pathology result = new Pathology(r);
                    if (result.check()) { //判断是否为废数据
                        logger.info("Resolution:" + result.getResolution());
                        pp.insertSelective(result);
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
            List<PathologyInfo> results = p.selectAll();
            for (PathologyInfo r : results) {//遍历病历
                Pathology result = new Pathology(r);
                if (result.check()) { //判断是否为废数据
                    pp.insertSelective(result);
                    logger.info("成功插入:" + result.toString());
                    realC++;
                } else {
                    noData++;
                }
            }
        }
        logger.info("Step1:插入Pathology数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);

        logger.info("Step2:插入Pathology_Detail数据");
        c = pD.count();
        realC = 0;//实际插入记录数
        noData = 0;//非数据数量
        if (c > 1000) {
            logger.info("Pathology_Detail超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<PathologyInfoDetail> results = pD.selectPerPage(currentOffset, 1000);
                for (PathologyInfoDetail r : results) {//遍历AI Task
                    PathologyDetail result = new PathologyDetail(r);
                    if (result.check()) { //判断是否为废数据
                        ppD.insertSelective(result);
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
            logger.info("Pathology_Detail表少于1000条，直接全部查询出来");
            List<PathologyInfoDetail> results = pD.selectAll();
            for (PathologyInfoDetail r : results) {//遍历病历
                PathologyDetail result = new PathologyDetail(r);
                if (result.check()) { //判断是否为废数据
                    ppD.insertSelective(result);
                    logger.info("成功插入:" + result.toString());
                    realC++;
                } else {
                    noData++;
                }
            }
        }
        logger.info("Step2:插入Pathology_Detail数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);

        logger.info("Step3:插入Pathology_Annotation数据");
        c = pA.count();
        realC = 0;//实际插入记录数
        noData = 0;//非数据数量
        if (c > 1000) {
            logger.info("Pathology_Annotation超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<PathologyAnnotation> results = pA.selectPerPage(currentOffset, 1000);
                for (PathologyAnnotation r : results) {//遍历AI Task
                    com.terrydr.domain.pathology.PathologyAnnotation result = new com.terrydr.domain.pathology.PathologyAnnotation(r);
                    if (result.check()) { //判断是否为废数据
                        ppA.insertSelective(result);
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
            logger.info("Pathology_Annotation表少于1000条，直接全部查询出来");
            List<PathologyAnnotation> results = pA.selectAll();
            for (PathologyAnnotation r : results) {//遍历病历
                com.terrydr.domain.pathology.PathologyAnnotation result = new com.terrydr.domain.pathology.PathologyAnnotation(r);
                if (result.check()) { //判断是否为废数据
                    ppA.insertSelective(result);
                    logger.info("成功插入:" + result.toString());
                    realC++;
                } else {
                    noData++;
                }
            }
        }
        logger.info("Step3:插入Pathology_Annotation数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);


        logger.info("Step4:插入Pathology_Consultation数据");
        c = pC.count();
        realC = 0;//实际插入记录数
        noData = 0;//非数据数量
        if (c > 1000) {
            logger.info("Pathology_Consultation超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<PathologyConsultation> results = pC.selectPerPage(currentOffset, 1000);
                for (PathologyConsultation r : results) {//遍历AI Task
                    com.terrydr.domain.pathology.PathologyConsultation result = new com.terrydr.domain.pathology.PathologyConsultation(r);
                    if (result.check()) { //判断是否为废数据
                        ppC.insertSelective(result);
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
            logger.info("Pathology_Consultation表少于1000条，直接全部查询出来");
            List<PathologyConsultation> results = pC.selectAll();
            for (PathologyConsultation r : results) {//遍历病历
                com.terrydr.domain.pathology.PathologyConsultation result = new com.terrydr.domain.pathology.PathologyConsultation(r);
                if (result.check()) { //判断是否为废数据
                    ppC.insertSelective(result);
                    logger.info("成功插入:" + result.toString());
                    realC++;
                } else {
                    noData++;
                }
            }
        }
        logger.info("Step3:插入Pathology_Consultation数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);

        logger.info("镜下普通数据迁移完毕");

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
    private PathMedicalRecordDAO pathMedicalRecordDAO;


    @Override
    public void importMedicalData() {
        logger.info("开始迁移镜下病历数据...");

        logger.info("Step0:清空目标数据库数据");
        logger.info("共清空目标数据库数据：" + pathMedicalRecordDAO.deleteAll() + "条");

        logger.info("Step1:插入基础数据");
        int c = medicalRecordDao.countWithoutType(new int[]{1, 4, 23});
        int realC = 0;//实际插入记录数
        int noData = 0;//非数据数量
        if (c > 1000) {
            logger.info("病历表超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<MedicalRecordDetail> records = medicalRecordDao.selectPerPageWithoutType(currentOffset, 1000, new int[]{1, 4, 23});
                for (MedicalRecordDetail r : records) {//遍历病历
                    PathologyMedicalRecord emr = new PathologyMedicalRecord(r);
                    if (emr.check()) { //判断是否为废数据
                        pathMedicalRecordDAO.insertSelective(emr);
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
            List<MedicalRecordDetail> records = medicalRecordDao.selectAllWithoutType(new int[]{1, 4, 23});
            for (MedicalRecordDetail r : records) {//遍历病历
                PathologyMedicalRecord emr = new PathologyMedicalRecord(r);
                if (emr.check()) { //判断是否为废数据
                    pathMedicalRecordDAO.insertSelective(emr);
                    logger.info("成功插入:" + emr.toString());
                    realC++;
                } else {
                    noData++;
                }
            }
        }
        logger.info("Step1:插入基础数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);

        logger.info("Step2:更新病历表Attr Value");
        logger.info("开始更新submitDepartment数据");
        List<PathologyMedicalRecord_UpdateAttrValue> eyeLeftImg = medicalRecordDao.selectAttrValue4SubmitDepartment();
        for (PathologyMedicalRecord_UpdateAttrValue value : eyeLeftImg) {
            PathologyMedicalRecord emr = new PathologyMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getSubmitDepartment()))
                continue;
            pathMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新submitDepartment数据完成");
        logger.info("开始更新submitUnit数据");
        List<PathologyMedicalRecord_UpdateAttrValue> eyeLeftViedo = medicalRecordDao.selectAttrValue4SubmitUnit();
        for (PathologyMedicalRecord_UpdateAttrValue value : eyeLeftViedo) {
            PathologyMedicalRecord emr = new PathologyMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getSubmitUnit()))
                continue;
            pathMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新submitUnit数据完成");
        logger.info("开始更新submitDoctor数据");
        List<PathologyMedicalRecord_UpdateAttrValue> eyeLeftVision = medicalRecordDao.selectAttrValue4SubmitDoctor();
        for (PathologyMedicalRecord_UpdateAttrValue value : eyeLeftVision) {
            PathologyMedicalRecord emr = new PathologyMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getSubmitDoctor()))
                continue;
            pathMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新submitDoctor数据完成");
        logger.info("开始更新submitDate数据");
        List<PathologyMedicalRecord_UpdateAttrValue> eyeRightImg = medicalRecordDao.selectAttrValue4SubmitDate();
        for (PathologyMedicalRecord_UpdateAttrValue value : eyeRightImg) {
            PathologyMedicalRecord emr = new PathologyMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getSubmitDate()))
                continue;
            pathMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新submitDate数据完成");
        logger.info("开始更新submitMaterial数据");
        List<PathologyMedicalRecord_UpdateAttrValue> eyeRightVideo = medicalRecordDao.selectAttrValue4SubmitMaterial();
        for (PathologyMedicalRecord_UpdateAttrValue value : eyeRightVideo) {
            PathologyMedicalRecord emr = new PathologyMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getSubmitMaterial()))
                continue;
            pathMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新submitMaterial数据完成");
        logger.info("开始更新visualFeature数据");
        List<PathologyMedicalRecord_UpdateAttrValue> eyeRightVision = medicalRecordDao.selectAttrValue4VisualFeature();
        for (PathologyMedicalRecord_UpdateAttrValue value : eyeRightVision) {
            PathologyMedicalRecord emr = new PathologyMedicalRecord(value);
            if(StringUtils.isEmptyOrWhitespaceOnly(emr.getVisualFeature()))
                continue;
            pathMedicalRecordDAO.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新visualFeature数据完成");
        logger.info("Step2:更新病历表Attr Value结束");

        logger.info("镜下病历数据迁移完毕");


//        int i = 1 / 0;
    }

    @Resource
    private ReportDAO reportDAO;

    @Resource
    private PathologyReportDAO pathologyReportDAO;

    @Resource
    private ReportAttrDAO reportAttrDAO;

    @Resource
    private PathologyReportAttrDAO pathologyReportAttrDAO;

    @Resource
    private ReportValueDAO reportValueDAO;

    @Resource
    private PathologyReportValueDAO pathologyReportValueDAO;


    @Override
    public void importReportData() {
        logger.info("开始迁移镜下报告数据...");

        logger.info("Step0:清空目标数据库数据");
        logger.info("共清空目标数据库Pathology_Report数据：" + pathologyReportDAO.deleteAll() + "条");
        logger.info("共清空目标数据库Pathology_Report_Attr数据：" + pathologyReportAttrDAO.deleteAll() + "条");
        logger.info("共清空目标数据库Pathology_Report_Value数据：" + pathologyReportValueDAO.deleteAll() + "条");

        logger.info("Step1:插入基础数据");
        List<PathologyReportDetail> records = reportDAO.selectPathologyReportDetail();
        for (PathologyReportDetail r : records) {//遍历病历
            PathologyReport emr = new PathologyReport(r);
            pathologyReportDAO.insertSelective(emr);
            logger.info("成功插入:" + emr.toString());
        }
        logger.info("Step1:插入基础数据结束");

        logger.info("Step2:插入Report_Attr数据");
        List<ReportAttr> records1 = reportAttrDAO.selectWithoutAttrId(new int[]{-1});
        for (ReportAttr r : records1) {//遍历病历
            PathologyReportAttr emr = new PathologyReportAttr(r);
            pathologyReportAttrDAO.insertSelective(emr);
            logger.info("成功插入:" + emr.toString());
        }
        reportAttrDAO.updateReportAttrStatus(new int[]{4,5,6,138,139,142,149,179,182,195,196,198,215});
        logger.info("Step2:插入Report_Attr数据结束");

        logger.info("Step3:插入Report_Value数据");
        List<ReportValue> records2 = reportValueDAO.selectWithoutAttrId(new int[]{-1});
        for (ReportValue r : records2) {//遍历病历
            PathologyReportValue emr = new PathologyReportValue(r);
            pathologyReportValueDAO.insertSelective(emr);
            logger.info("成功插入:" + emr.toString());
        }
        logger.info("Step3:插入Report_Value数据结束");

        logger.info("镜下报告数据迁移完毕");

//        int i = 1 / 0;
    }


}
