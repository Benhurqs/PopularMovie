package benhurqs.com.popularmovies.commons.data.api;

import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Benhur on 19/02/17.
 */

public interface PopularMovieAPI {

    @GET("movie/top_rated?")
    Observable<MovieList> getTopMovieList(@Query("api_key") String api_key);

    @GET("movie/popular?")
    Observable<MovieList> getPopularMovieList(@Query("api_key") String api_key);

    @GET("movie/{movie_id}?")
    Observable<Movie> getPopularMovie(@Path("movie_id") long movie_id, @Query("api_key") String api_key);
}
