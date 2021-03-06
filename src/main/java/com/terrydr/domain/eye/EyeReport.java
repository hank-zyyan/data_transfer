package com.terrydr.domain.eye;

import com.terrydr.domain.FatherBean;
import com.terrydr.domain.ReportDetail;

import java.util.Date;

public class EyeReport extends FatherBean {

    public EyeReport(Integer reportId, String eyeLeftImg, String eyeRightImg) {
        this.reportId = reportId;
        this.eyeLeftImg = eyeLeftImg;
        this.eyeRightImg = eyeRightImg;
    }

    public EyeReport(EYEReport_UpdateAttrValue value) {
        this.reportId = value.getReportId();
        this.clinicalSymptom = value.getClinicalSymptom();
        this.eyeLeftImg = value.getEyeLeftImg();
        this.eyeLeftVision = value.getEyeLeftVision();
        this.eyeRightImg = value.getEyeRightImg();
        this.eyeRightVision = value.getEyeRightVision();
    }

    @Override
    public String toString() {
        return "眼科报告（ID=" + this.reportId + "）";
    }

    public EyeReport(ReportDetail detail) {
        this.reportId = detail.getReportId();
        this.shareId = detail.getShareId();
        this.recordType = detail.getReportType();
        this.reportType = detail.getDoctorId().equals(detail.getBaseDoctorId()) ? 3 : 2; //如果2个医生id不同，则是会诊，反之则为诊断报告
        this.doctorId = detail.getDoctorId();
        this.doctorName = detail.getDoctorName();
        this.doctorTeleno = detail.getDoctorTeleno();
        this.doctorAvatar = detail.getDoctorAvatar();
        this.patientId = detail.getPatientId();
        this.recordId = detail.getRecordId();
        this.hospitalId = detail.getHospitalId();
        this.hospitalName = detail.getHospitalName();
        this.reportHospId = detail.getReportHospId();
        this.reportHospName = detail.getReportHospName();
        this.submitUnit = detail.getSubmitUnit();
        this.submitDoctor = detail.getSubmitDoctor();
        this.submitDepartment = detail.getSubmitDepartment();
        this.admissionNo = detail.getAdmissionNo();
        this.examDate = detail.getExamDate();
        this.bedNo = detail.getBedNo();
        this.clinicalDiagnosis = detail.getClinicalDiagnosis();
        this.reportImg = detail.getReportImg();
        this.createTime = detail.getCreateTime();
        this.remarks = detail.getRemarks();
        this.isEnterprise = detail.getIsEnterprise();
        this.isDeleted = detail.getIsDeleted();
    }

    public String getReportCover() {
        return reportCover;
    }

    public void setReportCover(String reportCover) {
        this.reportCover = reportCover;
    }

