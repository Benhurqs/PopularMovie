package benhurqs.com.popularmovies.movie.presentation.presenters;

import benhurqs.com.popularmovies.commons.domain.usecases.UseCaseCallback;
import benhurqs.com.popularmovies.injection.Injection;
import benhurqs.com.popularmovies.movie.domain.entities.MovieDetailObj;
import benhurqs.com.popularmovies.movie.domain.usecases.MovieRequestValue;
import benhurqs.com.popularmovies.movie.domain.usecases.ViewMovieDetailUseCase;
import benhurqs.com.popularmovies.movie.presentation.ui.contract.MovieContract;

/**
 * Created by benhursouza on 29/04/17.
 */

public class MoviePresenter implements MovieContract.Presenter {

    private MovieContract.View mView;
    private ViewMovieDetailUseCase useCase;

    public MoviePresenter(MovieContract.View mView) {
        this.mView = mView;
        init();
    }

    private void init(){
        useCase = Injection.provideMovieDetailUseCase(mView.getContext(), new UseCaseCallback<MovieDetailObj>() {
            @Override
            public void onStart() {
                mView.showProgress();
            }

            @Override
            public void onSuccess(MovieDetailObj movie) {
                mView.loadMovie(movie);
                mView.hideProgress();
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

    }

    @Override
    public void onStart(long movieId) {
        useCase.executeUseCase(MovieRequestValue.setMovieId(movieId));
    }
}
