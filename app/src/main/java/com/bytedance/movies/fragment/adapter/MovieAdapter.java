package com.bytedance.movies.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.entities.Movie;
import com.bytedance.movies.R;

import java.util.List;

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
        Toast.makeText(context, "no yet implememt!", Toast.LENGTH_SHORT).show();
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
    }

    @Override
    public void onClick(View v) {

    }
}
