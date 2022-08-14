package com.bytedance.movies;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bytedance.movies.base.BaseActivity;
import com.bytedance.movies.base.BaseViewModel;
import com.bytedance.movies.databinding.ActivityShowBinding;
import com.bytedance.movies.databinding.ActivityWebBinding;

/**
 * @Classname ShowActivity
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/14 13:23
 */
public class ShowActivity extends BaseActivity<BaseViewModel, ActivityShowBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected ActivityShowBinding onCreateViewBinding(@NonNull LayoutInflater layoutInflater) {
        return ActivityShowBinding.inflate(layoutInflater);
    }

    @Override
    protected Class<BaseViewModel> onViewModel() {
        return BaseViewModel.class;
    }
}
