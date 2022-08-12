package com.bytedance.movies.utils;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.bytedance.movies.base.BaseActivity;
import com.bytedance.movies.databinding.ActivityWebBinding;
import com.bytedance.movies.network.ServiceUtil;
import com.bytedance.movies.base.BaseViewModel;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;

//网络数据测试类
public class WebActivity extends BaseActivity<BaseViewModel,ActivityWebBinding> {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.setLogMode(true);
        //发送网络请求
        getViewBinding().sendRequest.setOnClickListener((View view) -> {
            Integer type = Integer.parseInt(getViewBinding().editType.getText().toString());
            Integer version = Integer.parseInt(getViewBinding().editType.getText().toString());
            getViewBinding().textResponse.setText(ServiceUtil.getServiceUtil().
                    getMovieListData(type,version,false));
        });
        //测试获取授权authCode
        getViewBinding().TikTokAuth.setOnClickListener((View v) ->{
            DouYinOpenApiFactory.init(new DouYinOpenConfig("aw5x8c7fh8dcrwnz"));
            DouYinOpenApi douYinOpenApi = DouYinOpenApiFactory.create(this);
            Authorization.Request request = new Authorization.Request();
            request.scope = "trial.whitelist";
            request.callerLocalEntry = "com.bytedance.movies.douyinapi.DouYinEntryActivity";
            douYinOpenApi.authorize(request);
        });

    }

    @Override
    protected ActivityWebBinding onCreateViewBinding(@NonNull LayoutInflater layoutInflater) {
        return ActivityWebBinding.inflate(getLayoutInflater());
    }

    @Override
    protected Class<BaseViewModel> onViewModel() {
        return BaseViewModel.class;
    }

}