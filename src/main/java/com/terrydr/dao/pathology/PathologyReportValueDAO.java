package com.terrydr.dao.pathology;

import com.terrydr.domain.pathology.PathologyReportValue;
import org.springframework.stereotype.Repository;

@Repository
public interface PathologyReportValueDAO {

    int deleteAll();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_report_value
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer valueId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_report_value
     *
     * @mbg.generated
     */
    int insert(PathologyReportValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_report_value
     *
     * @mbg.generated
     */
    int insertSelective(PathologyReportValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_report_value
     *
     * @mbg.generated
     */
    PathologyReportValue selectByPrimaryKey(Integer valueId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_report_value
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PathologyReportValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_report_value
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PathologyReportValue record);
}