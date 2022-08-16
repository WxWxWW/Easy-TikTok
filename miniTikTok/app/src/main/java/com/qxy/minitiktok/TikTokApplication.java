package com.qxy.minitiktok;

import android.app.Application;
import android.content.Context;

import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;

/**
 * @Classname TikTokApplication
 * @Description: 应用全局变量存放处
 * @Created by 康斯坦丁
 * @Date 2022/8/10 15:52
 */
public class TikTokApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化DouYinOpenApiFactory
        String clientkey = "awi8027ob33cpbg7"; // 需要到开发者网站申请
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

}
