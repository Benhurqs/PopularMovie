package benhurqs.com.popularmovies.data.local;

import com.google.gson.Gson;

import benhurqs.com.popularmovies.movie.data.managers.MovieCallback;
import benhurqs.com.popularmovies.movieList.data.managers.MovielListCallback;
import benhurqs.com.popularmovies.movieList.domain.entities.Movie;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;
import io.realm.Realm;

/**
 * Created by benhur.souza on 20/02/2017.
 */

public class CacheDAO {

    private Realm realm;
    private static CacheDAO instance;

    public static CacheDAO getInstance() {
        if (instance == null) {
            instance = new CacheDAO();
        }

        return instance;
    }

    public CacheDAO() {
        realm = Realm.getDefaultInstance();
    }

    /**
     * Save cache object
     *
     * @param type
     * @param movieList
     */
    public void saveCache(final int type, final MovieList movieList, final MovielListCallback callback) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                callback.onStart();
                //check if already exist
                Cache cache = findCacheByType(bgRealm, type);
                if (cache == null) {
                    //Save new
                    cache = bgRealm.createObject(Cache.class);
                }

                //Convert to json
                Gson gson = new Gson();
                String json = gson.toJson(movieList);

                //Update json
                cache.json = json;
                cache.type = type;

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                callback.onSuccess(movieList);
                callback.onFinish();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                callback.onError(error.getMessage());
            }
        });

    }


    /**
     * Save movie cache object
     *
     * @param movie
     */
    public void saveMovieCache( final Movie movie, final MovieCallback callback) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                callback.onStart();
                //check if already exist
                MovieCache cache = findMovieById(bgRealm, CacheType.MOVIE);
                if (cache == null) {
                    //Save new
                    cache = bgRealm.createObject(MovieCache.class);
                }

                //Convert to json
                Gson gson = new Gson();
                String json = gson.toJson(movie);

                //Update json
                cache.json = json;
                cache.id = movie.id;
                cache.type = CacheType.MOVIE;

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                callback.onSuccess(movie);
                callback.onFinish();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                callback.onError(error.getMessage());
            }
        });

    }

    public Cache findCacheByType(@CacheType.Type int type) {
        return findCacheByType(realm, type);
    }

    public MovieCache findMovieById(long id) {
        return findMovieById(realm, id);
    }

    /**
     * Find Movie Cache object by ID
     *
     * @param realm
     * @param id
     * @return
     */
    public MovieCache findMovieById(Realm realm, long id) {
        return realm.where(MovieCache.class)
                .equalTo("id", id)
                .findFirst();
    }


    /**
     * Find Cache object by Type
     *
     * @param realm
     * @param type
     * @return
     */
    private Cache findCacheByType(Realm realm, @CacheType.Type int type) {
        return realm.where(Cache.class)
                .equalTo("type", type)
                .findFirst();
    }


}
