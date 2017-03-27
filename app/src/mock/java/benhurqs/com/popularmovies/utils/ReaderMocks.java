package benhurqs.com.popularmovies.utils;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.lang.reflect.Modifier;

import benhurqs.com.popularmovies.R;
import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;

/**
 * Created by benhur.souza on 23/02/2017.
 */

public class ReaderMocks {

    public static MovieList getTopMovieList(Context context){
        return convertToObject(R.raw.top_rate_list, MovieList.class, context);
    }

    public static MovieList getPopularMovieList(Context context){
        return convertToObject(R.raw.popular_list, MovieList.class, context);
    }

    public static Movie getMovie(Context context){
        return convertToObject(R.raw.movie, Movie.class, context);
    }

    public static <T> T convertToObject(int resourceId, Class<T> classFile, Context context){
        return new GsonBuilder().excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC).create().fromJson(getResourceAsString(context, resourceId), classFile);
    }

    public static String getResourceAsString(Context context, int resourceId){
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(resourceId);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);

            return new String(b);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
