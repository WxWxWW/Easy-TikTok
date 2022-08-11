package com.bytedance.movies.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bytedance.movies.R;
import com.bytedance.movies.databinding.ActivityWebBinding;
import com.bytedance.movies.network.TokenService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
//网络数据测试类
public class WebActivity extends AppCompatActivity {

    private ActivityWebBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        LogUtil.setLogMode(true);
        //发送网络请求
        binding.sendRequest.setOnClickListener((View view) -> {
            try {
                sendRequest();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void sendRequest() throws IOException{
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://open.douyin.com")
                .build();
        TokenService tokenService = retrofit.create(TokenService.class);
        tokenService.postApplicationMessage("aw5x8c7fh8dcrwnz",
                "d6f34af50b6f7de2cbf496c55c9e0f3b","client_credential")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String body = null;
                        try {
                            body = response.body().string();
                            LogUtil.d(body);
                            binding.textResponse.setText("请求成功" + body);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        binding.textResponse.setText("请求失败" + t.getMessage());
                    }
                });
    }
}