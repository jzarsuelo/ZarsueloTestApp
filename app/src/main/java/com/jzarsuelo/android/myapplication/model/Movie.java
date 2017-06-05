package com.jzarsuelo.android.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pao on 5/6/17.
 */

public class Movie {

    @SerializedName("title")
    @Expose
    private String mTitle;

    @SerializedName("vote_average")
    @Expose
    private Double mVoteAverage;

    @SerializedName("vote_count")
    @Expose
    private long mVoteCount;

    @SerializedName("release_date")
    @Expose
    private String mReleaseDate;

    @SerializedName("overview")
    @Expose
    private String mOverview;

    @SerializedName("poster_path")
    @Expose
    private String mPosterPath;

    public Movie() {
    }

    public Movie(String title, Double voteAverage, long voteCount, String releaseDate, String overview, String posterPath) {
        mTitle = title;
        mVoteAverage = voteAverage;
        mVoteCount = voteCount;
        mReleaseDate = releaseDate;
        mOverview = overview;
        mPosterPath = posterPath;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        mVoteAverage = voteAverage;
    }

    public long getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(long voteCount) {
        mVoteCount = voteCount;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mTitle='" + mTitle + '\'' +
                ", mVoteAverage=" + mVoteAverage +
                ", mVoteCount=" + mVoteCount +
                ", mReleaseDate='" + mReleaseDate + '\'' +
                ", mOverview='" + mOverview + '\'' +
                ", mPosterPath='" + mPosterPath + '\'' +
                '}';
    }
}
