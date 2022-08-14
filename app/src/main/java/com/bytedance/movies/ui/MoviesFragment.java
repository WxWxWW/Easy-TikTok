package com.bytedance.movies.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bytedance.movies.ShowActivity;
import com.bytedance.movies.base.BaseFragment;
import com.bytedance.movies.base.BaseViewModel;
import com.bytedance.movies.base.utils.FileUtil;
import com.bytedance.movies.base.utils.PageConstraints;
import com.bytedance.movies.database.bean.Movie;
import com.bytedance.movies.databinding.FragmentMainBaseBinding;

import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @Classname TestFragment
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/14 8:53
 */
public class MoviesFragment<T> extends BaseFragment<BaseViewModel, FragmentMainBaseBinding> {

    private String moviesData;

    public MoviesFragment() {
    }

    public MoviesFragment(String moviesData) {
        this.moviesData = moviesData;
    }


    public void setMoviesData(String moviesData) {
        this.moviesData = moviesData;
    }

    public interface MovieListener{
        public void sendValue(int value);
    }

    private MovieListener myListener;

    public static MoviesFragment newInstance() {
        MoviesFragment fragment = new MoviesFragment();
        return fragment;
    }

    @Override
    protected Class<BaseViewModel> onViewModel() {
        return BaseViewModel.class;
    }
    @Override
    protected FragmentMainBaseBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentMainBaseBinding.inflate(inflater,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getViewBinding().btnFullView.setOnClickListener((v) -> {
            myListener.sendValue(PageConstraints.MOVIES);
        });
        initRecyclerView();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myListener = (MovieListener) getActivity();
    }

    private void initRecyclerView() {
        MultiTypeAdapter adapter = new MultiTypeAdapter();
        adapter.register(Movie.class,new MovieAdapter(getContext()));
        List<Movie> movies = FileUtil.loadObject(moviesData);
        Items items = new Items();
        for (int i = 0; i < 10 && i < movies.size(); i++) {
//            Movie movie = new Movie();
//            movie.setName("一直一直很喜欢你");
//            movie.setHot(42567);
//            movie.setPoster("https://p3-dy.byteimg.com/obj/compass/5d9299715de44f1db6645f3466d73173?from=552310259");
            items.add(movies.get(i));
        }
        adapter.setItems(items);
        getViewBinding().recyclerviewBase.setLayoutManager(new LinearLayoutManager(getContext()));
        getViewBinding().recyclerviewBase.setAdapter(adapter);
    }
}
