package benhurqs.com.popularmovies.movieList.domain.usecases;

import android.support.annotation.NonNull;

import benhurqs.com.popularmovies.commons.domain.usecases.UseCase;
import benhurqs.com.popularmovies.commons.domain.usecases.UseCaseCallback;
import benhurqs.com.popularmovies.movieList.data.managers.MovielListCallback;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieListObj;
import benhurqs.com.popularmovies.movieList.domain.repositories.MovieListRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benhursouza on 26/03/17.
 */

public class ViewMovieListUseCase extends UseCase<MovieListType, MovieListObj> implements MovielListCallback{

    private MovieListRepository repository;
    private UseCaseCallback useCaseCallback;
    private static ViewMovieListUseCase instance;

    public static ViewMovieListUseCase getInstance(@NonNull MovieListRepository repository, @NonNull UseCaseCallback useCaseCallback){
        if(instance == null){
            instance = new ViewMovieListUseCase(repository, useCaseCallback);
        }

        return instance;
    }


    public ViewMovieListUseCase(@NonNull MovieListRepository repository, @NonNull UseCaseCallback useCaseCallback) {
        this.repository = checkNotNull(repository, "repository cannot be null!");
        this.useCaseCallback = checkNotNull(useCaseCallback, "useCaseCallback cannot be null!");
    }

    @Override
    public void executeUseCase(MovieListType requestValues) {
        if(requestValues.currentOrder == MovieListType.POPULAR){
            repository.getPopularMovieList(this);
        }else if(requestValues.currentOrder == MovieListType.TOP){
            repository.getTopMovieList(this);
        }else{
            useCaseCallback.onError("order cannot be null!");
            useCaseCallback.onFinish();
        }
    }

    @Override
    public void onStart() {
        useCaseCallback.onStart();
    }

    @Override
    public void onSuccess(MovieList list) {
        useCaseCallback.onSuccess(MovieListObj.convertToObj(list));
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
