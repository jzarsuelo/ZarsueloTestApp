package com.jzarsuelo.android.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jzarsuelo.android.myapplication.adapter.MovieAdapter;
import com.jzarsuelo.android.myapplication.data.remote.TmdbService;
import com.jzarsuelo.android.myapplication.model.Movie;
import com.jzarsuelo.android.myapplication.model.MoviesApiResponse;
import com.jzarsuelo.android.myapplication.util.ApiUtil;
import com.jzarsuelo.android.myapplication.util.ConnectivityUtil;

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

    @BindView(R.id.pb_loading)
    ProgressBar mProgressBar;

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

        boolean isConnected = ConnectivityUtil.isConnected(this);
        toggleProgressVisibility(true);
        if (isConnected) {
            loadMovies( mPageToLoad );
        } else {
            toggleProgressVisibility(true);
            showNoNetworkError();
        }

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
                toggleProgressVisibility(false);
            }

            @Override
            public void onFailure(Call<MoviesApiResponse> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
                toggleProgressVisibility(false);
            }
        });
    }

    private void toggleProgressVisibility(boolean isVisible) {
        final int progressBarVisibility = isVisible ? View.VISIBLE : View.GONE;
        final int recyclerViewVisibility = isVisible ? View.GONE : View.VISIBLE;

        mProgressBar.setVisibility(progressBarVisibility);
        mRecyclerView.setVisibility(recyclerViewVisibility);
    }


    private void showNoNetworkError() {
        Snackbar.make(mRecyclerView, R.string.error_no_connection, Snackbar.LENGTH_LONG).show();
    }

}
