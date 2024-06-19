package com.example.moviemania.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviemania.MovieDetailActivity;
import com.example.moviemania.model.Movie;
import com.example.moviemania.R;
import com.example.moviemania.databinding.MovieListItemBinding;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> moviesArrayList;
    private int rowLayout;
    private Context context;

    public MovieAdapter(Context context,ArrayList<Movie> moviesArrayList ) {
        this.moviesArrayList = moviesArrayList;
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

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.putExtra("movie",movie);
            context.startActivity(intent);
        });

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

//            movieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(v.getContext(), movieListItemBinding.getMovie().getId(), Toast.LENGTH_SHORT).show();
//
////                    go to MovieDetail screen when clicked and pass the movie detail to it
//
//
//                }
//            });
        }


    }
}
