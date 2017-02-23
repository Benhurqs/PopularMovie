package benhurqs.com.popularmovies.injection;

import android.support.annotation.NonNull;

import benhurqs.com.popularmovies.movieList.data.clients.api.MovieListAPIDataSource;
import benhurqs.com.popularmovies.movieList.data.clients.local.MovieListLocalDataSource;
import benhurqs.com.popularmovies.movieList.data.managers.MovieListDataSource;
import benhurqs.com.popularmovies.movieList.data.managers.MovieListRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benhur.souza on 23/02/2017.
 */

public class Injection {

    public static MovieListRepository provideTasksRepository() {
        return MovieListRepository.getInstance(MovieListAPIDataSource.getInstance(), MovieListLocalDataSource.getInstance());
    }
}
