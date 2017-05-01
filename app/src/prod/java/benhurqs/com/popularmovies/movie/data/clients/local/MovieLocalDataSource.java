package benhurqs.com.popularmovies.movie.data.clients.local;

import com.google.gson.Gson;

import benhurqs.com.popularmovies.commons.data.clients.local.CacheDAO;
import benhurqs.com.popularmovies.commons.data.clients.local.db.MovieCache;
import benhurqs.com.popularmovies.commons.domain.entities.MovieDetail;
import benhurqs.com.popularmovies.movie.data.managers.MovieCallback;
import benhurqs.com.popularmovies.movie.data.managers.MovieDataSource;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by benhur.souza on 22/02/2017.
 */

public class MovieLocalDataSource implements MovieDataSource {

    private static MovieLocalDataSource instance;
    public CacheDAO dao;

    public static MovieLocalDataSource getInstance() {
        if (instance == null) {
            instance = new MovieLocalDataSource();
        }

        return instance;
    }

    public MovieLocalDataSource() {
        dao = CacheDAO.getInstance();
    }


    @Override
    public Observable<MovieDetail> getMovie(final long id) {
        Observable.OnSubscribe<MovieDetail> subscribe = new Observable.OnSubscribe<MovieDetail>() {
            @Override
            public void call(Subscriber<? super MovieDetail> subscriber) {
                MovieCache cache = dao.findMovieById(id);
                if (cache == null) {
                    subscriber.onError(new Throwable("Not found"));
                    return;
                }

                Gson gson = new Gson();
                MovieDetail obj = gson.fromJson(cache.json, MovieDetail.class);
                if (obj == null) {
                    subscriber.onError(new Throwable("Erro ao fazer o parse"));
                    return;
                }

                subscriber.onNext(obj);
                subscriber.onCompleted();
            }
        };

        return Observable.create(subscribe);
    }

    @Override
    public void save(MovieDetail movie, MovieCallback callback) {
        dao.saveMovieCache(movie, callback);
    }


    public void clearAll(){
        dao.clearMovieTable();
    }
}
