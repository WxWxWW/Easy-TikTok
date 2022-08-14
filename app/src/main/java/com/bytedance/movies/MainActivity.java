package com.bytedance.movies;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bytedance.movies.base.BaseActivity;
import com.bytedance.movies.base.BaseFragment;
import com.bytedance.movies.base.BaseViewModel;
import com.bytedance.movies.base.utils.FileUtil;
import com.bytedance.movies.base.utils.LogUtil;
import com.bytedance.movies.base.utils.PageConstraints;
import com.bytedance.movies.base.utils.StringUtils;
import com.bytedance.movies.database.bean.Movie;
import com.bytedance.movies.database.bean.Tv;
import com.bytedance.movies.database.bean.Variety;
import com.bytedance.movies.databinding.ActivityMainBinding;
import com.bytedance.movies.databinding.ActivityWebBinding;
import com.bytedance.movies.network.MoviesService;
import com.bytedance.movies.network.ServiceUtil;
import com.bytedance.movies.network.TokenService;
import com.bytedance.movies.ui.TestFragment;
import com.permissionx.guolindev.PermissionX;

import java.io.IOException;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//app的入口
public class MainActivity extends BaseActivity<BaseViewModel, ActivityMainBinding> {


    
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ServiceUtil.getServiceUtil().address)
            .build();

    String token = null;
    ServiceUtil serviceUtil = ServiceUtil.getServiceUtil();
    
    private String movies = PageConstraints.getMoviesData();
    private String tvs = PageConstraints.getTvData();
    private String varieties = PageConstraints.getVarietyData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.setLogMode(true);
        grantPermission();
        getClientToken(retrofit);
        setTabLayout();
        getViewBinding().btnSearch.setOnClickListener((v) -> {
            getData();
            //通知fragment进行数据UI更新
            setTabLayout();
        });

    }

    private void getData() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if(info == null){
            getCaheData();
            LogUtil.d("读取本地文件");
        }else{
            if(token != null) {
                MoviesService service = retrofit.create(MoviesService.class);
                service.getMoviesData(token, 1).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                             movies = response.body().string();
                            LogUtil.d(movies);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(MoviesApplication.getContext(), "请稍后再试", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });
                service.getMoviesData(token, 2).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            tvs = response.body().string();
                            LogUtil.d(tvs);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(MoviesApplication.getContext(), "请稍后再试", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });
                service.getMoviesData(token, 3).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            varieties = response.body().string();
                            LogUtil.d(varieties);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(MoviesApplication.getContext(), "请稍后再试", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });
            }else{
                Toast.makeText(this, "请刷新重试", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getClientToken(Retrofit retrofit) {
        new Thread() {
            @Override
            public void run() {
                try
                {
                    Response<ResponseBody> response = retrofit.create(TokenService.class).getClientToken(serviceUtil.clientKey,
                            serviceUtil.clientSecret, serviceUtil.grantType).execute();
                    String responseData = response.body().string();
                    LogUtil.d(responseData);
                    token = StringUtils.getFieldValueFromJson(responseData, "access_token");
                    LogUtil.v(token);
                } catch(
                        IOException e)

                {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    //读取本地缓存
    private void getCaheData() {
        Toast.makeText(this, "当前无网络或网络数据获取异常", Toast.LENGTH_SHORT).show();
        movies = FileUtil.load(PageConstraints.MOVIES_FILE);
        tvs = FileUtil.load(PageConstraints.TV_FILE);
        varieties = FileUtil.load(PageConstraints.VARIETY_FILE);
        LogUtil.d("读取本地文件");
    }

    private void setTabLayout() {
        String[] tabs = {"电 影","剧 集","综 艺"};
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new TestFragment(movies));//电影
        fragments.add(new TestFragment(tvs));//剧集
        fragments.add(new TestFragment(varieties));//综艺
        for (String s: tabs) {
            getViewBinding().tabLayout.addTab(getViewBinding().tabLayout.newTab().setText(s));
        }
        getViewBinding().viewPage.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
            @Override
            public int getCount() {
                return fragments.size();
            }
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabs[position];
            }
        });
        getViewBinding().tabLayout.setupWithViewPager(getViewBinding().viewPage,false);
    }

    //获取授权
    private void grantPermission() {
        StringBuilder denied = new StringBuilder();
        PermissionX.init(this).permissions(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .onExplainRequestReason(((scope, deniedList) -> {
                    Set<String> permissions = new HashSet<>();
                    for(String s : deniedList){
                        if(s.equals("android.permission.READ_EXTERNAL_STORAGE") ||
                                s.equals("android.permission.READ_EXTERNAL_STORAGE")){
                            permissions.add("存储权限");
                        }
                    }
                    denied.append(Arrays.toString(permissions.toArray(new String[permissions.size()])));
                    scope.showRequestReasonDialog(deniedList,"你需要一下应用所需授权，才能正常使用",
                            "同意","拒绝");
                }))
                .request(((allGranted, grantedList, deniedList) -> {
                    if(allGranted){
                        Toast.makeText(this, "你已获得所有权限", Toast.LENGTH_SHORT).show();
                    }else{

                        Toast.makeText(this, "你拒绝了以下权限" + denied.toString() ,
                                Toast.LENGTH_SHORT).show();
                        LogUtil.d("你拒绝了以下权限" + denied.toString());
                    }
                }));
    }
    //保存
    @Override
    protected void onDestroy() {
        super.onDestroy();
        FileUtil.save(movies,PageConstraints.MOVIES_FILE);
        FileUtil.save(tvs,PageConstraints.TV_FILE);
        FileUtil.save(varieties,PageConstraints.VARIETY_FILE);
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