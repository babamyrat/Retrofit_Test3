package com.example.retrofit_test3.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit_test3.model.MovieMode;
import com.example.retrofit_test3.network.APIService;
import com.example.retrofit_test3.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<MovieMode>> moviesList;

    public MovieListViewModel(){
        moviesList = new MutableLiveData<>();
    }

    public MutableLiveData<List<MovieMode>> getMoviesListObserver() {
        return moviesList;

    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<MovieMode>> call = apiService.getMovieList();
        call.enqueue(new Callback<List<MovieMode>>() {
            @Override
            public void onResponse(Call<List<MovieMode>> call, Response<List<MovieMode>> response) {
                moviesList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieMode>> call, Throwable t) {
                moviesList.postValue(null);
            }
        });
    }
}
