package com.terrydr.domain.ecg;

/**
 * @author zyyan@terrydr.com
 * @version 1.0.0
 * @desc attr_id:33 heartRate,34 classification<br>
 * <p>
 * Copyright: Copyright (c)
 * <p>
 * Company: 南京泰立瑞信息科技有限公司
 * <p>
 */
public class ECGMedicalRecord_UpdateAttrValue {
    private Integer recordId;
    private String heartRate;
    private String classification;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
