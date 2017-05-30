package com.jxshen.task.manager.service.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycleTestBean implements BeanFactoryAware, BeanNameAware, 
InitializingBean, DisposableBean {
    
    private static final String clazzName = BeanLifeCycleTestBean.class.getSimpleName();
    // test setter injection
    private String param1;
    private String param2;
    private String param3;
    
    private BeanFactory beanFactory;
    private String beanName;
    
    public BeanLifeCycleTestBean() {
        System.out.println(String.format("[%s] [constructor] called", clazzName));
    }

    // DisposableBean Interface
    @Override
    public void destroy() throws Exception {
        System.out.println(String.format("[%s] [destroy] called", clazzName));
    }

    // InitializingBean Interface
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(String.format("[%s] [afterPropertiesSet] called", clazzName));
    }

    // BeanNameAware Interface
    @Override
    public void setBeanName(String arg0) {
        this.beanName =arg0;
        System.out.println(String.format("[%s] [setBeanName] called", clazzName));
    }

    // BeanFactoryAware Interface
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        this.beanFactory =arg0;
        System.out.println(String.format("[%s] [setBeanFactory] called", clazzName));
    }
    
    // Bean init-method
    public void myInitMethod() {
        System.out.println(String.format("[%s] [myInitMethod] called", clazzName));
    }
    
    // Bean destroy-method
    public void myDestroyMethod() {
        System.out.println(String.format("[%s] [myDestroy] called", clazzName));
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        System.out.println(String.format("[%s] [setParam1] called", clazzName));
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        System.out.println(String.format("[%s] [setParam2] called", clazzName));
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        System.out.println(String.format("[%s] [setParam3] called", clazzName));
        this.param3 = param3;
    }

}
