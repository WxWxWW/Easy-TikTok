package com.qxy.minitiktok.logic.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Classname RetrofitUtil
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/17 23:32
 */
public class RetrofitUtil {
    //响应超时
    private static final Long CALL_TIMEOUT = 10L;
    //连接超时
    private static final Long CONNECT_TIMEOUT = 20L;
    //IO超时
    private static final Long IO_TIMEOUT = 20L;

    private static Retrofit retrofit;

    static {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(IO_TIMEOUT,TimeUnit.SECONDS)
                .writeTimeout(IO_TIMEOUT,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        retrofit = new Retrofit.Builder().client(okHttpClient)
                .baseUrl(TikTokService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T extends Object> T create(Class<T> classOf){
        return retrofit.create(classOf);
    }
}
