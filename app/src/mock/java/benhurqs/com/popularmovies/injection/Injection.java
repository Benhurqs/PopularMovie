package benhurqs.com.popularmovies.injection;

import android.content.Context;
import android.support.annotation.NonNull;

import benhurqs.com.popularmovies.movie.data.managers.MovieRepository;
import benhurqs.com.popularmovies.movieList.data.managers.MovieListRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benhur.souza on 23/02/2017.
 */

public class Injection {

    public static MovieListRepository provideMovieListRepository(@NonNull Context context) {
        return MovieListRepository.getInstance(context);
    }

    public static MovieRepository provideMovieRepository(@NonNull Context context) {
        checkNotNull(context);
        return MovieRepository.getInstance(context);
    }
}
