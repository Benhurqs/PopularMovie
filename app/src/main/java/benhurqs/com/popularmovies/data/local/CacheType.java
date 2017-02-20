package benhurqs.com.popularmovies.data.local;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by benhur.souza on 20/02/2017.
 */

public abstract class CacheType {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({MOVIE_LIST_TOP, MOVIE_LIST_POPULAR})

    public @interface Type {}
    public static final int MOVIE_LIST_TOP = 0;
    public static final int MOVIE_LIST_POPULAR = 1;

    public abstract void setCacheType(@Type int mode);
    @Type
    public abstract int getCacheType();
}
