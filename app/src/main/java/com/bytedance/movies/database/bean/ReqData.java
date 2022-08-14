package com.bytedance.movies.database.bean;

import java.util.List;

/**
 * @Classname ReqData
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/14 14:51
 */

public class ReqData {
    private Data data;
    private Extra extra;
//    private static class Movie
//    {
//        private List<String> actors;
//
//        private List<String> directors;
//
//        private List<String> areas;
//
//        private int discussion_hot;
//
//        private int hot;
//
//        private String id;
//
//        private int influence_hot;
//
//        private String maoyan_id;
//
//        private String name;
//
//        private String name_en;
//
//        private String poster;
//
//        private String release_date;
//
//        private int search_hot;
//
//        private int topic_hot;
//
//        private int type;
//
//        public void setActors(List<String> actors){
//            this.actors = actors;
//        }
//        public List<String> getActors(){
//            return this.actors;
//        }
//        public void setDirectors(List<String> directors){
//            this.directors = directors;
//        }
//        public List<String> getDirectors(){
//            return this.directors;
//        }
//        public void setDiscussion_hot(int discussion_hot){
//            this.discussion_hot = discussion_hot;
//        }
//        public int getDiscussion_hot(){
//            return this.discussion_hot;
//        }
//        public void setHot(int hot){
//            this.hot = hot;
//        }
//        public int getHot(){
//            return this.hot;
//        }
//        public void setId(String id){
//            this.id = id;
//        }
//        public String getId(){
//            return this.id;
//        }
//        public void setInfluence_hot(int influence_hot){
//            this.influence_hot = influence_hot;
//        }
//        public int getInfluence_hot(){
//            return this.influence_hot;
//        }
//        public void setMaoyan_id(String maoyan_id){
//            this.maoyan_id = maoyan_id;
//        }
//        public String getMaoyan_id(){
//            return this.maoyan_id;
//        }
//        public void setName(String name){
//            this.name = name;
//        }
//        public String getName(){
//            return this.name;
//        }
//        public void setName_en(String name_en){
//            this.name_en = name_en;
//        }
//        public String getName_en(){
//            return this.name_en;
//        }
//        public void setPoster(String poster){
//            this.poster = poster;
//        }
//        public String getPoster(){
//            return this.poster;
//        }
//        public void setRelease_date(String release_date){
//            this.release_date = release_date;
//        }
//        public String getRelease_date(){
//            return this.release_date;
//        }
//        public void setSearch_hot(int search_hot){
//            this.search_hot = search_hot;
//        }
//        public int getSearch_hot(){
//            return this.search_hot;
//        }
//        public void setTopic_hot(int topic_hot){
//            this.topic_hot = topic_hot;
//        }
//        public int getTopic_hot(){
//            return this.topic_hot;
//        }
//        public void setType(int type){
//            this.type = type;
//        }
//        public int getType(){
//            return this.type;
//        }
//    }


//    private static class Data
//    {
//        private String active_time;
//
//        private String description;
//
//        private int error_code;
//
//        private List<Movie> list;
//
//        public void setActive_time(String active_time){
//            this.active_time = active_time;
//        }
//        public String getActive_time(){
//            return this.active_time;
//        }
//        public void setDescription(String description){
//            this.description = description;
//        }
//        public String getDescription(){
//            return this.description;
//        }
//        public void setError_code(int error_code){
//            this.error_code = error_code;
//        }
//        public int getError_code(){
//            return this.error_code;
//        }
//        public void setList(List<Movie> list){
//            this.list = list;
//        }
//        public List<Movie> getList(){
//            return this.list;
//        }
//    }

//    private static class Extra
//    {
//        private String logid;
//
//        private int now;
//
//        public void setLogid(String logid){
//            this.logid = logid;
//        }
//        public String getLogid(){
//            return this.logid;
//        }
//        public void setNow(int now){
//            this.now = now;
//        }
//        public int getNow(){
//            return this.now;
//        }
//    }
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
}
