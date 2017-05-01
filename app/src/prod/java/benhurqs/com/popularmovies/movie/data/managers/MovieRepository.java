package benhurqs.com.popularmovies.movie.data.managers;

import android.support.annotation.NonNull;
import android.util.Log;

import benhurqs.com.popularmovies.commons.domain.entities.MovieDetail;
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
        rx.Observable<MovieDetail> local = localDataSource.getMovie(id)
                .onErrorResumeNext(new Func1<Throwable, rx.Observable<? extends MovieDetail>>() {
                    @Override
                    public rx.Observable<? extends MovieDetail> call(Throwable throwable) {
                        return rx.Observable.empty(); //here I just want to proceed the concat despite giving an error
                    }
                });

        rx.Observable<MovieDetail> remote = remoteDataSource.getMovie(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

        rx.Observable.concat(local, remote)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        callback.onStart();
                    }
                })
                .subscribe(new Observer<MovieDetail>() {
                    @Override
                    public void onCompleted() {
                        callback.onFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieDetail movie) {
                        callback.onSuccess(movie);
                        saveMovie(movie);
                    }
                });
    }

    /**
     * Save Movie object in data base local
     * @param movie
     */
    private void saveMovie(MovieDetail movie){
        localDataSource.save(movie, new MovieCallback() {
            @Override
            public void onStart() {
                Log.d("Movie save", "start");
            }

            @Override
            public void onSuccess(MovieDetail movie) {
                Log.d("Movie save ", " Success - " +  movie.original_title);

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
