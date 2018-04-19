package com.terrydr.domain.eye;

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
public class EYEMedicalRecord_UpdateAttrValue {
    private Integer recordId;
    private String eyeLeftVision;
    private String eyeRightVision;
    private String eyeLeftImg;
    private String eyeRightImg;
    private String eyeLeftVideo;
    private String eyeRightVideo;

    @Override
    public String toString() {
        return "EYEMedicalRecord_UpdateAttrValue{" +
                "recordId=" + recordId +
                ", eyeLeftVision='" + eyeLeftVision + '\'' +
                ", eyeRightVision='" + eyeRightVision + '\'' +
                ", eyeLeftImg='" + eyeLeftImg + '\'' +
                ", eyeRightImg='" + eyeRightImg + '\'' +
                ", eyeLeftVideo='" + eyeLeftVideo + '\'' +
                ", eyeRightVideo='" + eyeRightVideo + '\'' +
                '}';
    }

    public Integer getRecordId() {
        return recordId;
    }

    public String getEyeLeftVision() {
        return eyeLeftVision;
    }

    public void setEyeLeftVision(String eyeLeftVision) {
        this.eyeLeftVision = eyeLeftVision;
    }

    public String getEyeRightVision() {
        return eyeRightVision;
    }

    public void setEyeRightVision(String eyeRightVision) {
        this.eyeRightVision = eyeRightVision;
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

    public String getEyeLeftVideo() {
        return eyeLeftVideo;
    }

    public void setEyeLeftVideo(String eyeLeftVideo) {
        this.eyeLeftVideo = eyeLeftVideo;
    }

    public String getEyeRightVideo() {
        return eyeRightVideo;
    }

    public void setEyeRightVideo(String eyeRightVideo) {
        this.eyeRightVideo = eyeRightVideo;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

}
