package com.bytedance.movies.ui.fragment.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bytedance.movies.R;
import com.bytedance.movies.databinding.MovieDetailViewBinding;
import com.bytedance.movies.entities.Movie;
import com.bytedance.movies.logic.dao.MovieCacheDao;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> data;
    private Context context;

    public MovieAdapter(List<Movie> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.movie_info_view, null);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setMovie(data.get(position),position);
        System.out.println(position);

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
}

/**
 * ViewHolder
 */
class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ImageView movieImage;
    private TextView movieHotImage;
    private TextView movieTitle;
    private TextView movieDouban;
    private TextView movieType;
    private TextView movieYear;
    private TextView movieHot;
    private Button movieBuy;
    private Movie movie;
    private View rootView;
    private Object lock;
    private AlertDialog detailDialog;

    public TextView getMovieHotImage() {
        return movieHotImage;
    }

    public void setMovie(Movie movie,int position) {
        this.movie = movie;
        init();
        if(position>2) {
            movieHotImage.setVisibility(View.GONE);
        }
        else {
            movieHotImage.setVisibility(View.VISIBLE);
            movieHotImage.setText("TOP "+(position+1));
        }
    }

    public boolean locked() {
        return lock != null;
    }
    public void lock(){
        lock = new Object();
    }

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        movieImage = (ImageView) itemView.findViewById(R.id.movie_image);
        movieHotImage = (TextView) itemView.findViewById(R.id.movie_hot_image);
        movieTitle = (TextView) itemView.findViewById(R.id.movie_title);
        movieDouban = (TextView) itemView.findViewById(R.id.movie_douban);
        movieType = (TextView) itemView.findViewById(R.id.movie_type);
        movieYear = (TextView) itemView.findViewById(R.id.movie_year);
        movieHot = (TextView) itemView.findViewById(R.id.movie_hot);
        movieBuy = (Button) itemView.findViewById(R.id.movie_buy);
        rootView = itemView;
        rootView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        System.out.println("click");
        if(detailDialog==null){
            MovieDetailViewBinding binder = DataBindingUtil.inflate(LayoutInflater.from(rootView.getContext()), R.layout.movie_detail_view, null, false);
            binder.setMovie(movie);
            detailDialog = new AlertDialog.Builder(rootView.getContext())
                    .setPositiveButton("ok",null)
                    .setView(binder.getRoot())
                    .create();

            //detailDialog.setContentView(binder.getRoot());
        }
        detailDialog.show();
    }

    public void init() {
        movieTitle.setText(movie.getName());
        List<String> areas = movie.getAreas();
        movieDouban.setText(movie.stringSplit(areas));
        List<String> tags = movie.getTags();
        movieType.setText(movie.stringSplit(tags));
        String date = movie.getRelease_date();
        if (date != null)
            movieYear.setText(date.substring(0, Math.min(4, date.length())));
        double v = movie.getHot();
        movieHot.setText(movie.readDouble(v));
        MovieCacheDao dao = MovieCacheDao.newInstance(rootView.getContext(), "poster");
        Drawable drawable = dao.getPosterById(movie.getId(), movie.getPoster());
        if (drawable != null) {
            movieImage.setImageDrawable(drawable);
        } else {
            new Handler().post(() -> {
                Glide.with(rootView).load(movie.getPoster()).into(movieImage);
                Drawable dw = dao.getPosterById(movie.getId(), movie.getPoster());
                if (dw != null) {
                    movieImage.setImageDrawable(dw);
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    dao.writePosterCache(movie.getId(), dw);
                }
            });
        }
    }

/*    private String stringSplit(List<String> ls) {
        if (ArrayUtil.isEmpty(ls)) return "";
        StringBuilder builder = new StringBuilder(ls.get(0));
        for (int i = 1; i < ls.size(); i++) {
            builder.append(" / ").append(ls.get(i));
        }
        return builder.toString();
    }

    private String readDouble(double v) {
        String pw = "";
        if (v > 1e11) {
            v /= 1e12;
            pw = "万亿";
        } else if (v > 1e7) {
            v /= 1e8;
            pw = "亿";
        } else if (v > 1e3) {
            v /= 1e4;
            pw = "万";
        } else {
            return "" + v;
        }
        if (v < 1) return String.format("%.2f%s", v, pw);
        return String.format("%.1f%s", v, pw);
    }*/
}
