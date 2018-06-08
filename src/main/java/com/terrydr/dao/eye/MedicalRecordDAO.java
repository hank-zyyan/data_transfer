package com.terrydr.dao.eye;

import com.terrydr.domain.eye.Detail;
import com.terrydr.domain.eye.MedicalRecord;

import java.util.List;

public interface MedicalRecordDAO {

    List<Detail> selectDetailsDev();

    List<Detail> selectDetailsTest();

    List<Detail> selectDetailsPro();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_medical_record
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_medical_record
     *
     * @mbg.generated
     */
    int insert(MedicalRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_medical_record
     *
     * @mbg.generated
     */
    int insertSelective(MedicalRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_medical_record
     *
     * @mbg.generated
     */
    MedicalRecord selectByPrimaryKey(Integer recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_medical_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MedicalRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_medical_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MedicalRecord record);
}