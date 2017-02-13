package com.jxshen.task.manager.dao.entity;

import java.util.Date;

public class UserInfo {

    private Integer id;
    private Date create_time;
    private Date last_update_time;
    private String username;
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
}
