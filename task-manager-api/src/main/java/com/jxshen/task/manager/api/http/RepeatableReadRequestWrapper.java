package com.jxshen.task.manager.api.http;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.jxshen.task.manager.common.util.RequestUtil;

/**
 * 包装HttpServletRequest，使其body可重复读<br>
 * Spring boot框架会调用OrderedHiddenHttpMethodFilter<br>
 * 并调用request.getParameter()，如果http类型为post，根据servlet api描述<br>
 * 导致后续request.getInputStream和request.getReader()读不到数据<br>
 * 该wrapper配合最先被调用的过滤器对HttpServletRequest进行包装，使其body可重复读。<br>
 * 
 * @author jxshen
 *
 */
public class RepeatableReadRequestWrapper extends HttpServletRequestWrapper {

    private final ByteArrayOutputStream body;  //request的body缓存
    
    public RepeatableReadRequestWrapper(HttpServletRequest request) {
        super(request);
        body = RequestUtil.getRequestBodyAsStream(request);
    }
    
    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body.toByteArray());
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }
        };
    }
    
    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }
}
