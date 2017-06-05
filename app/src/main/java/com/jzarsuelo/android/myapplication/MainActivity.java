package com.jzarsuelo.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.jzarsuelo.android.myapplication.adapter.MovieAdapter;
import com.jzarsuelo.android.myapplication.data.remote.TmdbService;
import com.jzarsuelo.android.myapplication.model.Movie;
import com.jzarsuelo.android.myapplication.model.MoviesApiResponse;
import com.jzarsuelo.android.myapplication.util.ApiUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private MovieAdapter mAdapter;

    private TmdbService mService;

    private int mPageToLoad = 1;

    @BindView(R.id.rv_movies)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mService = ApiUtil.getTmdbService();
        mAdapter = new MovieAdapter(new ArrayList<Movie>()) ;

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setAdapter(mAdapter);

        loadMovies( mPageToLoad );
    }

    private void loadMovies(int pageToLoad) {
        final String apiKey = BuildConfig.THE_MOVIE_DB_API;

        Log.d(LOG_TAG, "load movies");

        mService.getMovies(apiKey, pageToLoad).enqueue(new Callback<MoviesApiResponse>() {

            @Override
            public void onResponse(Call<MoviesApiResponse> call, Response<MoviesApiResponse> response) {

                Log.d(LOG_TAG, response.message());

                if(response.isSuccessful()) {
                    mAdapter.updateData(response.body().getMovies());
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<MoviesApiResponse> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");

            }
        });
    }

}
