package benhurqs.com.popularmovies.movieList.data.managers;

import android.content.Context;
import android.util.Log;

import benhurqs.com.popularmovies.utils.ReaderMocks;

/**
 * Created by Benhur on 19/02/17.
 */
public class MovieListRepository {


    private static MovieListRepository instance;
    private Context context;

    public static MovieListRepository getInstance(Context context){
        if(instance == null){
            instance = new MovieListRepository(context);
        }

        return instance;
    }

    public MovieListRepository(Context context) {
        this.context = context;
        Log.d("MOCK", " MOCK ------- ");
    }

    /**
     * Verify if exist local data, if yes get local data else call API
     * @param callback
     */
    public void getTopMovieList(final MovielListCallback callback) {
        callback.onStart();
        callback.onSuccess(ReaderMocks.getTopMovieList(context));
        callback.onFinish();
    }




    /**
     * Verify if exist local data, if yes get local data else call API
     * @param callback
     */
    public void getPopularMovieList(final MovielListCallback callback) {
        callback.onStart();
        callback.onSuccess(ReaderMocks.getPopularMovieList(context));
        callback.onFinish();

    }


}
