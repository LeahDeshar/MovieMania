package com.example.moviemania.serviceapi;

import com.example.moviemania.Model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("db3aba6560a6f950f54eb4c0fa5d6d60") String apiKey);
}
