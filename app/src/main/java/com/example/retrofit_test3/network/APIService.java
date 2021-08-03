package com.example.retrofit_test3.network;

import com.example.retrofit_test3.model.MovieMode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("volley_array.json")
    Call<List<MovieMode>> getMovieList();
}
