package com.example.moviemania.Model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.moviemania.R;
import com.example.moviemania.serviceapi.MovieApiService;
import com.example.moviemania.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class MovieRepository {


    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieApiService movieApiService = RetrofitInstance.getService();

         Call<Result> call = movieApiService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));
        return mutableLiveData;
    }
}
