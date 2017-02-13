package com.jxshen.task.manager.service.vo;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.jxshen.task.manager.common.util.DateUtil;
import com.jxshen.task.manager.common.util.IntegerUtil;
import com.jxshen.task.manager.dao.entity.TaskInfo;

public class TaskInfoVO {

    private String id;
    private String create_time;
    private String last_update_time;
    private String user_info_id;
    private String task_name;
    private String time;
    private String time_unit;
    private String status;
    
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
    
    public String getUser_info_id() {
        return user_info_id;
    }
    public void setUser_info_id(String user_info_id) {
        this.user_info_id = user_info_id;
    }
    public void setUser_info_id(Integer user_info_id) {
        if (user_info_id == null) {
            this.user_info_id = null;
        }
        this.user_info_id = Integer.toString(user_info_id);
    }
    
    public String getTask_name() {
        return task_name;
    }
    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }
    
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setTime(Integer time) {
        if (time == null) {
            this.time = null;
        }
        this.time = Integer.toString(time);
    }
    
    public String getTime_unit() {
        return time_unit;
    }
    public void setTime_unit(String time_unit) {
        this.time_unit = time_unit;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public static TaskInfoVO parseTaskInfoVO(TaskInfo taskInfo) {
        if (taskInfo == null) {
            return null;
        }
        TaskInfoVO taskInfoVO = new TaskInfoVO();
        taskInfoVO.setId(taskInfo.getId());
        taskInfoVO.setCreate_time(taskInfo.getCreate_time());
        taskInfoVO.setLast_update_time(taskInfo.getLast_update_time());
        taskInfoVO.setUser_info_id(taskInfo.getUser_info_id());
        taskInfoVO.setTask_name(taskInfo.getTask_name());
        taskInfoVO.setTime(taskInfo.getTime());
        taskInfoVO.setTime_unit(taskInfo.getTime_unit());
        taskInfoVO.setStatus(taskInfo.getStatus());
        
        return taskInfoVO;
    }
    
    public static TaskInfoVO parseTaskInfoVO(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        
        //useVO
        String id = request.getParameter("id");
        String create_time = request.getParameter("create_time");
        String last_update_time = request.getParameter("last_update_time");
        String user_info_id = request.getParameter("user_info_id");
        String task_name = request.getParameter("task_name");
        String time = request.getParameter("time");
        String time_unit = request.getParameter("time_unit");
        String status = request.getParameter("status");
        
        //setVO
        TaskInfoVO taskInfoVO = new TaskInfoVO();
        taskInfoVO.setId(id);
        taskInfoVO.setCreate_time(create_time);
        taskInfoVO.setLast_update_time(last_update_time);
        taskInfoVO.setUser_info_id(user_info_id);
        taskInfoVO.setTask_name(task_name);
        taskInfoVO.setTime(time);
        taskInfoVO.setTime_unit(time_unit);
        taskInfoVO.setStatus(status);
        
        return taskInfoVO;
    }
    
    public TaskInfo toTaskInfo(){
        TaskInfo taskInfo = new TaskInfo();
        
        taskInfo.setId(IntegerUtil.parseIntegerEmptySafe(this.id));
        taskInfo.setCreate_time(DateUtil.parseDateRuntimeEmptySafe(this.create_time));
        taskInfo.setLast_update_time(DateUtil.parseDateRuntimeEmptySafe(this.last_update_time));
        taskInfo.setUser_info_id(IntegerUtil.parseIntegerEmptySafe(this.user_info_id));
        taskInfo.setTask_name(this.task_name);
        taskInfo.setTime(IntegerUtil.parseIntegerEmptySafe(this.time));
        taskInfo.setTime_unit(this.time_unit);
        taskInfo.setStatus(this.status);
        
        return taskInfo;
    }
    
    public void setAllParamsNull() {
        id = null;
        create_time = null;
        last_update_time = null;
        user_info_id = null;
        task_name = null;
        time = null;
        time_unit = null;
        status = null;
    }
}
