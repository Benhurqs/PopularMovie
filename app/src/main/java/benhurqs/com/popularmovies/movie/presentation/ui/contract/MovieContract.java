package benhurqs.com.popularmovies.movie.presentation.ui.contract;

import android.content.Context;

import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.movie.domain.entities.MovieDetailObj;
import benhurqs.com.popularmovies.movieList.domain.usecases.MovieListType;

/**
 * Created by benhursouza on 29/04/17.
 */

public interface MovieContract {

    interface View{
        void showProgress();
        void hideProgress();
        void showError(String error);
        void loadMovie(MovieDetailObj movie);
        Context getContext();

    }

    interface Presenter{
        void onStart(long movieId);
    }
}
