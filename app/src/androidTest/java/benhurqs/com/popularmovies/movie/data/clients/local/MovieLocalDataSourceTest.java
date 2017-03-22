package benhurqs.com.popularmovies.movie.data.clients.local;

import android.support.test.annotation.UiThreadTest;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.movie.data.managers.MovieCallback;
import rx.Observer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

/**
 * Created by benhur.souza on 24/02/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MovieLocalDataSourceTest {
    //gradlew connectedProdDebugAndroidTest --stacktrace run this test

    private static final String MOVIE_TITLE = "movie_title";
    private static final long MOVIE_ID = 123;

    private MovieLocalDataSource mLocalDataSource;

    @Before
    public void setup() {
        mLocalDataSource = MovieLocalDataSource.getInstance();
    }

    @Test
    public void testPreConditions() {
        // check if mLocalDataSource is not null
        assertNotNull(mLocalDataSource);
    }

    @Test
    @UiThreadTest
    public void saveMovie_retrievesMovie() {
        // Given a new task
        final Movie newMovie = new Movie();
        newMovie.id = MOVIE_ID;
        newMovie.title = MOVIE_TITLE;

        // When saved into the persistent repository
        mLocalDataSource.save(newMovie, new MovieCallback() {
            @Override
            public void onStart() {}

            @Override
            public void onSuccess(Movie movie) {

            }

            @Override
            public void onError(String error) {
                fail(error);
            }

            @Override
            public void onFinish() {
                mLocalDataSource.getMovie(MOVIE_ID)
                        .subscribe(new Observer<Movie>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                fail(e.getMessage());
                            }

                            @Override
                            public void onNext(Movie movie) {
                                assertEquals(newMovie.toString(),  movie.toString());
                            }
                        });
            }
        });

    }
}
