package com.bytedance.movies.logic.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.bytedance.movies.entities.Movie;

import java.util.List;

@Dao
public interface MovieDBDao {

    @Query("select * from movie where id = (:id)")
    Movie selectById(String id);

    @Query("select * from movie")
    List<Movie> selectAll();
}
