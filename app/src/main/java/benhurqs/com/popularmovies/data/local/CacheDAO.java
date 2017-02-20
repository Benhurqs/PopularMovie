package benhurqs.com.popularmovies.data.local;

import io.realm.Realm;

/**
 * Created by benhur.souza on 20/02/2017.
 */

public class CacheDAO {

    private Realm realm;
    private static CacheDAO instance;

    private static CacheDAO getInstance(){
        if(instance == null){
            instance = new CacheDAO();
        }

        return instance;
    }

    public CacheDAO(){
        realm = Realm.getDefaultInstance();
    }

    /**
     * Save cache object
     * @param type
     * @param json
     */
    public void saveCache(final int type, final String json){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                //check if already exist
                Cache cache = findCacheByType(bgRealm, type);
                if(cache == null){
                    //Save new
                    cache = bgRealm.createObject(Cache.class);
                }

                //Update json
                cache.json = json;
                cache.type = type;
//                cache.date = cache
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {

            }
        });

    }

    /**
     * Find Cache object by Type
     * @param type
     * @return
     */
    public Cache findCacheByType(int type){
        return findCacheByType(realm, type);
    }

    private Cache findCacheByType(Realm realm, int type){
        return realm.where(Cache.class)
                .equalTo("type", type)
                .findFirst();
    }


}
