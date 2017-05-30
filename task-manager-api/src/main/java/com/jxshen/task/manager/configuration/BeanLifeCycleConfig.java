package com.jxshen.task.manager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jxshen.task.manager.service.bean.BeanFactoryPostProcessorTestBean;
import com.jxshen.task.manager.service.bean.BeanLifeCycleTestBean;
import com.jxshen.task.manager.service.bean.BeanPostProcessorTestBean;
import com.jxshen.task.manager.service.bean.InstantiationAwareBeanPostProcessorTestBean;

@Configuration
public class BeanLifeCycleConfig {

    @Bean(initMethod="myInitMethod", destroyMethod="myDestroyMethod")
    public BeanLifeCycleTestBean beanLifeCycleTestBean() {
        BeanLifeCycleTestBean bean = new BeanLifeCycleTestBean();
        bean.setParam1("param1");
        bean.setParam2("param2");
        bean.setParam3("param3");
        return bean;
    }
    
    @Bean
    public BeanPostProcessorTestBean beanPostProcessorTestBean() {
        return new BeanPostProcessorTestBean();
    }
    
    @Bean
    public InstantiationAwareBeanPostProcessorTestBean instantiationAwareBeanPostProcessorTestBean() {
        return new InstantiationAwareBeanPostProcessorTestBean();
    }
    
    @Bean
    public BeanFactoryPostProcessorTestBean beanFactoryPostProcessorTestBean() {
        return new BeanFactoryPostProcessorTestBean();
    }
}
