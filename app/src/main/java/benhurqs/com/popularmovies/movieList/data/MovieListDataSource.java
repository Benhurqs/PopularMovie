package benhurqs.com.popularmovies.movieList.data;

import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;
import rx.Observable;

/**
 * Created by Benhur on 19/02/17.
 */

public interface MovieListDataSource {
    Observable<MovieList> getTopMovieList();
    Observable<MovieList> getPopularMovieList();
}
