package com.jxshen.task.manager.dao.entity;

import java.util.Date;

public class TaskInfo {

    private Integer id;
    private Date create_time;
    private Date last_update_time;
    private Integer user_info_id;
    private String task_name;
    private Integer time;
    private String time_unit;
    private String status;
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the create_time
     */
    public Date getCreate_time() {
        return create_time;
    }
    /**
     * @param create_time the create_time to set
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    /**
     * @return the last_update_time
     */
    public Date getLast_update_time() {
        return last_update_time;
    }
    /**
     * @param last_update_time the last_update_time to set
     */
    public void setLast_update_time(Date last_update_time) {
        this.last_update_time = last_update_time;
    }
    /**
     * @return the user_info_id
     */
    public Integer getUser_info_id() {
        return user_info_id;
    }
    /**
     * @param user_info_id the user_info_id to set
     */
    public void setUser_info_id(Integer user_info_id) {
        this.user_info_id = user_info_id;
    }
    /**
     * @return the task_name
     */
    public String getTask_name() {
        return task_name;
    }
    /**
     * @param task_name the task_name to set
     */
    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }
    /**
     * @return the time
     */
    public Integer getTime() {
        return time;
    }
    /**
     * @param time the time to set
     */
    public void setTime(Integer time) {
        this.time = time;
    }
    /**
     * @return the time_unit
     */
    public String getTime_unit() {
        return time_unit;
    }
    /**
     * @param time_unit the time_unit to set
     */
    public void setTime_unit(String time_unit) {
        this.time_unit = time_unit;
    }
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
}
