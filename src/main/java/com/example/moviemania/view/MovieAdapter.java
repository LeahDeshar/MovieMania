package com.example.moviemania.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviemania.Model.Movie;
import com.example.moviemania.R;
import com.example.moviemania.databinding.MovieListItemBinding;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> moviesArrayList;
    private int rowLayout;
    private Context context;

    public MovieAdapter(ArrayList<Movie> moviesArrayList, int rowLayout, Context context) {
        this.moviesArrayList = moviesArrayList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MovieListItemBinding movieListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.movie_list_item, parent, false);

        return new MovieViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder,  int position) {
        Movie movie =moviesArrayList.get(position);
        holder.movieListItemBinding.setMovie(movie);
//        holder.movieDescription.setText(movies.get(position).getOverview());
//        holder.rating.setText(movies.get(position).getVoteAverage().toString());
//        Glide.with(context)
//                .load("https://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath())
//                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        private MovieListItemBinding movieListItemBinding;

        public MovieViewHolder(MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieListItemBinding = movieListItemBinding;

            movieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    int pos = getAdapterPosition();
//                    if (pos != RecyclerView.NO_POSITION) {
//                        Movie clickedDataItem = movies.get(pos);
//                        Intent intent = new Intent(context, MovieDetailActivity.class);
//                        intent.putExtra("movie", clickedDataItem);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        context.startActivity(intent);
//                    }
                }
            });
        }

        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        ImageView poster;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = v.findViewById(R.id.movies_layout);
            movieTitle = v.findViewById(R.id.tvTitle);
            rating = v.findViewById(R.id.tvRating);
            poster = v.findViewById(R.id.ivMovie);
        }
    }
}
