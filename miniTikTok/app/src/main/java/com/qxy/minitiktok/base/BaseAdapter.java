package com.qxy.minitiktok.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


import me.drakeet.multitype.ItemViewBinder;

/**
 * @Classname BaseAdapter
 * @Description: 使用MultiTypeAdapter,去设置recyclerview的适配器，所需继承的adapter
 * @Created by 康斯坦丁
 * @Date 2022/8/17 22:15
 */
public abstract class BaseAdapter<T,VDB extends ViewDataBinding> extends ItemViewBinder<T,BaseAdapter.BaseAdapterHolder<VDB>> {

    @NonNull
    @Override
    protected BaseAdapterHolder<VDB> onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new BaseAdapterHolder<>(onCreateViewDataBinding(LayoutInflater.from(parent.getContext()),parent));
    }

    protected abstract VDB onCreateViewDataBinding(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent);

    @Override
    protected void onBindViewHolder(@NonNull BaseAdapterHolder<VDB> holder, @NonNull T item) {
        onBindViewHolder(holder.getViewBinding(),item,holder.getAdapterPosition());
    }

    protected abstract void onBindViewHolder(VDB binding,T item,int position);

    public static class BaseAdapterHolder<VDB extends ViewDataBinding> extends RecyclerView.ViewHolder {
        private final VDB binding;

        public BaseAdapterHolder(@NonNull VDB binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public VDB getViewBinding(){
            return binding;
        }
    }
}
