package benhurqs.com.popularmovies.movieList.data.local;

import benhurqs.com.popularmovies.movieList.data.MovieListDataSource;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;
import rx.Observable;

/**
 * Created by Benhur on 19/02/17.
 */

public class MovieListLocalDataSource implements MovieListDataSource {

    @Override
    public Observable<MovieList> getTopMovieList() {
        return null;
    }

    @Override
    public Observable<MovieList> getPopularMovieList() {
        return null;
    }
}
