package com.qxy.minitiktok.util;


import android.content.Context;
import android.widget.Toast;

/**
 * @Classname ToastUtils
 * @Description: Toast工具类，方便调用
 * @Created by 康斯坦丁
 * @Date 2022/8/7 17:03
 */
public class ToastUtils {
    //是否显示toast
    public static boolean isShow = true;
    //短时间
    public static void showShort(Context context,CharSequence msg){
        if(isShow)
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    public static void showShort(Context context,int msg){
        if(isShow)
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    //长时间
    public static void showLong(Context context,CharSequence msg){
        if(isShow)
            Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }

    public static void showLong(Context context,int msg){
        if(isShow)
            Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }

    //自定义时间
    public static void show(Context context,CharSequence msg,int duration){
        if(isShow)
            Toast.makeText(context, msg, duration).show();
    }

    public static void show(Context context,int msg,int duration){
        if(isShow)
            Toast.makeText(context, msg, duration).show();
    }

}
