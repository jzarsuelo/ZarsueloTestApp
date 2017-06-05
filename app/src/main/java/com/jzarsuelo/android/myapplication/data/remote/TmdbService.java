package com.jzarsuelo.android.myapplication.data.remote;

import com.jzarsuelo.android.myapplication.model.MoviesApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Pao on 5/6/17.
 */

public interface TmdbService {
    @GET("/3/discover/movie")
    Call<MoviesApiResponse> getMovies(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/3/discover/movie/{movie_id}")
    Call<MoviesApiResponse> getMovie(@Query("api_key") String apiKey, @Query("movie_id") String movieId);
}
