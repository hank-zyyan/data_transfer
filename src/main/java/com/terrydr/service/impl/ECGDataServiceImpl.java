package com.terrydr.service.impl;

import com.terrydr.dao.basic.MedicalRecordDAO;
import com.terrydr.dao.ecg.ECGMedicalRecordDAO;
import com.terrydr.domain.MedicalRecordDetail;
import com.terrydr.domain.ecg.ECGMedicalRecord;
import com.terrydr.domain.ecg.ECGMedicalRecord_UpdateAttrValue;
import com.terrydr.service.ECGDataService;
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
@Transactional(value = "ecgTransactionManager")
public class ECGDataServiceImpl implements ECGDataService {

    private Logger logger = LoggerFactory.getLogger(ECGDataServiceImpl.class);

    @Resource
    private MedicalRecordDAO medicalRecordDao;

    @Resource
    private ECGMedicalRecordDAO ecgMedicalRecordDao;

    @Override
    public void importMedicalData() {
        logger.info("开始迁移ECG数据...");

        logger.info("Step0:清空目标数据库数据");
        logger.info("共清空目标数据库数据：" + ecgMedicalRecordDao.deleteAll() + "条");

        logger.info("Step1:插入基础数据");
        int c = medicalRecordDao.countByType(new int[]{1});
        int realC = 0;//实际插入记录数
        int noData = 0;//非数据数量
        if (c > 1000) {
            logger.info("病历表超过1000条，进行分页读取，每次取1000");
            int currentOffset = 0;//初始化偏移量为0
            int loopTime = returnLoopTime(1000, c);//循环次数
            while (loopTime > 0) { //偏移量每次递增1000，当偏移量超过总数时，循环结束
                List<MedicalRecordDetail> records = medicalRecordDao.selectPerPageByType(currentOffset, 1000, new int[]{1});
                for (MedicalRecordDetail r : records) {//遍历病历
                    ECGMedicalRecord emr = new ECGMedicalRecord(r);
                    if (emr.check()) { //判断是否为废数据
                        ecgMedicalRecordDao.insertSelective(emr);
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
            List<MedicalRecordDetail> records = medicalRecordDao.selectAllByType(new int[]{1});
            for (MedicalRecordDetail r : records) {//遍历病历
                ECGMedicalRecord emr = new ECGMedicalRecord(r);
                if (emr.check()) { //判断是否为废数据
                    ecgMedicalRecordDao.insertSelective(emr);
                    logger.info("成功插入:" + emr.toString());
                    realC++;
                } else {
                    noData++;
                }
            }
        }
        logger.info("Step1:插入基础数据结束，数据总数：" + c + "，实际插入数：" + realC + ", 废数据数量：" + noData);

        logger.info("Step2:更新病历表Attr Value");
        //attr_id:33 heartRate,34 classification
        logger.info("开始更新heartRate数据");
        List<ECGMedicalRecord_UpdateAttrValue> heartRateValues = medicalRecordDao.selectAttrValue4HeartRate();
        for (ECGMedicalRecord_UpdateAttrValue value : heartRateValues){
            ECGMedicalRecord emr = new ECGMedicalRecord(value);
            ecgMedicalRecordDao.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新heartRate数据完成");
        logger.info("开始更新classification数据");
        List<ECGMedicalRecord_UpdateAttrValue> cRateValues = medicalRecordDao.selectAttrValue4Classification();
        for (ECGMedicalRecord_UpdateAttrValue value : cRateValues){
            ECGMedicalRecord emr = new ECGMedicalRecord(value);
            ecgMedicalRecordDao.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("更新classification数据完成");
        logger.info("Step2:更新病历表Attr Value结束");

        /*logger.info("Step3:更新病历表冗余数据");
        List<MedicalRecord_UpdateRedundant> redundants = medicalRecordDao.selectRedundant4ECGMedicalRecord();
        for (MedicalRecord_UpdateRedundant r : redundants){
            ECGMedicalRecord emr = new ECGMedicalRecord(r);
            ecgMedicalRecordDao.updateByPrimaryKeySelective(emr);
            logger.info("成功更新:" + emr.toString());
        }
        logger.info("Step3:更新病历表冗余数据结束");*/

        logger.info("ECG数据迁移完毕");


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
}
