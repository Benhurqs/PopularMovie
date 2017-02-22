package benhurqs.com.popularmovies.movie.data.managers;

import benhurqs.com.popularmovies.movieList.domain.entities.Movie;

/**
 * Created by benhur.souza on 22/02/2017.
 */

public interface MovieCallback {
    void onStart();
    void onSuccess(Movie list);
    void onError(String error);
    void onFinish();
}
