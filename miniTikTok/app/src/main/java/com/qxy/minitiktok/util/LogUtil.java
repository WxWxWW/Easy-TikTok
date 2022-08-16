package com.qxy.minitiktok.util;

import android.text.TextUtils;
import android.util.Log;

public class LogUtil {
    //默认log模式为 false
    private static boolean isLogMode = false;
    public static void setLogMode(boolean logMode){
        isLogMode = logMode;
    }
    //设置link模式
    private static boolean isLinkMode = true;
    public static void setLinkMode(boolean linkMode) {
        isLinkMode = linkMode;
    }
    //因为是三层嵌套，所以为3才能显示最外层出错的代码信息
    private static final int CALL_STACK_INDEX = 3;

    //设置标签tag
    private static String TAG = "TikTokLog";
    public static void setTAG(String TAG) {
        if(!TextUtils.isEmpty(TAG))
            LogUtil.TAG = TAG;
    }

    public static int v(String tag, String msg){
        return isLogMode ? Log.v(Tag(tag),Msg(msg)) : -1;
    }

    public static int v(String msg){
        return isLogMode ? Log.v(TAG,Msg(msg)) : -1;
    }

    public static int d(String tag,String msg){
        return isLogMode ? Log.d(Tag(tag),Msg(msg)) : -1;
    }

    public static int d(String msg){
        return isLogMode ? Log.d(TAG,Msg(msg)) : -1;
    }

    public static int i(String tag,String msg){
        return isLogMode ? Log.i(Tag(tag),Msg(msg)) : -1;
    }

    public static int i(String msg){
        return isLogMode ? Log.i(TAG,Msg(msg)) : -1;
    }

    public static int w(String tag,String msg){
        return isLogMode ? Log.w(Tag(tag),Msg(msg)) : -1;
    }

    public static int w(String msg){
        return isLogMode ? Log.w(TAG,Msg(msg)) : -1;
    }

    public static int e(String tag,String msg){
        return isLogMode ? Log.e(Tag(tag),Msg(msg)) : -1;
    }

    public static int e(String msg){
        return isLogMode ? Log.e(TAG,Msg(msg)) : -1;
    }

    private static String Msg(String msg){
        return isLinkMode ? LogHelper.wrapMessage(CALL_STACK_INDEX,msg) : msg;
    }

    private static String Tag(String tag){
        return TextUtils.isEmpty(tag) ? LogUtil.TAG : tag;
    }
}
