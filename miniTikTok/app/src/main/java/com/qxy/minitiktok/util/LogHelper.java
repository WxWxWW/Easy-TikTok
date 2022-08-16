package com.qxy.minitiktok.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//获取日志输出代码行的类文件信息
public class LogHelper {

    private static final int CALL_STACK_INDEX = 1;
    private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");

    //出错时获取错误信息的代码行
    public static String wrapMessage(int stackIndex,String message){
        if(stackIndex < 0){
            stackIndex = CALL_STACK_INDEX;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if(stackTrace.length <= stackIndex){
            throw new IllegalStateException("没有足够的元素");
        }
        String clazz = extractClassName(stackTrace[stackIndex]);
        int lineNumber = stackTrace[stackIndex].getLineNumber();
        message = ".(" + clazz + ".java" + lineNumber + ") -" + message;
        return  message;
    }
    //获取类名
    private static String extractClassName(StackTraceElement element){
        String tag = element.getClassName();
        Matcher m = ANONYMOUS_CLASS.matcher(tag);
        if(m.find()){
            tag = m.replaceAll("");
        }
        return tag.substring(tag.lastIndexOf('.') +1);
    }

}
