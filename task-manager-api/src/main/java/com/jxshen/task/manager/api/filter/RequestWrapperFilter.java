package com.jxshen.task.manager.api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.jxshen.task.manager.api.http.RepeatableReadRequestWrapper;

/**
 * HttpServletRequest包装过滤器<br>
 * 配合RepeatedReadRequestWrapper将request的body变成可重复读
 * 
 * @author jxshen
 *
 */
public class RequestWrapperFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        RepeatableReadRequestWrapper repeatedReadRequestWrapper = new RepeatableReadRequestWrapper(request);
        filterChain.doFilter(repeatedReadRequestWrapper, response);
        return;
    }

}
