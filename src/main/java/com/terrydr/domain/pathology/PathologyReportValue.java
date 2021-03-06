package com.terrydr.domain.pathology;

import com.terrydr.domain.ReportValue;

public class PathologyReportValue {

    public PathologyReportValue(ReportValue value) {
        this.valueId = value.getValueId();
        this.attrId = value.getAttrId();
        this.reportId = value.getReportId();
        this.reportType = value.getReportType();
        this.attrValue = value.getAttrValue();
    }

    @Override
    public String toString() {
        return "Pathology_Report_Value（Id=" + this.valueId + "）";
    }
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report_value.value_id
     *
     * @mbg.generated
     */
    private Integer valueId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report_value.attr_id
     *
     * @mbg.generated
     */
    private Integer attrId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report_value.report_id
     *
     * @mbg.generated
     */
    private Integer reportId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report_value.report_type
     *
     * @mbg.generated
     */
    private Integer reportType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report_value.attr_value
     *
     * @mbg.generated
     */
    private String attrValue;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report_value.value_id
     *
     * @return the value of t_report_value.value_id
     *
     * @mbg.generated
     */
    public Integer getValueId() {
        return valueId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report_value.value_id
     *
     * @param valueId the value for t_report_value.value_id
     *
     * @mbg.generated
     */
    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report_value.attr_id
     *
     * @return the value of t_report_value.attr_id
     *
     * @mbg.generated
     */
    public Integer getAttrId() {
        return attrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report_value.attr_id
     *
     * @param attrId the value for t_report_value.attr_id
     *
     * @mbg.generated
     */
    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report_value.report_id
     *
     * @return the value of t_report_value.report_id
     *
     * @mbg.generated
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report_value.report_id
     *
     * @param reportId the value for t_report_value.report_id
     *
     * @mbg.generated
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report_value.report_type
     *
     * @return the value of t_report_value.report_type
     *
     * @mbg.generated
     */
    public Integer getReportType() {
        return reportType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report_value.report_type
     *
     * @param reportType the value for t_report_value.report_type
     *
     * @mbg.generated
     */
    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report_value.attr_value
     *
     * @return the value of t_report_value.attr_value
     *
     * @mbg.generated
     */
    public String getAttrValue() {
        return attrValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report_value.attr_value
     *
     * @param attrValue the value for t_report_value.attr_value
     *
     * @mbg.generated
     */
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }
}