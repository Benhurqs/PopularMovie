package benhurqs.com.popularmovies.commons.data.clients.api;

import benhurqs.com.popularmovies.BuildConfig;
import benhurqs.com.popularmovies.commons.domain.entities.MovieDetail;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Benhur on 19/02/17.
 */
public class PopularMovieAPIServices {

    private static PopularMovieAPIServices _instance;
    private PopularMovieAPI api;
    private Retrofit retrofit;


    public static PopularMovieAPIServices get_instance(){
        if(_instance == null){
            _instance = new PopularMovieAPIServices();
        }

        return new PopularMovieAPIServices();
    }


    public PopularMovieAPIServices() {
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.API_URL)
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
    public Observable<MovieDetail> getMovie(long movie_id){
        return api.getPopularMovie(movie_id ,BuildConfig.API_KEY);
    }

}
