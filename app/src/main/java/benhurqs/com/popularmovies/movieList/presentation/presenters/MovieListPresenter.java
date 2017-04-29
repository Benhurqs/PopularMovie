package benhurqs.com.popularmovies.movieList.presentation.presenters;

import benhurqs.com.popularmovies.R;
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
                mView.showProgress();
            }

            @Override
            public void onSuccess(MovieListObj movielist) {
                mView.loadMovieList(movielist);
            }

            @Override
            public void onError(String error) {
                mView.showError(error);
            }

            @Override
            public void onFinish() {
                mView.hideProgress();
            }
        });

        sort(MovieListType.POPULAR);
    }

    @Override
    public void sort(@MovieListType.Order int order) {
        useCase.executeUseCase(MovieListType.sortBy(order));
        mView.changeTitle(getTitle(order));
    }

    @Override
    public void clickMovie(long movieId) {

    }

    @Override
    public void onStart() {
        init();
    }

    private String getTitle(@MovieListType.Order int order){
        if(order == MovieListType.TOP){
            return mView.getContext().getString(R.string.top_movie_title);
        }

        return mView.getContext().getString(R.string.popular_movie_title);

    }
}
