package com.jxshen.task.manager.api.response;
public class ErrorCode {
	
	public static final String SUCCESS = "200";
	
	public static final String SYSTEM_ERR = "100000";	
	
	//认证错误
	public static final String PERM_ERROR = "200000";
	public static final String USER_NOT_EXISTS = "200400";
	public static final String PASSWORD_ERROR = "200401";
	public static final String USER_NOT_LOGIN = "200402";  //request无token
	public static final String TOKEN_EXPIRE = "200403";    //request有token, server无token
	public static final String TOKEN_ERROR = "200404";     //request.token != server.token
	public static final String AUTH_ERROR = "200405";      //权限错误
	public static final String REP_LOGIN = "200406";      //权限错误
	public static final String FREQUENT_ACCESS = "200407";  //频繁登陆
	
	//参数错误
	public static final String PARAM_ERR = "300000";
	
	/**
	 * 远程调用响应错误
	 */
	public static final String HTTPSTATUS_ERR = "800000";
	public static final String OMS_SYNC_RET_ERR = "800401";
	
	//异常
	public static final String EXCEPTION = "900000";
}
