package com.jxshen.task.manager.api.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jxshen.task.manager.common.util.ExceptionUtil;

/**
 * web控制器日志切面<br>
 * <p>
 * 切面调用优先级<br>
 * 方法前:around, before<br>
 * 方法后:around, after, afterReturning(afterThrowing)<br>
 * <p>
 * 无论正常返回或抛出异常after, 在函数调用完毕后马上执行(优先级在正常返回和抛出异常之前，相当于finally)<br>
 * <p>
 * 能用@Before和@After 尽量不要用@Around, 除非调用前后需要共享状态或者时间计数<br>
 * 
 * @author jxshen
 *
 */
@Aspect
@Component
public class ControllerLogAspect {

    private  Logger logger = LogManager.getLogger(ControllerLogAspect.class);
    
    @Pointcut("execution(public * com.jxshen.task.manager.api.controller.*Controller.*(..))")
    public void controllerLog(){}
    
    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        /**
         * 此处要是用传统xml配置<br>
         * 需要在web.xml配置监听器<p>
         * <listener>
         *     <listener-class>org.springframework.web.context.request.RequestContextListener</listener-class>
         * </listener>
         */
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        String ipPort = request.getRemoteAddr() + ":" + request.getRemotePort();
        String classMethod = joinPoint.getSignature().toShortString();
        
        logger.info("[start] user:[{}] call function [{}] url: [{}] with http method [{}]",
                ipPort, classMethod, url, httpMethod);
    }
    
//    @After("controllerLog()")
    public void doAfter(JoinPoint joinPoint) {
        
    }
    
    @AfterReturning(value="controllerLog()", returning="rtv")
    public void doAfterReturning(JoinPoint joinPoint, Object rtv) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        String ipPort = request.getRemoteAddr() + ":" + request.getRemotePort();
        String classMethod = joinPoint.getSignature().toShortString();
        
        logger.info("[end] user:[{}] call function [{}] url: [{}] with http method [{}]",
                ipPort, classMethod, url, httpMethod);
    }
    
    @AfterThrowing(value="controllerLog()", throwing="e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        String ipPort = request.getRemoteAddr() + ":" + request.getRemotePort();
        String classMethod = joinPoint.getSignature().toShortString();
        
        logger.error("[exception] user:[{}] call function [{}] url: [{}] with http method [{}] catch exception [{}]",
                ipPort, classMethod, url, httpMethod, ExceptionUtil.getStackTraceAsString(e));
    }
    
//    @Around("controllerLog()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        return null;
    }
    
    
    
}
