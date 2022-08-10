package com.bytedance.movies.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Classname BaseActivity
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/10 21:50
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initData() {

    }

    protected void initView() {

    }

    @Override
    public void onClick(View v) {

    }
}
