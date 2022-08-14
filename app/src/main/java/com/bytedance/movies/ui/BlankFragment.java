package com.bytedance.movies.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bytedance.movies.R;
import com.bytedance.movies.base.BaseFragment;
import com.bytedance.movies.base.BaseViewModel;
import com.bytedance.movies.base.utils.FileUtil;
import com.bytedance.movies.database.bean.Movie;
import com.bytedance.movies.databinding.FragmentShowBaseBinding;

import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends BaseFragment<BaseViewModel, FragmentShowBaseBinding> {

    private String moviesData;
    private int index;

    public void setIndex(int index) {
        this.index = index;
    }

    public BlankFragment() {
        // Required empty public constructor
    }

    public void setMoviesData(String moviesData) {
        this.moviesData = moviesData;
    }

    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }


    @Override
    protected Class<BaseViewModel> onViewModel() {
        return BaseViewModel.class;
    }

    @Override
    protected FragmentShowBaseBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentShowBaseBinding.inflate(inflater,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).setSupportActionBar(getViewBinding().showToolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if(index == 1){
            getViewBinding().collapsing.setTitle("电影榜");
            Glide.with(this).load(R.mipmap.background).into(getViewBinding().imageList);
        }else if(index == 2){
            getViewBinding().collapsing.setTitle("剧集榜");
            Glide.with(this).load(R.mipmap.background1).into(getViewBinding().imageList);
        }else {
            getViewBinding().collapsing.setTitle("综艺");
            Glide.with(this).load(R.mipmap.background2).into(getViewBinding().imageList);
        }
        initRecyclerView();
    }



    private void initRecyclerView() {
        MultiTypeAdapter adapter = new MultiTypeAdapter();
        adapter.register(Movie.class,new VarietyAdapter(getContext()));
        List<Movie> movies = FileUtil.loadObject(moviesData);
        Items items = new Items();
        for (int i = 0; i < 10 && i < movies.size(); i++) {
            items.add(movies.get(i));
        }
        adapter.setItems(items);
        getViewBinding().recyclerviewList.setLayoutManager(new LinearLayoutManager(getContext()));
        getViewBinding().recyclerviewList.setAdapter(adapter);
    }
}