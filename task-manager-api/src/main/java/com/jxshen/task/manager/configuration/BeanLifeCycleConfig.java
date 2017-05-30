package com.jxshen.task.manager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jxshen.task.manager.service.bean.BeanLifeCycleTestBean;

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
}
