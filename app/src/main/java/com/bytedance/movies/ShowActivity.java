package com.bytedance.movies;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bytedance.movies.base.BaseActivity;
import com.bytedance.movies.base.BaseViewModel;
import com.bytedance.movies.base.utils.LogUtil;
import com.bytedance.movies.base.utils.PageConstraints;
import com.bytedance.movies.databinding.ActivityShowBinding;
import com.bytedance.movies.databinding.ActivityWebBinding;
import com.bytedance.movies.ui.BlankFragment;

/**
 * @Classname ShowActivity
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/14 13:23
 */
public class ShowActivity extends BaseActivity<BaseViewModel, ActivityShowBinding> {

    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    BlankFragment fragment = BlankFragment.newInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(getViewBinding().showLayout.getId(),fragment);
        transaction.commit();
        Intent intent = getIntent();
        int code = intent.getIntExtra("key",1);
//        Bundle bundle = intent.getExtras();
        //int code = bundle.getInt("key");
        getFragment(code);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getFragment(int code) {
        switch (code){
            case 1:
                fragment.setMoviesData(PageConstraints.getMoviesData());
                fragment.setIndex(1);
                transaction.replace(getViewBinding().showLayout.getId(), fragment);
                break;
            case 2:
                fragment.setMoviesData(PageConstraints.getTvData());
                fragment.setIndex(2);
                transaction.replace(getViewBinding().showLayout.getId(), fragment);
                break;
            case 3:
                fragment.setIndex(3);
                fragment.setMoviesData(PageConstraints.getVarietyData());
                transaction.replace(getViewBinding().showLayout.getId(), fragment);
                break;
            default:break;

        }
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
