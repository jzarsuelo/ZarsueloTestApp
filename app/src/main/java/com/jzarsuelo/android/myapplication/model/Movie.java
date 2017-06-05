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
    private String moverview;

    private String mSynopsis;

    public Movie() {
    }

    public Movie(String title, Double voteAverage, long voteCount, String releaseDate, String moverview, String synopsis) {
        mTitle = title;
        mVoteAverage = voteAverage;
        mVoteCount = voteCount;
        mReleaseDate = releaseDate;
        this.moverview = moverview;
        mSynopsis = synopsis;
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

    public String getMoverview() {
        return moverview;
    }

    public void setMoverview(String moverview) {
        this.moverview = moverview;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public void setSynopsis(String synopsis) {
        mSynopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mTitle='" + mTitle + '\'' +
                ", mVoteAverage=" + mVoteAverage +
                ", mVoteCount=" + mVoteCount +
                ", mReleaseDate='" + mReleaseDate + '\'' +
                ", moverview='" + moverview + '\'' +
                ", mSynopsis='" + mSynopsis + '\'' +
                '}';
    }
}
