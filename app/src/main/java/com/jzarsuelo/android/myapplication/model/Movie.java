package com.jzarsuelo.android.myapplication.model;

/**
 * Created by Pao on 5/6/17.
 */

public class Movie {

    private String mTitle;

    private double mVoteAverage;

    private long mVoteCount;

    private String mReleaseDate;

    private String mSynopsis;

    public Movie() {
    }

    public Movie(String title, double voteAverage, long voteCount, String releaseDate, String synopsis) {
        mTitle = title;
        mVoteAverage = voteAverage;
        mVoteCount = voteCount;
        mReleaseDate = releaseDate;
        mSynopsis = synopsis;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(double voteAverage) {
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

    public String getSynopsis() {
        return mSynopsis;
    }

    public void setSynopsis(String synopsis) {
        mSynopsis = synopsis;
    }
}
