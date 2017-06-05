package com.jzarsuelo.android.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by Pao on 5/6/17.
 */

public class MovieApp extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        if (sContext == null) {
            sContext = this;
        }
    }

    public static Context getContext() {
        return sContext;
    }
}
