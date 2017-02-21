package benhurqs.com.popularmovies;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by benhur.souza on 20/02/2017.
 */

public class PopularMovieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

    }


}
