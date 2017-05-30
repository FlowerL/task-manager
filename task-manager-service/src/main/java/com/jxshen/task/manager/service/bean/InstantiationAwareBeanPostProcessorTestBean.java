package com.jxshen.task.manager.service.bean;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class InstantiationAwareBeanPostProcessorTestBean
extends InstantiationAwareBeanPostProcessorAdapter {

    private static final String clazzName = InstantiationAwareBeanPostProcessorTestBean
            .class.getSimpleName();
    
    public InstantiationAwareBeanPostProcessorTestBean() {
        System.out.println(String.format("[%s] constructor called", clazzName));
    }
    
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass.equals(BeanLifeCycleTestBean.class)) {
            System.out.println(String.format("[%s] postProcessBeforeInstantiation called handling [%s]", 
                    clazzName, beanName));
        }
        return null;
    }
    
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanLifeCycleTestBean) {
            System.out.println(String.format("[%s] postProcessAfterInstantiation called handling [%s]", 
                    clazzName, beanName));
        }
        return true;
    }

    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanLifeCycleTestBean) {
            System.out.println(String.format("[%s] postProcessPropertyValues called handling [%s][%s]", 
                    clazzName, beanName, pvs.toString()));
        }
        return pvs;
    }
}
