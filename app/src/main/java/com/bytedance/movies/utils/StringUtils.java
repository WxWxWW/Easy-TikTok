package com.bytedance.movies.utils;

/**
 * @Classname StringUtils
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/12 22:42
 */
public class StringUtils {
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
}
