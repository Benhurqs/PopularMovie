package benhurqs.com.popularmovies.movie.domain.usecases;

import benhurqs.com.popularmovies.commons.domain.usecases.UseCase;

/**
 * Created by benhursouza on 28/03/17.
 */

public class MovieRequestValue implements UseCase.RequestValues {
    public long movieId;

    public MovieRequestValue(long movieId) {
        this.movieId = movieId;
    }

    public static MovieRequestValue setMovieId(long id){
        return new MovieRequestValue(id);
    }
}
