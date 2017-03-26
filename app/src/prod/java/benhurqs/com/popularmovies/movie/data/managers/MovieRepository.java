package benhurqs.com.popularmovies.movie.data.managers;

import android.support.annotation.NonNull;
import android.util.Log;

import benhurqs.com.popularmovies.movieList.domain.entities.Movie;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by benhur.souza on 24/02/2017.
 */

public class MovieRepository {

    private static MovieRepository instance;
    private MovieDataSource localDataSource;
    private MovieDataSource remoteDataSource;

    public static MovieRepository getInstance(@NonNull MovieDataSource remoteDataSource, @NonNull MovieDataSource localDataSource){
        if(instance == null){
            instance = new MovieRepository(remoteDataSource, localDataSource);
        }

        return instance;
    }

    public MovieRepository(@NonNull MovieDataSource remoteDataSource, @NonNull MovieDataSource localDataSource){
        this.remoteDataSource = checkNotNull(remoteDataSource);
        this.localDataSource = checkNotNull(localDataSource);
    }

    /**
     * Find movie object, first looking for local, after that call api
     * and save/update movie object local
     *
     * @param id
     * @param callback
     */
    public void findMovie(long id, final MovieCallback callback){
        rx.Observable<Movie> local = localDataSource.getMovie(id)
                .onErrorResumeNext(new Func1<Throwable, rx.Observable<? extends Movie>>() {
                    @Override
                    public rx.Observable<? extends Movie> call(Throwable throwable) {
                        return rx.Observable.empty(); //here I just want to proceed the concat despite giving an error
                    }
                });

        rx.Observable<Movie> remote = remoteDataSource.getMovie(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

        rx.Observable.concat(local, remote)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        callback.onStart();
                    }
                })
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onCompleted() {
                        callback.onFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(Movie movie) {
                        callback.onSuccess(movie);
                        saveMovie(movie);
                    }
                });
    }

    /**
     * Save Movie object in data base local
     * @param movie
     */
    private void saveMovie(Movie movie){
        localDataSource.save(movie, new MovieCallback() {
            @Override
            public void onStart() {
                Log.d("Movie save", "start");
            }

            @Override
            public void onSuccess(Movie movie) {
                Log.d("Movie save ", " Success - " +  movie.title);

            }

            @Override
            public void onError(String error) {
                Log.e("Movie save", "start");

            }

            @Override
            public void onFinish() {
                Log.d("Movie save", "start");

            }
        });
    }
}
