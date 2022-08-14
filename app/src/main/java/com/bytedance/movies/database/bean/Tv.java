package com.bytedance.movies.database.bean;

import java.util.List;

import lombok.Data;

/**
 * @Classname TVList
 * @Description: 电视剧榜单数据
 * @Created by 康斯坦丁
 * @Date 2022/8/13 19:31
 */
@Data
public class Tv
{
    //演员
    private List<String> actors;
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

    //影片ID
    private String id;

    //中文名
    private String name;
    //英文名
    private String name_en;

    //海报
    private String poster;

    //上映时间
    private String release_date;

    //类型标签
    private List<String> tags;


}





