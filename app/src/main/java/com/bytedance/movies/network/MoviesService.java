package com.bytedance.movies.network;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @Classname MoviesService
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/11 23:16
 */
public interface MoviesService {
    //获取榜单信息
    @Headers({"Content-Type: application/json"})
    @GET("/discovery/ent/rank/item/")
    public Call<RequestBody> getMoviesData(@Header("access-token") String accessToken,
                                           @Query("type") int type,
                                           @Query("version") int version);

    @Headers({"Content-Type: application/json"})
    @GET("/discovery/ent/rank/item/")
    public Call<RequestBody> getMoviesData(@Header("access-token") String accessToken,
                                           @Query("type") int type);
    //获取榜单版本
    @Headers({"Content-Type: application/json"})
    @GET("/discovery/ent/rank/version/")
    public Call<RequestBody> getMoviesDataVersion(@Header("access-token") String accessToken,
                                                  @Query("type") int type,
                                                  @Query("cursor") long cursor,
                                                  @Query("count") long count);
    @Headers({"Content-Type: application/json"})
    @GET("/discovery/ent/rank/version/")
    public Call<RequestBody> getMoviesDataVersion(@Header("access-token") String accessToken,
                                                  @Query("type") int type,
                                                  @Query("count") long count);
}
