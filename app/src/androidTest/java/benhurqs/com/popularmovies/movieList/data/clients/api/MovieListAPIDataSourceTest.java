package benhurqs.com.popularmovies.movieList.data.clients.api;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

/**
 * Created by benhur.souza on 03/03/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MovieListAPIDataSourceTest {
    //./gradlew assembleFlavorDebugAndroidTest run this test

//    private MovieListAPIDataSource mMovieListAPIDataSource;
//
//    @Before
//    public void setup() {
//        mMovieListAPIDataSource = MovieListAPIDataSource.get_instance();
//    }
//
//    @Test
//    public void testPreConditions() {
//        // check if MovieListLocalDataSource is not null
//        assertNotNull(mMovieListAPIDataSource);
//    }
//
//    @Test
//    public void callPopularMovieListAPI() {
//        mMovieListAPIDataSource.getPopularMovieList()
//                .subscribe(new Observer<MovieList>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        fail("PopularMovieList - " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(MovieList movieList) {
//                        assertNotNull(movieList);
//                    }
//                });
//    }
//
//    @Test
//    @UiThreadTest
//    public void callTopMovieListAPI() {
//        mMovieListAPIDataSource.getTopMovieList()
//                .subscribe(new Observer<MovieList>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                       fail("TopMovieList - " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(MovieList movieList) {
//                        assertNotNull(movieList);
//                    }
//                });
//    }
}
