package com.terrydr.domain;

public class AIResultKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ai_result.task_id
     *
     * @mbg.generated
     */
    private String taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ai_result.file_path
     *
     * @mbg.generated
     */
    private String filePath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ai_result.task_id
     *
     * @return the value of t_ai_result.task_id
     *
     * @mbg.generated
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ai_result.task_id
     *
     * @param taskId the value for t_ai_result.task_id
     *
     * @mbg.generated
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ai_result.file_path
     *
     * @return the value of t_ai_result.file_path
     *
     * @mbg.generated
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ai_result.file_path
     *
     * @param filePath the value for t_ai_result.file_path
     *
     * @mbg.generated
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }
}