package benhurqs.com.popularmovies.data.api;

import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Benhur on 19/02/17.
 */

public interface PopularMovieAPI {

    @GET("top_rated?")
    Observable<MovieList> getTopMovieList(@Query("api_key") String api_key);

    @GET("popular?")
    Observable<MovieList> getPopularMovieList(@Query("api_key") String api_key);
}
