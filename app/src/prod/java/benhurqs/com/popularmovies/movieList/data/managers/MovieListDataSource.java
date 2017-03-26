package benhurqs.com.popularmovies.movieList.data.managers;

import benhurqs.com.popularmovies.commons.data.clients.local.CacheType;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;
import rx.Observable;

/**
 * Created by Benhur on 19/02/17.
 */

public interface MovieListDataSource {
    Observable<MovieList> getTopMovieList();
    Observable<MovieList> getPopularMovieList();
    void save(@CacheType.Type final int type, MovieList movieList, MovielListCallback cal);
}
