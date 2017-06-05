package com.jzarsuelo.android.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzarsuelo.android.myapplication.MovieApp;
import com.jzarsuelo.android.myapplication.R;
import com.jzarsuelo.android.myapplication.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Pao on 5/6/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> mMovieList;

    public MovieAdapter(List<Movie> movieList) {
        mMovieList = movieList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        ViewHolder viewHolder = new ViewHolder(rootView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindView(holder, mMovieList.get(position) );
    }

    @Override
    public int getItemCount() {
        if (mMovieList == null) {
            return 0;
        } else {
            return mMovieList.size();
        }
    }

    public void updateData(List<Movie> movies) {
        mMovieList = movies;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.iv_poster)
        ImageView mImagePoster;

        @BindView(R.id.tv_title)
        TextView mTextTitle;

        @BindView(R.id.tv_overview)
        TextView mTextOverview;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        /**
         * Helper method for binding the views
         */
        private void bindView(ViewHolder viewHolder, Movie movie) {
            Context context = MovieApp.getContext();

            final String posterPath = String.format( context.getString(R.string.tmdb_poster_base_url), movie.getPosterPath() );

            Picasso.with(context).load( posterPath ).into(viewHolder.mImagePoster);
            viewHolder.mTextTitle.setText( movie.getTitle() );
            viewHolder.mTextOverview.setText( movie.getOverview() );
        }

        @Override
        public void onClick(View v) {
            // TODO navigate to MovieActivity
        }
    }
}
