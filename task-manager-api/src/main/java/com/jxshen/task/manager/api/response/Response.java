package com.jxshen.task.manager.api.response;

import java.io.Serializable;

public class Response implements Serializable{
    
    private static final long serialVersionUID = 6470800444621484780L;
    
    private Object data;             
    private String code;
    private String msg;    
    private boolean success;    
    
    private Response() {}
    
    public static  Response success() {
        Response r = new Response();
        r.data = null;
        r.success = true;
        r.code = ErrorCode.SUCCESS;
        r.msg = null;
        return r;
    }
    
    public static  Response success(Object obj) {
        Response r = new Response();
        r.data = obj;
        r.success = true;
        r.code = ErrorCode.SUCCESS;
        r.msg = null;
        return r;
    }
    
    public static  Response success(Object obj, String msg) {
        Response r = new Response();
        r.data = obj;
        r.success = true;
        r.code = ErrorCode.SUCCESS;
        r.msg = msg;
        return r;
    }
    
    public static  Response successSetMsg(String msg) {
        Response r = new Response();
        r.data = null;
        r.success = true;
        r.code = ErrorCode.SUCCESS;
        r.msg = msg;
        return r;
    }
    
    public static Response error(String code,String msg) {
        Response r = new Response();
        r.data = null;
        r.success = false;
        r.code = code;
        r.msg = msg;
        return r;
    }

    public Object getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isSuccess() {
        return success;
    }
}
