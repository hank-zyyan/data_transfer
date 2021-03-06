package com.terrydr.dao.basic;

import com.terrydr.domain.AIResult;
import com.terrydr.domain.PathologyAnnotation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pA")
public interface PathologyAnnotationDAO {

    int count();

    List<PathologyAnnotation> selectPerPage(@Param("offset") int offset, @Param("rows") int rows);

    List<PathologyAnnotation> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_annotation
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_annotation
     *
     * @mbg.generated
     */
    int insert(PathologyAnnotation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_annotation
     *
     * @mbg.generated
     */
    int insertSelective(PathologyAnnotation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_annotation
     *
     * @mbg.generated
     */
    PathologyAnnotation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_annotation
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PathologyAnnotation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_annotation
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PathologyAnnotation record);
}