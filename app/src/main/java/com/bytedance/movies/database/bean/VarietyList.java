package com.bytedance.movies.database.bean;

import java.util.List;

import lombok.Data;

/**
 * @Classname VarietyList
 * @Description: 综艺榜单数据
 * @Created by 康斯坦丁
 * @Date 2022/8/13 19:31
 */
@Data
public class VarietyList {

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


}
