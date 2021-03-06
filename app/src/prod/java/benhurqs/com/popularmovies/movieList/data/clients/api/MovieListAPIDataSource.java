package benhurqs.com.popularmovies.movieList.data.clients.api;

import benhurqs.com.popularmovies.commons.data.clients.api.PopularMovieAPIServices;
import benhurqs.com.popularmovies.commons.data.clients.local.CacheType;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import benhurqs.com.popularmovies.movieList.data.managers.MovieListDataSource;
import benhurqs.com.popularmovies.movieList.data.managers.MovielListCallback;
import rx.Observable;

/**
 * Created by Benhur on 19/02/17.
 */

public class MovieListAPIDataSource implements MovieListDataSource {

    private static MovieListAPIDataSource instance;
    public PopularMovieAPIServices api;

    public static MovieListAPIDataSource getInstance(){
        if(instance == null){
            instance = new MovieListAPIDataSource();
        }

        return instance;
    }

    public MovieListAPIDataSource() {
        api = PopularMovieAPIServices.get_instance();
    }

    @Override
    public Observable<MovieList> getTopMovieList() {
        return api.getTopMovieList();
    }

    @Override
    public Observable<MovieList> getPopularMovieList() {
        return api.getPopularMovieList();
    }

    @Override
    public void save(@CacheType.Type int type, MovieList movieList, MovielListCallback callback) {

    }
}
