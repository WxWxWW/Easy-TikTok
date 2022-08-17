package com.qxy.minitiktok.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @Classname BaseFragment
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/17 21:35
 */
public abstract class BaseFragment<VM extends ViewModel,VDB extends ViewDataBinding> extends Fragment {

    protected VM model;
    protected VDB binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        model = new ViewModelProvider(this).get(getViewModelClass());
        return binding.getRoot();
    }

    protected abstract Class<VM> getViewModelClass();

    protected abstract @LayoutRes Integer getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
