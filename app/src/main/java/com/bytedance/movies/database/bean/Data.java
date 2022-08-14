package com.bytedance.movies.database.bean;

import java.util.List;

/**
 * @Classname Data
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/14 15:09
 */
@lombok.Data
public class Data {

    private String active_time;

    private String description;

    private int error_code;

    private List<Movie> list;
}