    private String reportCover;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.report_id
     *
     * @mbg.generated
     */
    private Integer reportId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.share_id
     *
     * @mbg.generated
     */
    private String shareId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.record_type
     *
     * @mbg.generated
     */
    private Integer recordType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.report_type
     *
     * @mbg.generated
     */
    private Integer reportType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.doctor_id
     *
     * @mbg.generated
     */
    private Integer doctorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.doctor_name
     *
     * @mbg.generated
     */
    private String doctorName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.doctor_teleno
     *
     * @mbg.generated
     */
    private String doctorTeleno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.doctor_avatar
     *
     * @mbg.generated
     */
    private String doctorAvatar;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.patient_id
     *
     * @mbg.generated
     */
    private Integer patientId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.record_id
     *
     * @mbg.generated
     */
    private Integer recordId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.hospital_id
     *
     * @mbg.generated
     */
    private Integer hospitalId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.hospital_name
     *
     * @mbg.generated
     */
    private String hospitalName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.report_hosp_id
     *
     * @mbg.generated
     */
    private Integer reportHospId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.report_hosp_name
     *
     * @mbg.generated
     */
    private String reportHospName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.submit_unit
     *
     * @mbg.generated
     */
    private String submitUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.submit_doctor
     *
     * @mbg.generated
     */
    private String submitDoctor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.submit_department
     *
     * @mbg.generated
     */
    private String submitDepartment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.admission_no
     *
     * @mbg.generated
     */
    private String admissionNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.exam_date
     *
     * @mbg.generated
     */
    private Date examDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.bed_no
     *
     * @mbg.generated
     */
    private String bedNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.clinical_symptom
     *
     * @mbg.generated
     */
    private String clinicalSymptom;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.clinical_diagnosis
     *
     * @mbg.generated
     */
    private String clinicalDiagnosis;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.report_img
     *
     * @mbg.generated
     */
    private String reportImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.eye_left_vision
     *
     * @mbg.generated
     */
    private String eyeLeftVision;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.eye_right_vision
     *
     * @mbg.generated
     */
    private String eyeRightVision;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.eye_left_img
     *
     * @mbg.generated
     */
    private String eyeLeftImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.eye_right_img
     *
     * @mbg.generated
     */
    private String eyeRightImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.remarks
     *
     * @mbg.generated
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.is_enterprise
     *
     * @mbg.generated
     */
    private Integer isEnterprise;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.electronic_signature
     *
     * @mbg.generated
     */
    private String electronicSignature;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.is_deleted
     *
     * @mbg.generated
     */
    private Integer isDeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.report_id
     *
     * @return the value of t_report.report_id
     * @mbg.generated
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.report_id
     *
     * @param reportId the value for t_report.report_id
     * @mbg.generated
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.share_id
     *
     * @return the value of t_report.share_id
     * @mbg.generated
     */
    public String getShareId() {
        return shareId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.share_id
     *
     * @param shareId the value for t_report.share_id
     * @mbg.generated
     */
    public void setShareId(String shareId) {
        this.shareId = shareId == null ? null : shareId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.record_type
     *
     * @return the value of t_report.record_type
     * @mbg.generated
     */
    public Integer getRecordType() {
        return recordType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.record_type
     *
     * @param recordType the value for t_report.record_type
     * @mbg.generated
     */
    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.report_type
     *
     * @return the value of t_report.report_type
     * @mbg.generated
     */
    public Integer getReportType() {
        return reportType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.report_type
     *
     * @param reportType the value for t_report.report_type
     * @mbg.generated
     */
    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.doctor_id
     *
     * @return the value of t_report.doctor_id
     * @mbg.generated
     */
    public Integer getDoctorId() {
        return doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.doctor_id
     *
     * @param doctorId the value for t_report.doctor_id
     * @mbg.generated
     */
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.doctor_name
     *
     * @return the value of t_report.doctor_name
     * @mbg.generated
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.doctor_name
     *
     * @param doctorName the value for t_report.doctor_name
     * @mbg.generated
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.doctor_teleno
     *
     * @return the value of t_report.doctor_teleno
     * @mbg.generated
     */
    public String getDoctorTeleno() {
        return doctorTeleno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.doctor_teleno
     *
     * @param doctorTeleno the value for t_report.doctor_teleno
     * @mbg.generated
     */
    public void setDoctorTeleno(String doctorTeleno) {
        this.doctorTeleno = doctorTeleno == null ? null : doctorTeleno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.doctor_avatar
     *
     * @return the value of t_report.doctor_avatar
     * @mbg.generated
     */
    public String getDoctorAvatar() {
        return doctorAvatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.doctor_avatar
     *
     * @param doctorAvatar the value for t_report.doctor_avatar
     * @mbg.generated
     */
    public void setDoctorAvatar(String doctorAvatar) {
        this.doctorAvatar = doctorAvatar == null ? null : doctorAvatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.patient_id
     *
     * @return the value of t_report.patient_id
     * @mbg.generated
     */
    public Integer getPatientId() {
        return patientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.patient_id
     *
     * @param patientId the value for t_report.patient_id
     * @mbg.generated
     */
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.record_id
     *
     * @return the value of t_report.record_id
     * @mbg.generated
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.record_id
     *
     * @param recordId the value for t_report.record_id
     * @mbg.generated
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.hospital_id
     *
     * @return the value of t_report.hospital_id
     * @mbg.generated
     */
    public Integer getHospitalId() {
        return hospitalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.hospital_id
     *
     * @param hospitalId the value for t_report.hospital_id
     * @mbg.generated
     */
    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.hospital_name
     *
     * @return the value of t_report.hospital_name
     * @mbg.generated
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.hospital_name
     *
     * @param hospitalName the value for t_report.hospital_name
     * @mbg.generated
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName == null ? null : hospitalName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.report_hosp_id
     *
     * @return the value of t_report.report_hosp_id
     * @mbg.generated
     */
    public Integer getReportHospId() {
        return reportHospId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.report_hosp_id
     *
     * @param reportHospId the value for t_report.report_hosp_id
     * @mbg.generated
     */
    public void setReportHospId(Integer reportHospId) {
        this.reportHospId = reportHospId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.report_hosp_name
     *
     * @return the value of t_report.report_hosp_name
     * @mbg.generated
     */
    public String getReportHospName() {
        return reportHospName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.report_hosp_name
     *
     * @param reportHospName the value for t_report.report_hosp_name
     * @mbg.generated
     */
    public void setReportHospName(String reportHospName) {
        this.reportHospName = reportHospName == null ? null : reportHospName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.submit_unit
     *
     * @return the value of t_report.submit_unit
     * @mbg.generated
     */
    public String getSubmitUnit() {
        return submitUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.submit_unit
     *
     * @param submitUnit the value for t_report.submit_unit
     * @mbg.generated
     */
    public void setSubmitUnit(String submitUnit) {
        this.submitUnit = submitUnit == null ? null : submitUnit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.submit_doctor
     *
     * @return the value of t_report.submit_doctor
     * @mbg.generated
     */
    public String getSubmitDoctor() {
        return submitDoctor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.submit_doctor
     *
     * @param submitDoctor the value for t_report.submit_doctor
     * @mbg.generated
     */
    public void setSubmitDoctor(String submitDoctor) {
        this.submitDoctor = submitDoctor == null ? null : submitDoctor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.submit_department
     *
     * @return the value of t_report.submit_department
     * @mbg.generated
     */
    public String getSubmitDepartment() {
        return submitDepartment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.submit_department
     *
     * @param submitDepartment the value for t_report.submit_department
     * @mbg.generated
     */
    public void setSubmitDepartment(String submitDepartment) {
        this.submitDepartment = submitDepartment == null ? null : submitDepartment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.admission_no
     *
     * @return the value of t_report.admission_no
     * @mbg.generated
     */
    public String getAdmissionNo() {
        return admissionNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.admission_no
     *
     * @param admissionNo the value for t_report.admission_no
     * @mbg.generated
     */
    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo == null ? null : admissionNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.exam_date
     *
     * @return the value of t_report.exam_date
     * @mbg.generated
     */
    public Date getExamDate() {
        return examDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.exam_date
     *
     * @param examDate the value for t_report.exam_date
     * @mbg.generated
     */
    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.bed_no
     *
     * @return the value of t_report.bed_no
     * @mbg.generated
     */
    public String getBedNo() {
        return bedNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.bed_no
     *
     * @param bedNo the value for t_report.bed_no
     * @mbg.generated
     */
    public void setBedNo(String bedNo) {
        this.bedNo = bedNo == null ? null : bedNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.clinical_symptom
     *
     * @return the value of t_report.clinical_symptom
     * @mbg.generated
     */
    public String getClinicalSymptom() {
        return clinicalSymptom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.clinical_symptom
     *
     * @param clinicalSymptom the value for t_report.clinical_symptom
     * @mbg.generated
     */
    public void setClinicalSymptom(String clinicalSymptom) {
        this.clinicalSymptom = clinicalSymptom == null ? null : clinicalSymptom.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.clinical_diagnosis
     *
     * @return the value of t_report.clinical_diagnosis
     * @mbg.generated
     */
    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.clinical_diagnosis
     *
     * @param clinicalDiagnosis the value for t_report.clinical_diagnosis
     * @mbg.generated
     */
    public void setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis == null ? null : clinicalDiagnosis.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.report_img
     *
     * @return the value of t_report.report_img
     * @mbg.generated
     */
    public String getReportImg() {
        return reportImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.report_img
     *
     * @param reportImg the value for t_report.report_img
     * @mbg.generated
     */
    public void setReportImg(String reportImg) {
        this.reportImg = reportImg == null ? null : reportImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.eye_left_vision
     *
     * @return the value of t_report.eye_left_vision
     * @mbg.generated
     */
    public String getEyeLeftVision() {
        return eyeLeftVision;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.eye_left_vision
     *
     * @param eyeLeftVision the value for t_report.eye_left_vision
     * @mbg.generated
     */
    public void setEyeLeftVision(String eyeLeftVision) {
        this.eyeLeftVision = eyeLeftVision == null ? null : eyeLeftVision.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.eye_right_vision
     *
     * @return the value of t_report.eye_right_vision
     * @mbg.generated
     */
    public String getEyeRightVision() {
        return eyeRightVision;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.eye_right_vision
     *
     * @param eyeRightVision the value for t_report.eye_right_vision
     * @mbg.generated
     */
    public void setEyeRightVision(String eyeRightVision) {
        this.eyeRightVision = eyeRightVision == null ? null : eyeRightVision.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.eye_left_img
     *
     * @return the value of t_report.eye_left_img
     * @mbg.generated
     */
    public String getEyeLeftImg() {
        return eyeLeftImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.eye_left_img
     *
     * @param eyeLeftImg the value for t_report.eye_left_img
     * @mbg.generated
     */
    public void setEyeLeftImg(String eyeLeftImg) {
        this.eyeLeftImg = eyeLeftImg == null ? null : eyeLeftImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.eye_right_img
     *
     * @return the value of t_report.eye_right_img
     * @mbg.generated
     */
    public String getEyeRightImg() {
        return eyeRightImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.eye_right_img
     *
     * @param eyeRightImg the value for t_report.eye_right_img
     * @mbg.generated
     */
    public void setEyeRightImg(String eyeRightImg) {
        this.eyeRightImg = eyeRightImg == null ? null : eyeRightImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.create_time
     *
     * @return the value of t_report.create_time
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.create_time
     *
     * @param createTime the value for t_report.create_time
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.remarks
     *
     * @return the value of t_report.remarks
     * @mbg.generated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.remarks
     *
     * @param remarks the value for t_report.remarks
     * @mbg.generated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.is_enterprise
     *
     * @return the value of t_report.is_enterprise
     * @mbg.generated
     */
    public Integer getIsEnterprise() {
        return isEnterprise;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.is_enterprise
     *
     * @param isEnterprise the value for t_report.is_enterprise
     * @mbg.generated
     */
    public void setIsEnterprise(Integer isEnterprise) {
        this.isEnterprise = isEnterprise;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.electronic_signature
     *
     * @return the value of t_report.electronic_signature
     * @mbg.generated
     */
    public String getElectronicSignature() {
        return electronicSignature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.electronic_signature
     *
     * @param electronicSignature the value for t_report.electronic_signature
     * @mbg.generated
     */
    public void setElectronicSignature(String electronicSignature) {
        this.electronicSignature = electronicSignature == null ? null : electronicSignature.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.is_deleted
     *
     * @return the value of t_report.is_deleted
     * @mbg.generated
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.is_deleted
     *
     * @param isDeleted the value for t_report.is_deleted
     * @mbg.generated
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}