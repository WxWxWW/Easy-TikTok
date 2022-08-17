package com.qxy.minitiktok.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @Classname BaseViewModel
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/17 23:06
 */
public abstract class BaseViewModel extends ViewModel {

    //加载数据
    private LiveData<Boolean> loadingData = new MutableLiveData<>();
    //异常
    private LiveData<String> errorData = new MutableLiveData<>();

}
