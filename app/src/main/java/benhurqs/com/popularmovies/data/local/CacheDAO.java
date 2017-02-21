package benhurqs.com.popularmovies.data.local;

import com.google.gson.Gson;

import benhurqs.com.popularmovies.movieList.data.MovielListCallback;
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


    public Cache findCacheByType(@CacheType.Type int type) {
        return findCacheByType(realm, type);
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
