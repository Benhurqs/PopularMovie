package benhurqs.com.popularmovies.movie.domain.entities;

import benhurqs.com.popularmovies.BuildConfig;
import benhurqs.com.popularmovies.commons.domain.entities.MovieDetail;
import benhurqs.com.popularmovies.commons.domain.usecases.UseCase;
import benhurqs.com.popularmovies.commons.utils.Utils;

/**
 * Created by benhursouza on 28/03/17.
 */

public class MovieDetailObj implements UseCase.ResponseValue {

    public int id;
    public String image_url;
    public String title;
    public String year;
    public float vote_average;
    public String  vote_count;
    public String runtime;
    public String category;
    public String description;
    public String production;
    public String budget;

    public static MovieDetailObj convertToObj(MovieDetail movie){
        MovieDetailObj obj = new MovieDetailObj();
        obj.title = movie.original_title;
        obj.image_url = BuildConfig.BASE_IMAGE_URL.concat(movie.backdrop_path);
        obj.year = Utils.getYear(movie.release_date);
        obj.vote_average = movie.vote_average/2;
        obj.vote_count = String.valueOf(movie.vote_count).concat(" Votes");
        obj.runtime = Utils.convertTime(movie.runtime);
        obj.category = movie.genres();
        obj.description = movie.overview;
        obj.production = movie.production();
        obj.budget = Utils.formatNumber(movie.budget).replace("$","");

        return obj;
    }

    public String voteValue(){
        return String.valueOf(vote_average).replace(".",",");
    }


}
