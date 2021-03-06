package com.terrydr.dao.eye;

import com.terrydr.domain.AIResult;
import com.terrydr.domain.eye.EYEAITask;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EYEAITaskDAO {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_task
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    int deleteAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_task
     *
     * @mbg.generated
     */
    int insert(EYEAITask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_task
     *
     * @mbg.generated
     */
    int insertSelective(EYEAITask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_task
     *
     * @mbg.generated
     */
    EYEAITask selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_task
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(EYEAITask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ai_task
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(EYEAITask record);
}