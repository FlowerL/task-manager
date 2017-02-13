package com.jxshen.task.manager.service.vo;

import java.util.Date;

import com.jxshen.task.manager.common.util.DateUtil;
import com.jxshen.task.manager.dao.entity.UserInfo;

public class UserInfoVO {
    
    private String id;
    private String create_time;
    private String last_update_time;
    private String username;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setId(Integer id) {
        if (id == null) {
            this.id = null;
            return;
        }
        this.id = Integer.toString(id);
    }
    
    public String getCreate_time() {
        return create_time;
    }
    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
    public void setCreate_time(Date create_time) {
        if (create_time == null) {
            this.create_time = null;
            return;
        }
        this.create_time = DateUtil.formatDate(create_time);
    }
    
    public String getLast_update_time() {
        return last_update_time;
    }
    public void setLast_update_time(String last_update_time) {
        this.last_update_time = last_update_time;
    }
    public void setLast_update_time(Date last_update_time) {
        if (last_update_time == null) {
            this.last_update_time = null;
            return;
        }
        this.last_update_time = DateUtil.formatDate(last_update_time);
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public static UserInfoVO parseUserInfoVO(UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setId(userInfo.getId());
        userInfoVO.setCreate_time(userInfo.getCreate_time());
        userInfoVO.setLast_update_time(userInfo.getLast_update_time());
        userInfoVO.setUsername(userInfo.getUsername());
        return userInfoVO;
    }
}
