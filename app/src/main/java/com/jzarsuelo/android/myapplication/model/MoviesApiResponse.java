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

    public MoviesApiResponse() {
    }

    public MoviesApiResponse(Long page, List<Movie> movies, Long totalResults, Long totalPages) {
        mPage = page;
        mMovies = movies;
        mTotalResults = totalResults;
        mTotalPages = totalPages;
    }

    public Long getPage() {
        return mPage;
    }

    public void setPage(Long page) {
        mPage = page;
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void setMovies(List<Movie> movies) {
        mMovies = movies;
    }

    public Long getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(Long totalResults) {
        mTotalResults = totalResults;
    }

    public Long getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Long totalPages) {
        mTotalPages = totalPages;
    }
}
