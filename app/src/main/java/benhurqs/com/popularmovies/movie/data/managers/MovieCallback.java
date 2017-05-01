package benhurqs.com.popularmovies.movie.data.managers;

import benhurqs.com.popularmovies.commons.domain.entities.MovieDetail;

/**
 * Created by benhur.souza on 22/02/2017.
 */

public interface MovieCallback {
    void onStart();
    void onSuccess(MovieDetail movie);
    void onError(String error);
    void onFinish();
}
