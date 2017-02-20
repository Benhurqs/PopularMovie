package benhurqs.com.popularmovies.data.api;

import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;
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
                .baseUrl("http://api.themoviedb.org/3/movie/")
                .build();

        api = retrofit.create(PopularMovieAPI.class);
    }

    /**
     * Get Top movie list
     * @return
     */
    public Observable<MovieList> getTopMovieList(){
        return api.getTopMovieList();
    }


    /**
     * Get popular movie list
     * @return
     */
    public Observable<MovieList> getPopularMovieList(){
        return api.getPopularMovieList();
    }
}
