package com.jxshen.task.manager.service.bean;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNameAwareTestBean implements BeanNameAware {

    private String name;
    
    @Override
    public void setBeanName(String name) {
        this.name = name;
        System.out.println("container callback setBeanName method and set name as "
                + name);
    }
    
}
