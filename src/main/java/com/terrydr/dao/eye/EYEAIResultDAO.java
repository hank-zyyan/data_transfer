package com.terrydr.dao.eye;

import com.terrydr.domain.eye.EYEAIResult;
import com.terrydr.domain.eye.EYEAIResultKey;
import org.springframework.stereotype.Repository;

@Repository
public interface EYEAIResultDAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_result
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(EYEAIResultKey key);

    int deleteAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_result
     *
     * @mbg.generated
     */
    int insert(EYEAIResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_result
     *
     * @mbg.generated
     */
    int insertSelective(EYEAIResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_result
     *
     * @mbg.generated
     */
    EYEAIResult selectByPrimaryKey(EYEAIResultKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_result
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(EYEAIResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_result
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(EYEAIResult record);
}