package benhurqs.com.popularmovies.movieList.data.managers;

import android.util.Log;

/**
 * Created by Benhur on 19/02/17.
 */
public class MovieListRepository {


    private static MovieListRepository instance;

    public static MovieListRepository getInstance(){
        if(instance == null){
            instance = new MovieListRepository();
        }

        return instance;
    }

    public MovieListRepository() {

        Log.d("MOCK", " MOCK ------- ");
    }

    /**
     * Verify if exist local data, if yes get local data else call API
     * @param callback
     */
    public void getTopMovieList(final MovielListCallback callback) {
    }




    /**
     * Verify if exist local data, if yes get local data else call API
     * @param callback
     */
    public void getPopularMovieList(final MovielListCallback callback) {

    }


}
