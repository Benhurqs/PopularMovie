package benhurqs.com.popularmovies.movieList.data.managers;

import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;

/**
 * Created by Benhur on 19/02/17.
 */

public interface MovielListCallback {
    void onStart();
    void onSuccess(MovieList list);
    void onError(String error);
    void onFinish();
}
