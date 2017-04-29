package benhurqs.com.popularmovies.movieList.presentation.ui.contract;

import android.content.Context;

import benhurqs.com.popularmovies.movieList.domain.entities.MovieListObj;
import benhurqs.com.popularmovies.movieList.domain.usecases.MovieListType;

/**
 * Created by benhursouza on 28/03/17.
 */
public interface MovieListContract {

    interface View{
        void showProgress();
        void hideProgress();
        void showError(String error);
        void loadMovieList(MovieListObj movies);
        void changeTitle(String title);
        Context getContext();

    }

    interface Presenter{
        void sort(@MovieListType.Order int order);
        void onStart();
    }

}
