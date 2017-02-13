package com.jxshen.task.manager.configuration;

import org.springframework.boot.web.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import com.jxshen.task.manager.api.filter.RequestWrapperFilter;

@Configuration
public class WebConfiguration {
    
    @Bean(name="requestWrapperFilter")
    public RequestWrapperFilter requestWrapperFilter() {
        return new RequestWrapperFilter();
    }
    
    /**
     * 包装HttpServletRequest为可重复读的filter<br>
     * 优先级高于所有过滤器，防止request的body被其他过滤器读取后变成不可读
     * 
     * @param filter
     * @return
     */
    @Bean
    public FilterRegistrationBean requestWrapperFilterRegistration(
            RequestWrapperFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter);
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setName("requestWrapperFilter");
        return filterRegistrationBean;
    }

    /**
     * 覆盖spring boot自定义的OrderedHiddenHttpMethodFilter
     * 
     * @param filter
     * @return
     */
    @Bean
    public FilterRegistrationBean hiddenHttpMethodFilterRegistration(
            HiddenHttpMethodFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter);
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }
    
    
}
