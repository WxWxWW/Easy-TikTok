package com.bytedance.entities;

import java.util.List;

public class Movie
{
    private List<String> actors;

    private List<String> areas;

    private List<String> directors;

    private Double discussion_hot;

    private Double hot;

    private String id;

    private Double influence_hot;

    private String maoyan_id;

    private String name;

    private String name_en;

    private String poster;

    private String release_date;

    private String search_hot;

    private List<String> tags;

    private String topic_hot;

    private String type;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getSearch_hot() {
        return search_hot;
    }

    public void setSearch_hot(String search_hot) {
        this.search_hot = search_hot;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTopic_hot() {
        return topic_hot;
    }

    public void setTopic_hot(String topic_hot) {
        this.topic_hot = topic_hot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}