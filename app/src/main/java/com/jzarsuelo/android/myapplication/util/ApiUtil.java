package com.jzarsuelo.android.myapplication.util;

import com.jzarsuelo.android.myapplication.MovieApp;
import com.jzarsuelo.android.myapplication.R;
import com.jzarsuelo.android.myapplication.data.remote.RetrofitClient;
import com.jzarsuelo.android.myapplication.data.remote.TmdbService;

/**
 * Created by Pao on 5/6/17.
 */

public class ApiUtil {

    public static TmdbService getTmdbService() {

        final String baseUrl = MovieApp.getContext().getString(R.string.tmdb_base_url);

        return RetrofitClient.getClient(baseUrl).create(TmdbService.class);
    }
}
