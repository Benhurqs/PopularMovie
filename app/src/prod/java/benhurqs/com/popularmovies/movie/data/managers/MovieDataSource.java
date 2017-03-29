package benhurqs.com.popularmovies.movie.data.managers;

import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import rx.Observable;

/**
 * Created by benhur.souza on 22/02/2017.
 */

public interface MovieDataSource {
    Observable<Movie> getMovie(long id);
    void save(Movie movie, MovieCallback callback);
}
