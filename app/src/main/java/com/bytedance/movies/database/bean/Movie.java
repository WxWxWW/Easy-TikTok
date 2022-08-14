package com.bytedance.movies.database.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @Classname MovieList
 * @Description: 电影榜单数据类
 * @Created by 康斯坦丁
 * @Date 2022/8/13 19:30
 */
@Data
public class Movie {

    //导演
    private List<String> directors;
    //上映地区
    private List<String> ares;
    //讨论热度
    private int discussion_hot;
    //搜索热度
    private int search_hot;
    //主题热度
    private int topic_hot;
    //热度
    private int hot;
    //影响热度
    private int influence_hot;
    //中文名
    private String name;
    //英文名
    private String name_en;
    //海报
    private String poster;
    private List<String> actors;
    private List<String> tags;
    private String id;
    private String maoyan_id;
    private String release_date;
    private int type;
}
