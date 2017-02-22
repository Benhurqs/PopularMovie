package benhurqs.com.popularmovies.movie.data.clients.api;

import benhurqs.com.popularmovies.data.api.PopularMovieAPIServices;
import benhurqs.com.popularmovies.movie.data.managers.MovieCallback;
import benhurqs.com.popularmovies.movie.data.managers.MovieDataSource;
import benhurqs.com.popularmovies.movieList.domain.entities.Movie;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;
import rx.Observable;

/**
 * Created by benhur.souza on 22/02/2017.
 */

public class MovieAPIDataSource implements MovieDataSource {

    private static MovieAPIDataSource instance;
    public PopularMovieAPIServices api;

    public static MovieAPIDataSource getInstance(){
        if(instance == null){
            instance = new MovieAPIDataSource();
        }

        return instance;
    }

    @Override
    public Observable<Movie> getMovie(long id) {
        return api.getMovie(id);
    }

    @Override
    public void save(Movie movie, MovieCallback callback) {

    }
}
