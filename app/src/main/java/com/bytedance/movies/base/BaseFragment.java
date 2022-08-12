package com.bytedance.movies.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewbinding.ViewBinding;

import com.bytedance.movies.utils.LogUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/**
 * @Classname BaseFragment
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/12 16:43
 */
public abstract class BaseFragment<VM extends ViewModel,VB extends ViewBinding> extends Fragment {
    //如果不绑定则可以默认传递BaseViewModel
    protected VM viewModel;
    //如果不绑定则可以默认传递BaseViewBinding
    protected VB viewBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewBinding = onCreateViewBinding(inflater,container);
        viewModel = ViewModelProviders.of(this).get(onViewModel());
        return viewBinding.getRoot();
    }

    protected abstract Class<VM> onViewModel();

    protected abstract VB onCreateViewBinding(@NonNull LayoutInflater inflater,@Nullable ViewGroup container);

    public VB getViewBinding() {
        return viewBinding;
    }

    public VM getViewModel(){
        return viewModel;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewBinding = null;
    }
}
