package benhurqs.com.popularmovies.movieList.domain.repositories;

import android.content.Context;

import benhurqs.com.popularmovies.movieList.data.managers.MovielListCallback;
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
    }

    public void getTopMovieList(final MovielListCallback callback) {
        callback.onStart();
        callback.onSuccess(ReaderMocks.getTopMovieList(context));
        callback.onFinish();
    }

    public void getPopularMovieList(final MovielListCallback callback) {
        callback.onStart();
        callback.onSuccess(ReaderMocks.getPopularMovieList(context));
        callback.onFinish();

    }


}
