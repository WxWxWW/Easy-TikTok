package com.bytedance.movies;

import android.app.Application;
import android.content.Context;

import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;

/**
 * @Classname MoviesApplication
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/10 20:58
 */
public class MoviesApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        String clientkey = "aw5x8c7fh8dcrwnz"; // 需要到开发者网站申请并替换
        DouYinOpenApiFactory.init(new DouYinOpenConfig(clientkey));
    }

    public static Context getContext(){
        return context;
    }
}
