package com.jxshen.task.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxshen.task.manager.dao.TaskInfoDao;
import com.jxshen.task.manager.dao.entity.TaskInfo;
import com.jxshen.task.manager.service.vo.TaskInfoVO;

@Service
public class TaskInfoService {
    
    @Autowired
    TaskInfoDao taskInfoDao;
    
    public List<TaskInfoVO> getTaskInfoList(TaskInfoVO taskInfoVO) {
        TaskInfo taskInfo = taskInfoVO.toTaskInfo();
        List<TaskInfo> taskInfoList = taskInfoDao.getTaskInfoListByEntity(taskInfo);
        if (taskInfoList == null) {
            return null;
        }
        List<TaskInfoVO> taskInfoVOList = new ArrayList<TaskInfoVO>();
        for (TaskInfo taskInfoSingle : taskInfoList) {
            taskInfoVOList.add(TaskInfoVO.parseTaskInfoVO(taskInfoSingle));
        }
        return taskInfoVOList;
    }
    
    public int add(TaskInfoVO taskInfoVO) {
        TaskInfo taskInfo = taskInfoVO.toTaskInfo();
        return taskInfoDao.insert(taskInfo);
    }
    
    public int update(TaskInfoVO taskInfoVO) {
        TaskInfo taskInfo = taskInfoVO.toTaskInfo();
        return taskInfoDao.update(taskInfo);
    }
    
    public int updateBatch(List<TaskInfoVO> taskInfoVOList) {
        if (CollectionUtils.isEmpty(taskInfoVOList)) {
            return -1;
        }
        List<TaskInfo> taskInfoList = new ArrayList<TaskInfo>();
        for (TaskInfoVO taskInfoVO : taskInfoVOList) {
            TaskInfo taskInfo = taskInfoVO.toTaskInfo();
            taskInfoList.add(taskInfo);
        }
        return taskInfoDao.updateBatch(taskInfoList);
    }
    
    public int deleteById(TaskInfoVO taskInfoVO) {
        TaskInfo taskInfo = taskInfoVO.toTaskInfo();
        return taskInfoDao.deleteById(taskInfo);
    }
}
