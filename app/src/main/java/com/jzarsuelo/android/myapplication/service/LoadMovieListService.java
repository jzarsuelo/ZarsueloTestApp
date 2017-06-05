package com.jzarsuelo.android.myapplication.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by Pao on 5/6/17.
 */

public class LoadMovieListService extends IntentService {

    public LoadMovieListService() {
        super(LoadMovieListService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
