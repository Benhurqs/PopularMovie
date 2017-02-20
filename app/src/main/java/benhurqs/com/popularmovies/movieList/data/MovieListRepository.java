package benhurqs.com.popularmovies.movieList.data;

import android.support.annotation.NonNull;

import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;
import rx.Observer;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by Benhur on 19/02/17.
 */

public class MovieListRepository {

    private MovieListDataSource remoteDataSource;
    private MovieListDataSource localDataSource;

    public MovieListRepository(@NonNull MovieListDataSource remoteDataSource,@NonNull MovieListDataSource localDataSource) {
        this.remoteDataSource = checkNotNull(remoteDataSource);
        this.localDataSource = checkNotNull(localDataSource);
    }

    public void getTopMovieList(final MovielListCallback callback) {
        remoteDataSource.getTopMovieList()
                .asObservable()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        callback.onStart();
                    }
                })
                .subscribe(new Observer<MovieList>() {
                    @Override
                    public void onCompleted() {
                        callback.onFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieList movieList) {
                        callback.onSuccess(movieList);
                    }
                });
    }


    public void getPopularMovieList() {
    }
}
