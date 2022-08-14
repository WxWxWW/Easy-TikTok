package com.bytedance.movies.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bytedance.movies.base.BaseAdapter;
import com.bytedance.movies.database.bean.Movie;
import com.bytedance.movies.databinding.ItemMainBaseBinding;

/**
 * @Classname MovieAdapter
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/14 10:04
 */
public class MovieAdapter extends BaseAdapter<Movie, ItemMainBaseBinding> {

    private @NonNull final Context context;

    public MovieAdapter(@NonNull Context context) {
        this.context = context;
    }

    @Override
    protected ItemMainBaseBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return ItemMainBaseBinding.inflate(inflater,parent,false);
    }



    @Override
    protected void onBindViewHolder(ItemMainBaseBinding viewBinding, Movie item, int position) {
        viewBinding.itemMainNumber.setText(String.valueOf(position + 1));
        viewBinding.itemMainNumber.setTextColor((viewBinding.itemMainNumber.getTextColors()));
        viewBinding.itemMainHot.setText(String.valueOf(item.getHot()));
        viewBinding.itemMainName.setText(item.getName());
        Glide.with(context).load(item.getPoster()).into(viewBinding.itemMainPoster);
    }
}
