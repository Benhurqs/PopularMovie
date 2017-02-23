package benhurqs.com.popularmovies.injection;

import benhurqs.com.popularmovies.movieList.data.managers.MovieListRepository;

/**
 * Created by benhur.souza on 23/02/2017.
 */

public class Injection {

    public static MovieListRepository provideTasksRepository() {
        return MovieListRepository.getInstance();
    }
}
