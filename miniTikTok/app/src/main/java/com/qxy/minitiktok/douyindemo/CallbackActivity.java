package com.qxy.minitiktok.douyindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bytedance.sdk.open.aweme.CommonConstants;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.qxy.minitiktok.MainActivity;
import com.qxy.minitiktok.R;

public class CallbackActivity extends AppCompatActivity implements IApiEventHandler {

    DouYinOpenApi douYinOpenApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        douYinOpenApi = DouYinOpenApiFactory.create(this);
        douYinOpenApi.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp resp) {
        if (resp.getType() == CommonConstants.ModeType.SHARE_CONTENT_TO_TT_RESP) {
            Share.Response response = (Share.Response) resp;
            Toast.makeText(this, " code：" + response.errorCode + " 文案：" + response.errorMsg, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DemoActivity.class);
            startActivity(intent);
        } else if (resp.getType() == CommonConstants.ModeType.SEND_AUTH_RESPONSE) {
            Authorization.Response response = (Authorization.Response) resp;
            Intent intent = null;
            if (resp.isSuccess()) {
                Log.d("AuthCode", "onResp: " + ((Authorization.Response) resp).authCode);
                Log.d("AuthCode", "onResp: " + response.authCode);
                Log.d("AuthCode", "onResp: " + response.state);
                ((TextView)findViewById(R.id.successful)).setText("授权成功，获得权限" + response.grantedPermissions + "状态" + response.state +"authCode:"+ response.authCode);
                Toast.makeText(this, "授权成功，获得权限：" + response.grantedPermissions,
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "授权失败，权限：" + response.grantedPermissions,
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onErrorIntent(Intent intent) {
        Toast.makeText(this, "Intent出错", Toast.LENGTH_LONG).show();
    }
}