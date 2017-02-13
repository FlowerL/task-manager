package com.jxshen.task.manager.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

public class RequestUtil {
	
	public static <T> T getRequestBodyAsJSONObject(HttpServletRequest request, Class<T> clazz) {
		String jsonStr = getRequestBodyAsReader(request);
		if (StringUtils.isEmpty(jsonStr)) {
		    return null;
		}
		return JSON.toJavaObject(JSON.parseObject(jsonStr), clazz);
	}
	
	public static <T> List<T> getRequestBodyAsList(HttpServletRequest request, Class<T> clazz) {
	    String jsonStr = getRequestBodyAsReader(request);
	    if (StringUtils.isEmpty(jsonStr)) {
            return null;
        }
	    return JSON.parseArray(jsonStr, clazz);
	    
	}
	
	public static String getRequestBodyAsReader(HttpServletRequest request) {
        BufferedReader br = null;
        try {
            br = request.getReader();
            StringBuilder sb = new StringBuilder("");
            String line = null;
            while ( (line = br.readLine()) != null) {
                sb.append(line);
            }
            String str = new String(sb);
            return str;
        } catch (IOException ioe) {
            throw new RuntimeException();
        } catch (RuntimeException re) {
            throw re;
        } finally {
            try {
                br.close();
            } catch (IOException e) {
            }
        }
    }
	
	public static ByteArrayOutputStream getRequestBodyAsStream(HttpServletRequest request) {
		InputStream is = null;
		BufferedInputStream bis= null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			is = request.getInputStream();
			bis=new BufferedInputStream(is);
			int c;
			while ((c = bis.read()) != -1)
				baos.write(c);
			return baos;
		} catch (IOException ioe) {
			throw new RuntimeException();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			try {
				is.close();
				bis.close();
			} catch (IOException e) {
			}
		}
	}
}
