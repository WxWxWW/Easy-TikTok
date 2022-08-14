package com.bytedance.movies.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bytedance.movies.base.BaseAdapter;
import com.bytedance.movies.base.utils.StringUtils;
import com.bytedance.movies.database.bean.Movie;
import com.bytedance.movies.databinding.ItemMainBaseBinding;
import com.bytedance.movies.databinding.ItemVarietyBinding;

/**
 * @Classname VarietyAdapter
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/14 22:28
 */
public class VarietyAdapter extends BaseAdapter<Movie, ItemVarietyBinding> {

    private @NonNull final Context context;

    public VarietyAdapter(@NonNull Context context) {
        this.context = context;
    }

    @Override
    protected ItemVarietyBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return ItemVarietyBinding.inflate(inflater,parent,false);
    }

    @Override
    protected void onBindViewHolder(ItemVarietyBinding viewBinding, Movie item, int position) {
        viewBinding.textName.setText(item.getName());
        viewBinding.textActors.setText(StringUtils.getString(item.getActors()));
        viewBinding.textDate.setText(item.getRelease_date() + "上映");
        viewBinding.textHot.setText(String.valueOf(item.getHot()));
        viewBinding.textPeriod.setText(StringUtils.isBlank(StringUtils.getString(item.getTags())) == true ? ""
                : StringUtils.getString(item.getTags()));
        Glide.with(context).load(item.getPoster()).into(viewBinding.imagePoster);
    }
}
