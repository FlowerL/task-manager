package com.jxshen.task.manager.service.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPostProcessorTestBean implements BeanFactoryPostProcessor {

    private static final String clazzName = BeanFactoryPostProcessorTestBean.class.getSimpleName();
    
    public BeanFactoryPostProcessorTestBean() {
        System.out.println(String.format("[%s] constructor called", clazzName));
    }
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(String.format("[%s] postProcessBeanFactory called", clazzName));
        BeanDefinition bd = beanFactory.getBeanDefinition("beanLifeCycleTestBean");
        bd.getPropertyValues().addPropertyValue("param1", "addValue");
    }

}
