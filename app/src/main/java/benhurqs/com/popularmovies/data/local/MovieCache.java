package benhurqs.com.popularmovies.data.local;

import io.realm.RealmObject;

/**
 * Created by benhur.souza on 22/02/2017.
 */

public class MovieCache extends RealmObject {
    public String json;
    public int type;
    public String date;
    public long id;
}
