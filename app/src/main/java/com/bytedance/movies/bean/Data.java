package com.bytedance.movies.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * @Classname Data
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/11 23:36
 */

public class Data
{
    private String active_time;

    private String description;

    private int error_code;

    private List<List> list;

    public void setActive_time(String active_time){
        this.active_time = active_time;
    }
    public String getActive_time(){
        return this.active_time;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setError_code(int error_code){
        this.error_code = error_code;
    }
    public int getError_code(){
        return this.error_code;
    }
    public void setList(List<List> list){
        this.list = list;
    }
    public List<List> getList(){
        return this.list;
    }
}