package com.bytedance.entities;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

class AList
{
    private List<String> actors;

    private List<String> directors;

    private Long discussion_hot;

    private Long hot;

    private String id;

    private Long influence_hot;

    private String maoyan_id;

    private String name;

    private String name_en;

    private String poster;

    private Long release_date;

    private Long search_hot;

    private Long topic_hot;

    private Long type;

    public void setActors(List<String> actors){
        this.actors = actors;
    }
    public List<String> getActors(){
        return this.actors;
    }
    public void setDirectors(List<String> directors){
        this.directors = directors;
    }
    public List<String> getDirectors(){
        return this.directors;
    }
    public void setDiscussion_hot(Long discussion_hot){
        this.discussion_hot = discussion_hot;
    }
    public Long getDiscussion_hot(){
        return this.discussion_hot;
    }
    public void setHot(Long hot){
        this.hot = hot;
    }
    public Long getHot(){
        return this.hot;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setInfluence_hot(Long influence_hot){
        this.influence_hot = influence_hot;
    }
    public Long getInfluence_hot(){
        return this.influence_hot;
    }
    public void setMaoyan_id(String maoyan_id){
        this.maoyan_id = maoyan_id;
    }
    public String getMaoyan_id(){
        return this.maoyan_id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setName_en(String name_en){
        this.name_en = name_en;
    }
    public String getName_en(){
        return this.name_en;
    }
    public void setPoster(String poster){
        this.poster = poster;
    }
    public String getPoster(){
        return this.poster;
    }
    public void setRelease_date(Long release_date){
        this.release_date = release_date;
    }
    public Long getRelease_date(){
        return this.release_date;
    }
    public void setSearch_hot(Long search_hot){
        this.search_hot = search_hot;
    }
    public Long getSearch_hot(){
        return this.search_hot;
    }
    public void setTopic_hot(Long topic_hot){
        this.topic_hot = topic_hot;
    }
    public Long getTopic_hot(){
        return this.topic_hot;
    }
    public void setType(Long type){
        this.type = type;
    }
    public Long getType(){
        return this.type;
    }

    @Override
    public String toString() {
        return "AList{" +
                "actors=" + actors +
                ", directors=" + directors +
                ", discussion_hot=" + discussion_hot +
                ", hot=" + hot +
                ", id='" + id + '\'' +
                ", influence_hot=" + influence_hot +
                ", maoyan_id='" + maoyan_id + '\'' +
                ", name='" + name + '\'' +
                ", name_en='" + name_en + '\'' +
                ", poster='" + poster + '\'' +
                ", release_date=" + release_date +
                ", search_hot=" + search_hot +
                ", topic_hot=" + topic_hot +
                ", type=" + type +
                '}';
    }
}
class Data
{
    private Long active_time;

    private String description;

    private Long error_code;

    private List<AList> list;

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
    public void setList(List<AList> alist){
        this.list = alist;
    }
    public List<AList> getList(){
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

public class Movie
{
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
