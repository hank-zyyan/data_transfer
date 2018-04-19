package com.terrydr.dao.pathology;

import com.terrydr.domain.pathology.PathologyAnnotation;
import org.springframework.stereotype.Repository;

@Repository
public interface PathAnnotationDAO {

    int deleteAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_annotation
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_annotation
     *
     * @mbg.generated
     */
    int insert(PathologyAnnotation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_annotation
     *
     * @mbg.generated
     */
    int insertSelective(PathologyAnnotation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_annotation
     *
     * @mbg.generated
     */
    PathologyAnnotation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_annotation
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PathologyAnnotation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_annotation
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PathologyAnnotation record);
}