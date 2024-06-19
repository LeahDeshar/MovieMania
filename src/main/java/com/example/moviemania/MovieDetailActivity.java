package com.example.moviemania;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.moviemania.model.Movie;

public class MovieDetailActivity extends AppCompatActivity {
    private Movie movie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movie_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView posterImageView = findViewById(R.id.movie_poster);
        TextView titleTextView = findViewById(R.id.movie_title);
        TextView overviewTextView = findViewById(R.id.movie_overview);
        RatingBar ratingBar = findViewById(R.id.movie_rating);
        TextView ratingValueTextView = findViewById(R.id.movie_rating_value);

        movie = (Movie) getIntent().getSerializableExtra("movie");

        if (movie != null) {
            titleTextView.setText(movie.getTitle());
            overviewTextView.setText(movie.getOverview());
            ratingValueTextView.setText(String.valueOf(movie.getVoteAverage()));

            // Set rating bar value
            float rating = (float) (movie.getVoteAverage() / 2); // Assuming the rating is out of 10, we convert it to a 5-star scale
            ratingBar.setRating(rating);

            Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w500" + movie.getPosterPath())
                    .into(posterImageView);
        }
    }
}