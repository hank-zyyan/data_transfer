package com.terrydr.domain.eye;

/**
 * @author zyyan@terrydr.com
 * @version 1.0.0
 * @desc :11 clinicalSymptom,<br>
 *     7 eyeLeftVision,8 eyeRightVision<br>
 *         9 eyeLeftImg,10 eyeRightImg<br>
 * <p>
 * Copyright: Copyright (c)
 * <p>
 * Company: 南京泰立瑞信息科技有限公司
 * <p>
 */
public class EYEReport_UpdateAttrValue {
    private Integer reportId;
    private String clinicalSymptom;
    private String eyeLeftVision;
    private String eyeRightVision;
    private String eyeLeftImg;
    private String eyeRightImg;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getClinicalSymptom() {
        return clinicalSymptom;
    }

    public void setClinicalSymptom(String clinicalSymptom) {
        this.clinicalSymptom = clinicalSymptom;
    }

    public String getEyeLeftVision() {
        return eyeLeftVision;
    }

    public void setEyeLeftVision(String eyeLeftVision) {
        try{
            Double.parseDouble(eyeLeftVision);
            this.eyeLeftVision = eyeLeftVision;
        }catch (Exception e){
            this.eyeLeftVision = "";
        }
    }

    public String getEyeRightVision() {
        return eyeRightVision;
    }

    public void setEyeRightVision(String eyeRightVision) {
        try{
            Double.parseDouble(eyeRightVision);
            this.eyeRightVision = eyeRightVision;
        }catch (Exception e){
            this.eyeRightVision = "";
        }
    }

    public String getEyeLeftImg() {
        return eyeLeftImg;
    }

    public void setEyeLeftImg(String eyeLeftImg) {
        this.eyeLeftImg = eyeLeftImg;
    }

    public String getEyeRightImg() {
        return eyeRightImg;
    }

    public void setEyeRightImg(String eyeRightImg) {
        this.eyeRightImg = eyeRightImg;
    }
}
