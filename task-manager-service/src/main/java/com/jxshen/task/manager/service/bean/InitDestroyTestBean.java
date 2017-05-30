package com.jxshen.task.manager.service.bean;

public class InitDestroyTestBean {
    
    private static final Class<?> clazz = InitDestroyTestBean.class;

    public void init() {
        System.out.println(String.format("Bean [%s] init method called", clazz.getName()));
    }
    
    public void destroy() {
        System.out.println(String.format("Bean [%s] destroy method called", clazz.getName()));
    }
}
