package com.bytedance.movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.bytedance.movies.base.BaseActivity;
import com.bytedance.movies.base.BaseViewModel;
import com.bytedance.movies.databinding.ActivityMainBinding;
import com.bytedance.movies.databinding.ActivityWebBinding;

//app的入口
public class MainActivity extends BaseActivity<BaseViewModel, ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected ActivityMainBinding onCreateViewBinding(@NonNull LayoutInflater layoutInflater) {
        return ActivityMainBinding.inflate(layoutInflater);
    }

    @Override
    protected Class<BaseViewModel> onViewModel() {
        return BaseViewModel.class;
    }
}