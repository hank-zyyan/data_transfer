package com.terrydr.dao.basic;

import com.terrydr.domain.PathologyAnnotation;
import com.terrydr.domain.PathologyConsultation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pC")
public interface PathologyConsultationDAO {

    int count();

    List<PathologyConsultation> selectPerPage(@Param("offset") int offset, @Param("rows") int rows);

    List<PathologyConsultation> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_consultation
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_consultation
     *
     * @mbg.generated
     */
    int insert(PathologyConsultation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_consultation
     *
     * @mbg.generated
     */
    int insertSelective(PathologyConsultation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_consultation
     *
     * @mbg.generated
     */
    PathologyConsultation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_consultation
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PathologyConsultation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_consultation
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PathologyConsultation record);
}