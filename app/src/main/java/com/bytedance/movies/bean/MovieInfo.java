package com.bytedance.movies.bean;

import com.bytedance.movies.entities.Movie;

import java.util.List;

public class MovieInfo {
    private Data data;

    private Extra extra;

    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }
    public void setExtra(Extra extra){
        this.extra = extra;
    }
    public Extra getExtra(){
        return this.extra;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "data=" + data +
                ", extra=" + extra +
                '}';
    }
}
class Data
{
    private Long active_time;

    private String description;

    private Long error_code;

    private List<Movie> list;

    public void setActive_time(Long active_time){
        this.active_time = active_time;
    }
    public Long getActive_time(){
        return this.active_time;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setError_code(Long error_code){
        this.error_code = error_code;
    }
    public Long getError_code(){
        return this.error_code;
    }
    public void setList(List<Movie> alist){
        this.list = alist;
    }
    public List<Movie> getList(){
        return this.list;
    }

    @Override
    public String toString() {
        return "Data{" +
                "active_time=" + active_time +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                ", list=" + list +
                '}';
    }
}

class Extra
{
    private String logid;

    private Long now;

    public void setLogid(String logid){
        this.logid = logid;
    }
    public String getLogid(){
        return this.logid;
    }
    public void setNow(Long now){
        this.now = now;
    }
    public Long getNow(){
        return this.now;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "logid='" + logid + '\'' +
                ", now=" + now +
                '}';
    }
}


