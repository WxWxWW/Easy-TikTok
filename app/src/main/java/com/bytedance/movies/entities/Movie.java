package com.bytedance.movies.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

import cn.hutool.core.util.ArrayUtil;

@Entity
public class Movie
{
    @Ignore
    private List<String> actors;
    @Ignore
    private List<String> areas;
    @Ignore
    private List<String> directors;
    private Double discussion_hot;
    private Double hot;
    @PrimaryKey(autoGenerate = true)
    private Long id;

    private Double influence_hot;

    private String maoyan_id;

    private String name;

    private String name_en;

    private String poster;

    private String release_date;

    private Double search_hot;
    @Ignore
    private List<String> tags;

    private Double topic_hot;

    private String type;

    @Ignore
    private Long time_stamp;


    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getAreas() {
        return areas;
    }

    public void setAreas(List<String> areas) {
        this.areas = areas;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public Double getDiscussion_hot() {
        return discussion_hot;
    }

    public void setDiscussion_hot(Double discussion_hot) {
        this.discussion_hot = discussion_hot;
    }

    public Double getHot() {
        return hot;
    }

    public void setHot(Double hot) {
        this.hot = hot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getInfluence_hot() {
        return influence_hot;
    }

    public void setInfluence_hot(Double influence_hot) {
        this.influence_hot = influence_hot;
    }

    public String getMaoyan_id() {
        return maoyan_id;
    }

    public void setMaoyan_id(String maoyan_id) {
        this.maoyan_id = maoyan_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Double getSearch_hot() {
        return search_hot;
    }

    public void setSearch_hot(Double search_hot) {
        this.search_hot = search_hot;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Double getTopic_hot() {
        return topic_hot;
    }

    public void setTopic_hot(Double topic_hot) {
        this.topic_hot = topic_hot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(Long time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String stringSplit(List<String> ls) {
        if (ArrayUtil.isEmpty(ls)) return null;
        StringBuilder builder = new StringBuilder(ls.get(0));
        for (int i = 1; i < ls.size(); i++) {
            builder.append(" / ").append(ls.get(i));
        }
        return builder.toString();
    }

    public String readDouble(Double v) {
        if(v==null) return null;
        String pw = "";
        if (v > 1e11) {
            v /= 1e12;
            pw = "万亿";
        } else if (v > 1e7) {
            v /= 1e8;
            pw = "亿";
        } else if (v > 1e3) {
            v /= 1e4;
            pw = "万";
        } else {
            return "" + v;
        }
        if (v < 1) return String.format("%.2f%s", v, pw);
        return String.format("%.0f%s", v, pw);
    }
    public String toString(Double d){
        if(d==null) return null;
        return String.format("%.0f",d);
    }
}