package benhurqs.com.popularmovies.movie.data.clients.api;

import android.support.test.annotation.UiThreadTest;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import benhurqs.com.popularmovies.movieList.data.clients.api.MovieListAPIDataSource;
import rx.Observer;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

/**
 * Created by benhur.souza on 03/03/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MovieAPIDataSourceTest {
    //gradlew connectedProdDebugAndroidTest --stacktrace run this test

    private MovieAPIDataSource mMovieAPIDataSource;

    @Before
    public void setup() {
        mMovieAPIDataSource = MovieAPIDataSource.getInstance();
    }

    @Test
    public void testPreConditions() {
        // check if MovieListLocalDataSource is not null
        assertNotNull(mMovieAPIDataSource);
    }

    @Test
    public void callMovieAPI() {
        mMovieAPIDataSource.getMovie(372058)
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        fail("Movie - " + e.getMessage());
                    }

                    @Override
                    public void onNext(Movie movie) {
                        assertNotNull(movie);
                    }
                });
    }

}
