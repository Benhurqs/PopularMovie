package benhurqs.com.popularmovies.movie.data.clients.api;

import benhurqs.com.popularmovies.commons.data.clients.api.PopularMovieAPIServices;
import benhurqs.com.popularmovies.commons.domain.entities.MovieDetail;
import benhurqs.com.popularmovies.movie.data.managers.MovieCallback;
import benhurqs.com.popularmovies.movie.data.managers.MovieDataSource;
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

    public MovieAPIDataSource(){
        api = PopularMovieAPIServices.get_instance();
    }

    @Override
    public Observable<MovieDetail> getMovie(long id) {
        return api.getMovie(id);
    }

    @Override
    public void save(MovieDetail movie, MovieCallback callback) {

    }
}
