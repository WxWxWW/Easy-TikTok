package com.bytedance.movies.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.entities.Movie;
import com.bytedance.movies.R;

import java.util.List;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder>{

    private List<Movie> data;
    private Context context;

    public MovieAdapter(List<Movie> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.movie_info_view,null);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setMovie(data.get(position));
        holder.init();
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }
}
/**
 * ViewHolder
 */
class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ImageView movieImage;
    private ImageView movieHotImage;
    private TextView movieTitle;
    private TextView movieDouban;
    private TextView movieType;
    private TextView movieYear;
    private TextView movieHot;
    private Button movieBuy;
    private Movie movie;
    private View rootView;

    public MovieViewHolder setMovie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        movieImage = (ImageView) itemView.findViewById(R.id.movie_image);
        movieHotImage = (ImageView) itemView.findViewById(R.id.movie_hot_image);
        movieTitle = (TextView) itemView.findViewById(R.id.movie_title);
        movieDouban = (TextView) itemView.findViewById(R.id.movie_douban);
        movieType = (TextView) itemView.findViewById(R.id.movie_type);
        movieYear = (TextView) itemView.findViewById(R.id.movie_year);
        movieHot = (TextView) itemView.findViewById(R.id.movie_hot);
        movieBuy = (Button) itemView.findViewById(R.id.movie_buy);
        rootView = itemView;
    }

    @Override
    public void onClick(View v) {
    }

    public void init() {
        movieTitle.setText(movie.getName());
        List<String> areas = movie.getAreas();
        movieDouban.setText(stringSplit(areas));
        List<String> tags = movie.getTags();
        movieType.setText(stringSplit(tags));
        String date = movie.getRelease_date();
        if(date!=null)
        movieYear.setText(date.substring(0,Math.min(4,date.length())));
        double v = NumberUtil.parseDouble(movie.getHot());
        movieHot.setText(readDouble(v));

    }
    private String stringSplit(List<String> ls){
        if(ArrayUtil.isEmpty(ls)) return "";
        StringBuilder builder = new StringBuilder(ls.get(0));
        for(int i=1;i<ls.size();i++){
            builder.append(" / "+ls.get(i));
        }
        return builder.toString();
    }

    private String readDouble(double v){
        String pw = "";
        if(v>1e12){
            pw="万亿";
        } else if(v>1e8){
            pw="亿";
        } else if(v>1e4){
            pw="万";
        } else {
            return ""+v;
        }
        return (""+v).substring(0,3)+pw;
    }
}
