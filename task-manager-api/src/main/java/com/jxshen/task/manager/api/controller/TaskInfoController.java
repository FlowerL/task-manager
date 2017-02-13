package com.jxshen.task.manager.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jxshen.task.manager.api.response.Response;
import com.jxshen.task.manager.common.util.RequestUtil;
import com.jxshen.task.manager.service.TaskInfoService;
import com.jxshen.task.manager.service.vo.TaskInfoVO;

@RestController
@RequestMapping("/task/info")
public class TaskInfoController {
    
    @Autowired
    TaskInfoService taskInfoService;
    
    @RequestMapping("/search")
    public Response search(HttpServletRequest request){
        
        JSONObject reqJO = RequestUtil.getRequestBodyAsJSONObject(request, JSONObject.class);
        TaskInfoVO taskInfoVO;
        if (reqJO == null) {
            taskInfoVO = new TaskInfoVO();
            taskInfoVO.setAllParamsNull();
        } else {
            taskInfoVO = JSON.toJavaObject(reqJO, TaskInfoVO.class);
        }
        
        List<TaskInfoVO> taskInfoList = taskInfoService.getTaskInfoList(taskInfoVO);
        return Response.success(taskInfoList);
    }
    
    @RequestMapping(value={"/add"})
    public Response add(HttpServletRequest request) {
        JSONObject reqJO = RequestUtil.getRequestBodyAsJSONObject(request, JSONObject.class);
        TaskInfoVO taskInfoVO;
        if (reqJO == null) {
            taskInfoVO = new TaskInfoVO();
            taskInfoVO.setAllParamsNull();
        } else {
            taskInfoVO = JSON.toJavaObject(reqJO, TaskInfoVO.class);
        }
        
        taskInfoService.add(taskInfoVO);
        return Response.successSetMsg("add task success");
    }
    
    @RequestMapping(value={"/update"})
    public Response update(HttpServletRequest request) {
        JSONObject reqJO = RequestUtil.getRequestBodyAsJSONObject(request, JSONObject.class);
        TaskInfoVO taskInfoVO;
        if (reqJO == null) {
            taskInfoVO = new TaskInfoVO();
            taskInfoVO.setAllParamsNull();
        } else {
            taskInfoVO = JSON.toJavaObject(reqJO, TaskInfoVO.class);
        }
        
        taskInfoService.update(taskInfoVO);
        return Response.successSetMsg("update task success");
    }
    
    @RequestMapping("/batch/update")
    public Response updateBatch(HttpServletRequest request) {
        List<TaskInfoVO> taskInfoVOList = RequestUtil.getRequestBodyAsList(request, TaskInfoVO.class);
        if (taskInfoVOList == null) {
            return Response.error("500", "param cannot be empty");
        }
        
        taskInfoService.updateBatch(taskInfoVOList);
        return Response.successSetMsg("update task batch success");
    }

    @RequestMapping("/delete")
    public Response delete(HttpServletRequest request) {
        JSONObject reqJO = RequestUtil.getRequestBodyAsJSONObject(request, JSONObject.class);
        TaskInfoVO taskInfoVO;
        if (reqJO == null) {
            taskInfoVO = new TaskInfoVO();
            taskInfoVO.setAllParamsNull();
        } else {
            taskInfoVO = JSON.toJavaObject(reqJO, TaskInfoVO.class);
        }
        
        taskInfoService.deleteById(taskInfoVO);
        return Response.successSetMsg("delete task success");  
    }
}
