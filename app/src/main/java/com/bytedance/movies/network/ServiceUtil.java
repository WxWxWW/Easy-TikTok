package com.bytedance.movies.network;

import android.widget.Toast;

import com.bytedance.movies.MoviesApplication;
import com.bytedance.movies.base.utils.LogUtil;
import com.bytedance.movies.base.utils.StringUtils;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Classname HttpUtil
 * @Description: 封装相应的网络请求
 * @Created by 康斯坦丁
 * @Date 2022/8/11 22:39
 */
public class ServiceUtil {
    private final String address = "https://open.douyin.com";
    private final String clientKey = "aw5x8c7fh8dcrwnz";
    private final String clientSecret = "d6f34af50b6f7de2cbf496c55c9e0f3b";

    //用户授权后的获取的token
    //十五天后失效,项目目前不需要对其进行处理，后期会修改
    private String auth_access_token = "act.503c2fbf102e5484ff2069e6b46a9b7ba4NaSrmtXhLi9kMJ9BZWReF8svn7";
    //用于刷新access_token,不推荐保存在本地，30天后失效
    private String refresh_token = "rft.ea42fad54685f58f82b08d412c8fac33IZsK9uFvFVHdf5DDhIE3la7QrrkJ";



    //两小时刷新一次(获取之后5分钟内重新获取)
    private String client_token = null;
    //获取的json数据
    private String Data = null;
    //格式解析
    private Retrofit retrofitOfConv = new Retrofit.Builder()
            .baseUrl(address)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    //不解析
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(address)
            .build();

    //全局唯一
    private static ServiceUtil serviceUtil;
    private ServiceUtil(){}

    public static synchronized ServiceUtil getServiceUtil(){
        if(serviceUtil == null)
            serviceUtil = new ServiceUtil();
        return serviceUtil;
    }

    //获取client_token
    public synchronized String getClientToken(){
        TokenService tokenService = retrofit.create(TokenService.class);
        Call<ResponseBody> bodyCall = tokenService.getClientToken(clientKey, clientSecret,
                "client_credential");
            new Thread(() -> {
                try {
                Response<ResponseBody> execute = bodyCall.execute();
                if(execute.isSuccessful()){
                    client_token = StringUtils.getFieldValueFromJson(execute.body().string(),"access_token");
                }else{
                    Toast.makeText(MoviesApplication.getContext()
                            , "client_token获取失败", Toast.LENGTH_SHORT).show();
                }
                } catch (IOException e) {
                    e.printStackTrace();
                    LogUtil.d("ServiceUtil.getClientToken","失败，出现异常IOException");
                }
            }).start();
        return client_token;

//        retrofit.create(TokenService.class)
//                .getClientToken(clientKey, clientSecret,"client_credential")
//                .enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        try {
//                            String responseData = response.body().string();
//                            client_token = StringUtils.getFieldValueFromJson(responseData,"access_token");
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        t.printStackTrace();
//                    }
//                });

    }




    //对外网络接口
    public synchronized <T extends Object> T create(Class<T> serviceClass,boolean isConverter){
        if(isConverter == true)
            return retrofitOfConv.create(serviceClass);
        else
            return retrofit.create(serviceClass);
    }
    //获取榜单数据
//    public  String getMovieListData(Integer type,boolean isConverter){
//
//    }
    public  String getMovieListData(Integer type,Integer version,boolean isConverter){
        if(version == null){
            serviceUtil.create(MoviesService.class,isConverter)
                    .getMoviesData(serviceUtil.getClientToken(),type)
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                Data = response.body().string();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
        }else{
            serviceUtil.create(MoviesService.class,isConverter)
                    .getMoviesData(serviceUtil.getClientToken(),type,version)
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                Data = response.body().string();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
        }
        return Data;
    }

}
