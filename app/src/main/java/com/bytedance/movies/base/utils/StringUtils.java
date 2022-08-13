package com.bytedance.movies.base.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname StringUtils
 * @Description: 字符串等操作
 * @Created by 康斯坦丁
 * @Date 2022/8/12 22:42
 */
public class StringUtils {
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
            if (!StringUtils.isBlank(matcher.group().trim())) {
                fieldValues.add(matcher.group().trim());
            }
        }
        return fieldValues.get(0);
    }
}
