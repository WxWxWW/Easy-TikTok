package com.qxy.minitiktok.douyindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.qxy.minitiktok.R;

public class DemoActivity extends AppCompatActivity {

    DouYinOpenApi douYinOpenApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        String clientkey = "awi8027ob33cpbg7"; // 需要到开发者网站申请并替换
        findViewById(R.id.btn_authorize).setOnClickListener((v) -> {
            DouYinOpenApiFactory.init(new DouYinOpenConfig(clientkey));
            douYinOpenApi = DouYinOpenApiFactory.create(this);
            Authorization.Request request = new Authorization.Request();
            request.scope = "trial.whitelist";
            request.callerLocalEntry = "com.qxy.minitiktok.douyindemo.CallbackActivity";
            douYinOpenApi.authorize(request);
        });
    }
}