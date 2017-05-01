package benhurqs.com.popularmovies.movie.data.managers;

import benhurqs.com.popularmovies.commons.domain.entities.MovieDetail;
import rx.Observable;

/**
 * Created by benhur.souza on 22/02/2017.
 */

public interface MovieDataSource {
    Observable<MovieDetail> getMovie(long id);
    void save(MovieDetail movie, MovieCallback callback);
}
