package com.hit.video.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hit.video.enumhandle.ERROR_CODE;

public class LoggerUtil {
	public static String getMethodName() {  
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();  
        StackTraceElement e = stacktrace[2];  
        String methodName = e.getMethodName();  
        return methodName;  
    }
	
	public static void error(String methodName,int errorCode,Class<?> clazz){
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.info(String.format("%s失败，错误代码:%s,错误原因：%s。",methodName,ERROR_CODE.codeOf(errorCode),ERROR_CODE.codeOf(errorCode).text()));
	}
}
