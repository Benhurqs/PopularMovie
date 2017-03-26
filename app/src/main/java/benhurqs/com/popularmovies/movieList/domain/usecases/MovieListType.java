package benhurqs.com.popularmovies.movieList.domain.usecases;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import benhurqs.com.popularmovies.commons.domain.usecases.UseCase;

/**
 * Created by benhursouza on 26/03/17.
 */

public class MovieListType implements UseCase.RequestValues {

    public static final int TOP = 0;
    public static final int POPULAR = 1;

    @IntDef({TOP, POPULAR})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Order {}

    @Order int currentOrder = TOP;

    public MovieListType(@Order int currentOrder) {
        this.currentOrder = currentOrder;
    }
}
