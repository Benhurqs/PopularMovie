package benhurqs.com.popularmovies.movieList.data;

import android.support.annotation.NonNull;

import benhurqs.com.popularmovies.data.local.CacheType;
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
    private boolean remoteCacheIsDirty = true;
    private boolean localCacheIsDirty = true;

    private static MovieListRepository instance;

    public static MovieListRepository getInstance(@NonNull MovieListDataSource remoteDataSource, @NonNull MovieListDataSource localDataSource){
        if(instance == null){
            instance = new MovieListRepository(remoteDataSource, localDataSource);
        }

        return instance;
    }

    public MovieListRepository(@NonNull MovieListDataSource remoteDataSource, @NonNull MovieListDataSource localDataSource) {
        this.remoteDataSource = checkNotNull(remoteDataSource);
        this.localDataSource = checkNotNull(localDataSource);
    }

    public void getTopMovieList(final MovielListCallback callback) {
        if(remoteCacheIsDirty){
            getRemoteTopMovieList(callback);
        }else{
            getLocalTopMovieList(callback);
        }
    }

    private void getLocalTopMovieList(final MovielListCallback callback){
        localDataSource.getTopMovieList().asObservable()
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


    private void getRemoteTopMovieList(final MovielListCallback callback){
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
                        saveLocalTopMovieList(movieList);
                    }
                });
    }

    private void saveLocalTopMovieList(MovieList movieList){
        localDataSource.save(CacheType.MOVIE_LIST_TOP, movieList).subscribe(new Observer<MovieList>() {
            @Override
            public void onCompleted() {
                remoteCacheIsDirty = false;
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MovieList movieList) {

            }
        });
    }


    public void getPopularMovieList(final MovielListCallback callback) {
        remoteDataSource.getPopularMovieList()
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
}
