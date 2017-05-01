package benhurqs.com.popularmovies.movieList.data.clients.local;

import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

/**
 * Created by benhur.souza on 03/03/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MovieListLocalDataSourceTest {
    //gradlew connectedProdDebugAndroidTest --stacktrace run this test

//    private MovieListLocalDataSource mMovieListLocalDataSource;
//
//    @Before
//    public void setup() {
//        mMovieListLocalDataSource = MovieListLocalDataSource.get_instance();
//        mMovieListLocalDataSource.clearAll();
//    }
//
//    @Test
//    public void testPreConditions() {
//        // check if MovieListLocalDataSource is not null
//        assertNotNull(mMovieListLocalDataSource);
//    }
//
//    @Test
//    @UiThreadTest
//    public void saveTopMovieListTest() {
//        final MovieList newMovieList = getMovieList();
//
//        // When saved into the persistent repository
//        mMovieListLocalDataSource.save(CacheType.MOVIE_LIST_TOP ,newMovieList, new MovielListCallback() {
//            @Override
//            public void onStart() {}
//
//            @Override
//            public void onSuccess(MovieList list) {}
//
//            @Override
//            public void onError(String error) {
//                fail(error);
//            }
//
//            @Override
//            public void onFinish() {
//                mMovieListLocalDataSource.getTopMovieList()
//                        .subscribe(new Observer<MovieList>() {
//                            @Override
//                            public void onCompleted() {
//
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                fail(e.getMessage());
//                            }
//
//                            @Override
//                            public void onNext(MovieList movieList) {
//                                assertNotNull(movieList);
//                                assertEquals(newMovieList.toString(),  movieList.toString());
//                            }
//                        });
//            }
//        });
//
//    }
//
//    @Test
//    @UiThreadTest
//    public void savePopularMovieListTest() {
//        final MovieList newMovieList = getMovieList();
//
//        // When saved into the persistent repository
//        mMovieListLocalDataSource.save(CacheType.MOVIE_LIST_POPULAR ,newMovieList, new MovielListCallback() {
//            @Override
//            public void onStart() {}
//
//            @Override
//            public void onSuccess(MovieList list) {
//
//            }
//
//            @Override
//            public void onError(String error) {
//                fail(error);
//            }
//
//            @Override
//            public void onFinish() {
//                mMovieListLocalDataSource.getPopularMovieList()
//                        .subscribe(new Observer<MovieList>() {
//                            @Override
//                            public void onCompleted() {
//
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                fail(e.getMessage());
//                            }
//
//                            @Override
//                            public void onNext(MovieList movieList) {
//                                assertNotNull(movieList);
//                                assertEquals(newMovieList.toString(),  movieList.toString());
//                            }
//                        });
//            }
//        });
//
//    }
//
//    @NonNull
//    private MovieList getMovieList() {
//        final Movie mMovie = new Movie();
//        mMovie.title = "MOVIE TITLE";
//        mMovie.id = 10;
//
//        final MovieList newMovieList = new MovieList();
//        newMovieList.page = 10;
//        newMovieList.total_pages = 20;
//        newMovieList.results = new Movie[]{mMovie};
//        newMovieList.total_results = 10;
//        return newMovieList;
//    }
}
