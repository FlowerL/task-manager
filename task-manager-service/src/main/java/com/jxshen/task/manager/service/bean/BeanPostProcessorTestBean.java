package com.jxshen.task.manager.service.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorTestBean implements BeanPostProcessor {

    private static final String clazzName = BeanPostProcessorTestBean.class.getSimpleName();
    
    public BeanPostProcessorTestBean() {
        System.out.println(String.format("[%s] constructor called", clazzName));
    }
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanLifeCycleTestBean) {
            System.out.println(String.format("[%s] postProcessBeforeInitialization called handling [%s]", 
                    clazzName, beanName));
        }
        
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanLifeCycleTestBean) {
            System.out.println(String.format("[%s] postProcessAfterInitialization called handling [%s]", 
                    clazzName, beanName));
        }
        
        return bean;
    }

}
