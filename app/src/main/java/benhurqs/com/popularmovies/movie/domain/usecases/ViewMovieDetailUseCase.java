package benhurqs.com.popularmovies.movie.domain.usecases;

import android.support.annotation.NonNull;

import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.commons.domain.usecases.UseCase;
import benhurqs.com.popularmovies.commons.domain.usecases.UseCaseCallback;
import benhurqs.com.popularmovies.movie.data.managers.MovieCallback;
import benhurqs.com.popularmovies.movie.data.managers.MovieRepository;
import benhurqs.com.popularmovies.movie.domain.entities.MovieDetailObj;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benhursouza on 28/03/17.
 */

public class ViewMovieDetailUseCase extends UseCase<MovieRequestValue, MovieDetailObj> implements MovieCallback {

    private MovieRepository repository;
    private UseCaseCallback useCaseCallback;
    private static ViewMovieDetailUseCase instance;

    public static ViewMovieDetailUseCase getInstance(@NonNull MovieRepository repository, @NonNull UseCaseCallback useCaseCallback){
        if(instance == null){
            instance = new ViewMovieDetailUseCase(repository, useCaseCallback);
        }

        return instance;
    }


    public ViewMovieDetailUseCase(@NonNull MovieRepository repository, @NonNull UseCaseCallback useCaseCallback) {
        this.repository = checkNotNull(repository, "repository cannot be null!");
        this.useCaseCallback = checkNotNull(useCaseCallback, "useCaseCallback cannot be null!");
    }


    @Override
    public void executeUseCase(@NonNull MovieRequestValue requestValues) {
        checkNotNull(requestValues);

        repository.findMovie(requestValues.movieId, this);
    }

    @Override
    public void onStart() {
        useCaseCallback.onStart();
    }

    @Override
    public void onSuccess(Movie movie) {
        useCaseCallback.onSuccess(MovieDetailObj.convertToObj(movie));
    }

    @Override
    public void onError(String error) {
        useCaseCallback.onError(error);
    }

    @Override
    public void onFinish() {
        useCaseCallback.onFinish();
    }
}
