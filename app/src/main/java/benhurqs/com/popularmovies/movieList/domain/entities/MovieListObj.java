package benhurqs.com.popularmovies.movieList.domain.entities;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import benhurqs.com.popularmovies.commons.domain.usecases.UseCase;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benhur.souza on 27/03/2017.
 */
public class MovieListObj implements UseCase.ResponseValue {
    public ArrayList<PlotMovieObj> movies;

    public MovieListObj(){
        movies = new ArrayList<>();
    }

    /**
     * Convert MovieList to MovieListObj
     * send to view only field used
     *
     * @param list
     * @return
     */
    public static MovieListObj convertToObj(@NonNull MovieList list){
        checkNotNull(list, "list cannot to be null");

        MovieListObj movieListObj = new MovieListObj();
        for(Movie movie : list.results){
            movieListObj.movies.add(PlotMovieObj.convertToObj(movie));
        }

        return movieListObj;
    }
}
