package benhurqs.com.popularmovies.commons.data.local;

import io.realm.RealmObject;

/**
 * Created by benhur.souza on 20/02/2017.
 */

public class Cache extends RealmObject {
    public String json;
    public int type;
    public String date;
}
