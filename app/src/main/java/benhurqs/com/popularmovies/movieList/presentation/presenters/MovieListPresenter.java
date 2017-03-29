package benhurqs.com.popularmovies.movieList.presentation.presenters;

import benhurqs.com.popularmovies.commons.domain.usecases.UseCaseCallback;
import benhurqs.com.popularmovies.injection.Injection;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieListObj;
import benhurqs.com.popularmovies.movieList.domain.usecases.MovieListType;
import benhurqs.com.popularmovies.movieList.domain.usecases.ViewMovieListUseCase;
import benhurqs.com.popularmovies.movieList.presentation.ui.views.MovieListContract;

/**
 * Created by benhursouza on 28/03/17.
 */

public class MovieListPresenter implements MovieListContract.Presenter {

    private MovieListContract.View mView;
    private ViewMovieListUseCase useCase;

    public MovieListPresenter(MovieListContract.View mView) {
        this.mView = mView;
    }

    private void init(){
        useCase = Injection.provideMovieListUseCase(mView.getContext(), new UseCaseCallback<MovieListObj>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(MovieListObj movielist) {
                mView.loadMovieList(movielist);
            }

            @Override
            public void onError(String error) {

            }

            @Override
            public void onFinish() {

            }
        });
    }

    @Override
    public void sort(@MovieListType.Order int order) {
        useCase.executeUseCase(MovieListType.sortBy(order));
    }

    @Override
    public void clickMovie(long movieId) {

    }

    @Override
    public void onStart() {
        init();
    }
}
