package com.bytedance.movies.network;

import com.bytedance.movies.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @Classname TokenService
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/11 23:50
 */
public interface TokenService {
    //获取client_token,有效时间为两小时，无需授权
    @Headers("Content-Type: multipart/form-data")
    @POST("oauth/client_token/")
    public Call<ResponseBody> getClientToken(@Query("client_key") String clientKey,
                                                     @Query("client_secret") String clientSecret,
                                                     @Query("grant_type") String grantType);
    //通过refresh_token，获取新的access_token
    @Headers("Content-Type: multipart/form-data")
    @POST("/oauth/refresh_token/")
    public Call<ResponseBody> refreshAccessToken(@Query("client_key") String clientKey,
                                                      @Query("grant_type") String grantType,
                                                      @Query("refresh_token") String refreshToken);

    //通过授权得的的code获得token==>TokenData类
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @GET("/oauth/access_token/")
    public Call<ResponseBody> getAccessToken(@Query("client_key") String clientKey,
                                             @Query("client_secret") String clientSecret,
                                             @Query("grant_type") String grantType,
                                             @Query("code") String authCode);

}
