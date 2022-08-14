package com.bytedance.movies.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @Classname BaseAdapter
 * @Description: 一个适配器，通用
 * @Created by 康斯坦丁
 * @Date 2022/8/13 9:49
 */
public abstract class BaseAdapter<T,VB extends ViewBinding> extends ItemViewBinder<T,BaseAdapter.BaseAdapterHolder<VB>> {
    @NonNull
    @Override
    protected BaseAdapterHolder<VB> onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new BaseAdapterHolder<>(onCreateViewBinding(LayoutInflater.from(parent.getContext()),parent));
    }

    protected abstract VB onCreateViewBinding(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent);

    @Override
    protected void onBindViewHolder(@NonNull BaseAdapterHolder<VB> holder, @NonNull T item) {
        onBindViewHolder(holder.getViewBinding(),item,holder.getAdapterPosition());
    }

    protected abstract void onBindViewHolder(VB viewBinding,T item,int position);

    public static class BaseAdapterHolder<VB extends ViewBinding> extends RecyclerView.ViewHolder {
        private final VB viewBinding;

        public BaseAdapterHolder(@NonNull VB viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }
        public VB getViewBinding(){
            return viewBinding;
        }
    }

}
