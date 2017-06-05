package com.jzarsuelo.android.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Pao on 5/6/17.
 */

public class MoviesApiResponse {

    @SerializedName("page")
    @Expose
    private Long mPage;

    @SerializedName("results")
    @Expose
    private List<Movie> mMovies = null;

    @SerializedName("total_results")
    @Expose
    private Long mTotalResults;

    @SerializedName("total_pages")
    @Expose
    private Long mTotalPages;
}
