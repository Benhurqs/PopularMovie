package benhurqs.com.popularmovies.movieList.data.clients.local;

import android.support.annotation.NonNull;

import com.google.gson.Gson;

import benhurqs.com.popularmovies.commons.data.clients.local.CacheDAO;
import benhurqs.com.popularmovies.commons.data.clients.local.CacheType;
import benhurqs.com.popularmovies.commons.data.clients.local.db.MovieListCache;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import benhurqs.com.popularmovies.movieList.data.managers.MovieListDataSource;
import benhurqs.com.popularmovies.movieList.data.managers.MovielListCallback;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Benhur on 19/02/17.
 */

public class MovieListLocalDataSource implements MovieListDataSource {

    private static MovieListLocalDataSource instance;
    public CacheDAO dao;

    public static MovieListLocalDataSource getInstance() {
        if (instance == null) {
            instance = new MovieListLocalDataSource();
        }

        return instance;
    }

    public MovieListLocalDataSource() {
        dao = CacheDAO.getInstance();
    }

    @Override
    public Observable<MovieList> getTopMovieList() {
        return getMovieListObservable(CacheType.MOVIE_LIST_TOP);
    }

    @Override
    public Observable<MovieList> getPopularMovieList() {
        return getMovieListObservable(CacheType.MOVIE_LIST_POPULAR);
    }

    @NonNull
    private Observable<MovieList> getMovieListObservable(@CacheType.Type final int type) {
        Observable.OnSubscribe<MovieList> subscribe = new Observable.OnSubscribe<MovieList>() {
            @Override
            public void call(Subscriber<? super MovieList> subscriber) {
                MovieListCache cache = dao.findCacheByType(type);
                if (cache == null) {
                    subscriber.onError(new Throwable("Not found"));
                    return;
                }

                Gson gson = new Gson();
                MovieList obj = gson.fromJson(cache.json, MovieList.class);
                if (obj == null) {
                    subscriber.onError(new Throwable("Erro ao fazer o parse"));
                    return;
                }

                subscriber.onNext(obj);
                subscriber.onCompleted();
            }
        };

        return Observable.create(subscribe);
    }

    @Override
    public void save(@CacheType.Type final int type, MovieList movieList, MovielListCallback callback){
        dao.saveCache(type, movieList, callback);
    }

    public void clearAll(){
        dao.clearMovieListTable();
    }


}
