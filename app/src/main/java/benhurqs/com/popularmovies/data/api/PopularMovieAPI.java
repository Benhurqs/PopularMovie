package benhurqs.com.popularmovies.data.api;

import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Benhur on 19/02/17.
 */

public interface PopularMovieAPI {

    @GET("top_rated?api_key=af4510d7da9640eb8310f57fbf99ef4c")
    Observable<MovieList> getTopMovieList();

    @GET("popular?api_key=af4510d7da9640eb8310f57fbf99ef4c")
    Observable<MovieList> getPopularMovieList();
}
