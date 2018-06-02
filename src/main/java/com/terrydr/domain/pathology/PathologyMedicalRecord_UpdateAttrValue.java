package com.terrydr.domain.pathology;

/**
 * @author zyyan@terrydr.com
 * @version 1.0.0
 * @desc :42 eyeLeftVision,43 eyeRightVision<br>
 *     19 eyeLeftImg,20 eyeRightImg<br>
 *         31 eyeLeftVideo,32 eyeRightVideo<br>
 * <p>
 * Copyright: Copyright (c)
 * <p>
 * Company: 南京泰立瑞信息科技有限公司
 * <p>
 */
public class PathologyMedicalRecord_UpdateAttrValue {
    private Integer recordId;
    private String submitDepartment;
    private String submitUnit;
    private String submitDoctor;
    private String submitDate;
    private String submitMaterial;
    private String visualFeature;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getSubmitDepartment() {
        return submitDepartment;
    }

    public void setSubmitDepartment(String submitDepartment) {
        this.submitDepartment = submitDepartment;
    }

    public String getSubmitUnit() {
        return submitUnit;
    }

    public void setSubmitUnit(String submitUnit) {
        this.submitUnit = submitUnit;
    }

    public String getSubmitDoctor() {
        return submitDoctor;
    }

    public void setSubmitDoctor(String submitDoctor) {
        this.submitDoctor = submitDoctor;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getSubmitMaterial() {
        return submitMaterial;
    }

    public void setSubmitMaterial(String submitMaterial) {
        this.submitMaterial = submitMaterial;
    }

    public String getVisualFeature() {
        return visualFeature;
    }

    public void setVisualFeature(String visualFeature) {
        this.visualFeature = visualFeature;
    }
}
