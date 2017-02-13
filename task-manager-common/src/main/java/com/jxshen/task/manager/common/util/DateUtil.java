package com.jxshen.task.manager.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DateUtil {

	public static Date parseDateRuntime(String dateString) {
		try {
			return DateUtils.parseDate(dateString, "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Date parseDateRuntimeEmptySafe(String dateString) {
	    if (StringUtils.isEmpty(dateString)) {
	        return null;
	    }
	    return parseDateRuntime(dateString);
    }
	
	public static Date parseDateRuntime(String dateString, String... patterns) {
		try {
			return DateUtils.parseDate(dateString, patterns);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String format(Date date, String format) {
		if(date == null) {
		    return null;
		}
		return new SimpleDateFormat(format).format(date);
	}
	
	public static String formatDate(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}
}
