package com.jxshen.task.manager.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {
    
    public static String getStackTraceAsString(Throwable e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }
}
