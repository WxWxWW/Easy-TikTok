package com.bytedance.movies.logic.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @Classname TokenService
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/11 23:50
 */
public interface TokenService {
    //获取access_token,有效时间为两小时
    @Headers("Content-Type: multipart/form-data")
    @POST("oauth/client_token/")
    public Call<ResponseBody> postApplicationMessage(@Query("client_key") String clientKey,
                                                     @Query("client_secret") String clientSecret,
                                                     @Query("grant_type") String grantType);
    //通过access_token，获取新的access_token
    @Headers("Content-Type: multipart/form-data")
    @POST("/oauth/renew_refresh_token/")
    public Call<ResponseBody> postApplicationOldToken(@Query("client_key") String clientKey,
                                                      @Query("client_key") String refreshToken);

}
