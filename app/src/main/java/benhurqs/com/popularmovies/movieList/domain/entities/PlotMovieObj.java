package benhurqs.com.popularmovies.movieList.domain.entities;

import android.support.annotation.NonNull;

import java.io.Serializable;

import benhurqs.com.popularmovies.BuildConfig;
import benhurqs.com.popularmovies.commons.domain.entities.Movie;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benhur.souza on 27/03/2017.
 */
public class PlotMovieObj implements Serializable, Comparable<PlotMovieObj> {
    public long id;
    public String image_url;
    public String featured_image_url;
    public String title;
    public float vote_average;


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
        obj.featured_image_url = BuildConfig.BASE_IMAGE_URL.concat(movie.backdrop_path);
        obj.vote_average = movie.vote_average;

        return obj;

    }

    @Override
    public int compareTo(PlotMovieObj o) {
        return o.vote_average < vote_average ? -1
                : o.vote_average > vote_average ? 1
                : 0;
    }
}
