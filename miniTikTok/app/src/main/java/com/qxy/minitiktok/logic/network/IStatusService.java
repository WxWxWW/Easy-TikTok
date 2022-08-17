package com.qxy.minitiktok.logic.network;

/**
 * @Classname IStatusService
 * @Description: 网络请求服务状态
 * @Created by 康斯坦丁
 * @Date 2022/8/17 20:41
 */
public interface IStatusService {

    void isEmpty(); //数据为空
    void Error(String errorMsg);    //错误请求
    void Loading(Boolean isShow);      //加载展示数据
}
