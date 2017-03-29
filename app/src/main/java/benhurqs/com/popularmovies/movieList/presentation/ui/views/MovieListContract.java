package benhurqs.com.popularmovies.movieList.presentation.ui.views;

import android.content.Context;

import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieListObj;
import benhurqs.com.popularmovies.movieList.domain.usecases.MovieListType;

/**
 * Created by benhursouza on 28/03/17.
 */
public interface MovieListContract {

    interface View{
        void showDialog();
        void hideDialog();
        void showError(String error);
        void loadMovieList(MovieListObj movies);
        Context getContext();

    }

    interface Presenter{
        void clickMovie(long movieId);
        void sort(@MovieListType.Order int order);
        void onStart();
    }

}
