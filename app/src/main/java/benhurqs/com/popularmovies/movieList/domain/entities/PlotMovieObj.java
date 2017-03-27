package benhurqs.com.popularmovies.movieList.domain.entities;

import android.support.annotation.NonNull;

import benhurqs.com.popularmovies.BuildConfig;
import benhurqs.com.popularmovies.commons.domain.entities.Movie;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benhur.souza on 27/03/2017.
 */
public class PlotMovieObj {
    public long id;
    public String image_url;
    public String title;


    /**
     * Convert Movie to PlotMovieObj
     * send to view only field used
     *
     * @param movie
     * @return
     */
    public static PlotMovieObj convertToObj(@NonNull Movie movie){
        checkNotNull(movie, "movie cannot to be null");

        PlotMovieObj obj = new PlotMovieObj();
        obj.id = movie.id;
        obj.title = movie.title;
        obj.image_url = BuildConfig.BASE_IMAGE_URL.concat(movie.poster_path);

        return obj;

    }
}
