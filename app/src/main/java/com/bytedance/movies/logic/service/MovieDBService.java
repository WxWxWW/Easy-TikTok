package com.bytedance.movies.logic.service;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.bytedance.movies.logic.dao.MovieDBDao;
import com.bytedance.movies.entities.Movie;

@Database(entities = {Movie.class},version = 1,exportSchema = false)
public abstract class MovieDBService extends RoomDatabase {
    public abstract MovieDBDao movieDBDao();
}
