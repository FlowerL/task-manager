package com.jxshen.task.manager.common.util;

import org.apache.commons.lang.StringUtils;

public class IntegerUtil {

    public static Integer parseIntegerEmptySafe(String str) {
        if (StringUtils.isEmpty(str)) {
            return null; 
        }
        return Integer.parseInt(str);
    }
    
    public static String toStringNullSafe(Integer integer) {
        if (integer == null) {
            return null;
        }
        return Integer.toString(integer);
    }
}
