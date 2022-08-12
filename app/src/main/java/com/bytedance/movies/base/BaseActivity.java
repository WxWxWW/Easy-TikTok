package com.bytedance.movies.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

import com.bytedance.movies.utils.LogUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/**
 * @Classname BaseActivity
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/10 21:50
 */
public abstract class BaseActivity<VM extends ViewModel,VB extends ViewBinding>
        extends AppCompatActivity {

    //如果不绑定则可以默认传递BaseViewModel
    private VM viewModel;
    //如果不绑定则可以默认传递BaseViewBinding
    private VB viewBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = onCreateViewBinding(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        viewModel = ViewModelProviders.of(this).get(onViewModel());
    }

    protected abstract VB onCreateViewBinding(@NonNull LayoutInflater layoutInflater);
    protected abstract Class<VM> onViewModel();

    public VB getViewBinding() {
        return viewBinding;
    }

    public VM getViewModel() {
        return viewModel;
    }
}
