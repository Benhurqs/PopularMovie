package benhurqs.com.popularmovies.commons.data.api;

import benhurqs.com.popularmovies.BuildConfig;
import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Benhur on 19/02/17.
 */

public class PopularMovieAPIServices {

    private Retrofit retrofit;
    private static PopularMovieAPIServices instance;
    private PopularMovieAPI api;

    public static PopularMovieAPIServices getInstance(){
        if(instance == null){
            instance = new PopularMovieAPIServices();
        }

        return instance;
    }


    public PopularMovieAPIServices() {
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.themoviedb.org/3/")
                .build();

        api = retrofit.create(PopularMovieAPI.class);
    }

    /**
     * Get Top movie list
     * @return
     */
    public Observable<MovieList> getTopMovieList(){
        return api.getTopMovieList(BuildConfig.API_KEY);
    }


    /**
     * Get popular movie list
     * @return
     */
    public Observable<MovieList> getPopularMovieList(){
        return api.getPopularMovieList(BuildConfig.API_KEY);
    }


    /**
     * Get movie
     * @return
     */
    public Observable<Movie> getMovie(long movie_id){
        return api.getPopularMovie(movie_id ,BuildConfig.API_KEY);
    }

}
