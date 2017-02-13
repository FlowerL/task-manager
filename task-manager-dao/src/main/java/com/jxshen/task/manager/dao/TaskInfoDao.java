package com.jxshen.task.manager.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jxshen.task.manager.dao.entity.TaskInfo;

public interface TaskInfoDao {
    
    List<TaskInfo> getTaskInfoListByParameter(@Param("id")Integer id,
            @Param("create_time")Date create_time,
            @Param("last_update_time")Date last_update_time,
            @Param("user_info_id")Integer user_info_id,
            @Param("task_name")String task_name,
            @Param("time")Integer time,
            @Param("time_unit")String time_unit,
            @Param("status")String status);
    
    List<TaskInfo> getTaskInfoListByEntity(@Param("item")TaskInfo taskInfo);
    
    int insert(@Param("item")TaskInfo taskInfo);
    
    int update(@Param("item")TaskInfo taskInfo);
    
    int updateBatch(@Param("list")List<TaskInfo> taskInfoList);
    
    int deleteById(@Param("item")TaskInfo taskInfo);
}
