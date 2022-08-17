package com.qxy.minitiktok.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname StringUtil
 * @Description: 特殊字符串等操作，官方还提供了TextUtils,工具类，去判断空，拼接，反转....
 * @Created by 康斯坦丁
 * @Date 2022/8/12 22:42
 */
public class StringUtil {
    //判断字符串是否为空
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    //获取json对象内部指定key的value
    public static String getFieldValueFromJson(String jsonStr, String fieldName) {
        List<String> fieldValues = new ArrayList<>();
        String regex = "(?<=(\"" + fieldName + "\":\")).*?(?=(\"))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(jsonStr);
        while (matcher.find()) {
            if (!StringUtil.isBlank(matcher.group().trim())) {
                fieldValues.add(matcher.group().trim());
            }
        }
        return fieldValues.get(0);
    }

    public static String getString(List<String> list){
        if(list == null) return null;
        StringBuffer sb = new StringBuffer();
        for(String s : list){
            sb.append(s);
        }
        return sb.toString();
    }
}
