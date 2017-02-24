package benhurqs.com.popularmovies.movie.data.managers;

import android.content.Context;
import android.support.annotation.NonNull;

import benhurqs.com.popularmovies.utils.ReaderMocks;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benhur.souza on 24/02/2017.
 */

public class MovieRepository {

    private static MovieRepository instance;
    private Context context;

    public static MovieRepository getInstance(Context context) {
        if (instance == null) {
            instance = new MovieRepository(context);
        }

        return instance;
    }

    public MovieRepository(@NonNull Context context) {
        this.context = checkNotNull(context);
    }

    public void findMovie(long id, final MovieCallback callback) {
        callback.onStart();
        callback.onSuccess(ReaderMocks.getMovie(context));
        callback.onFinish();
    }

}
