package benhurqs.com.popularmovies.movieList.data.managers;

import android.support.annotation.NonNull;
import android.util.Log;

import benhurqs.com.popularmovies.commons.data.local.CacheType;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by Benhur on 19/02/17.
 */
public class MovieListRepository {

    private MovieListDataSource remoteDataSource;
    private MovieListDataSource localDataSource;
    private boolean remoteTopCacheIsDirty = true;
    private boolean remotePopularCacheIsDirty = true;

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

    /**
     * Verify if exist local data, if yes get local data else call API
     * @param callback
     */
    public void getTopMovieList(final MovielListCallback callback) {
        if(remoteTopCacheIsDirty){
            getRemoteTopMovieList(callback);
        }else{
            getLocalTopMovieList(callback);
        }
    }

    private void getLocalTopMovieList(final MovielListCallback callback){
        localDataSource.getTopMovieList().asObservable()
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
                .observeOn(AndroidSchedulers.mainThread())
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

    private void saveLocalTopMovieList(MovieList movieList) {
        localDataSource.save(CacheType.MOVIE_LIST_TOP, movieList, new MovielListCallback() {
            @Override
            public void onStart() {
                Log.d("save top popular", " start ");
            }

            @Override
            public void onSuccess(MovieList list) {
                Log.d("save top popular", " success ");
                remoteTopCacheIsDirty = false;

            }

            @Override
            public void onError(String error) {
                Log.e("save top popular", " error - " + error);

            }

            @Override
            public void onFinish() {
                Log.d("save top popular", " finish ");

            }
        });
    }

    private void saveLocalPopularMovieList(MovieList movieList){
        localDataSource.save(CacheType.MOVIE_LIST_POPULAR, movieList, new MovielListCallback() {
            @Override
            public void onStart() {
                Log.d("save local popular", " start ");
            }

            @Override
            public void onSuccess(MovieList list) {
                Log.d("save local popular", " success ");
                remotePopularCacheIsDirty = false;

            }

            @Override
            public void onError(String error) {
                Log.e("save local popular", " error - " + error);

            }

            @Override
            public void onFinish() {
                Log.d("save local popular", " finish ");

            }
        });
    }

    /**
     * Verify if exist local data, if yes get local data else call API
     * @param callback
     */
    public void getPopularMovieList(final MovielListCallback callback) {
        if(remotePopularCacheIsDirty){
            getRemotePopularMovieList(callback);
        }else{
            getLocalPopularMovieList(callback);
        }
    }

    private void getLocalPopularMovieList(final MovielListCallback callback){
        localDataSource.getPopularMovieList().asObservable()
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


    private void getRemotePopularMovieList(final MovielListCallback callback){
        remoteDataSource.getPopularMovieList()
                .observeOn(AndroidSchedulers.mainThread())
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
                        saveLocalPopularMovieList(movieList);
                    }
                });
    }
}
