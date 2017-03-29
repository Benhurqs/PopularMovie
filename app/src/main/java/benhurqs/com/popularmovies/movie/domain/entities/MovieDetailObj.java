package benhurqs.com.popularmovies.movie.domain.entities;

import benhurqs.com.popularmovies.BuildConfig;
import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.commons.domain.usecases.UseCase;

/**
 * Created by benhursouza on 28/03/17.
 */

public class MovieDetailObj implements UseCase.ResponseValue {

    public String image_url;
    public String title;

    public static MovieDetailObj convertToObj(Movie movie){
        MovieDetailObj obj = new MovieDetailObj();
        obj.title = movie.title;
        obj.image_url = BuildConfig.BASE_IMAGE_URL.concat(movie.poster_path);

        return obj;
    }
}
