package benhurqs.com.popularmovies.movieList.data.api;

import benhurqs.com.popularmovies.data.api.PopularMovieAPIServices;
import benhurqs.com.popularmovies.data.local.CacheType;
import benhurqs.com.popularmovies.movieList.data.MovieListDataSource;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;
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
        api = PopularMovieAPIServices.getInstance();
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
    public Observable<MovieList> save(@CacheType.Type int type, MovieList movieList) {
        return null;
    }
}
