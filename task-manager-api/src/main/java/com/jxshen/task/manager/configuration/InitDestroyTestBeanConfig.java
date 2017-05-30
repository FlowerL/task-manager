package com.jxshen.task.manager.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jxshen.task.manager.service.bean.InitDestroyTestBean;

@Configuration
public class InitDestroyTestBeanConfig {

//    @Bean(initMethod="init", destroyMethod="destroy")
//    InitDestroyTestBean initDestroyTestBean() {
//        return new InitDestroyTestBean();
//    }
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                InitDestroyTestBeanConfig.class);
        context.close();
    }
}
