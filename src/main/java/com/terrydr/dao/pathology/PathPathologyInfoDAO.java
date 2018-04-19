package com.terrydr.dao.pathology;

import com.terrydr.domain.pathology.Pathology;
import org.springframework.stereotype.Repository;

@Repository
public interface PathPathologyInfoDAO {

    int deleteAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_info
     *
     * @mbg.generated
     */
    int insert(Pathology record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_info
     *
     * @mbg.generated
     */
    int insertSelective(Pathology record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_info
     *
     * @mbg.generated
     */
    Pathology selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Pathology record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pathology_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Pathology record);
}