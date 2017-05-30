package com.jxshen.task.manager.service.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BeanFactoryAwareTestBean implements BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (beanFactory instanceof DefaultListableBeanFactory) {
            this.beanFactory = (ConfigurableListableBeanFactory)beanFactory;
            System.out.println("container callback setBeanFactory method and set beanFactory as"
                    + beanFactory.toString());
        }
    }

}
