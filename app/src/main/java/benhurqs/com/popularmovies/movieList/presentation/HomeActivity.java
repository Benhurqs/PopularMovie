package benhurqs.com.popularmovies.movieList.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import benhurqs.com.popularmovies.R;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import benhurqs.com.popularmovies.injection.Injection;
import benhurqs.com.popularmovies.movieList.data.managers.MovieListRepository;
import benhurqs.com.popularmovies.movieList.data.managers.MovielListCallback;

public class HomeActivity extends AppCompatActivity {

    private MovieListRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    @Override
    protected void onStart() {
        super.onStart();

        init();
    }

    private void init() {
        repository = Injection.provideTasksRepository(this);
    }

    public void onClickSendPopular(View view) {
        repository.getPopularMovieList(new MovielListCallback() {

            @Override
            public void onStart() {
                Log.d("Start popular", " Começou ");
            }

            @Override
            public void onSuccess(MovieList list) {
                Log.d("Success popular", list.results[0].title + " - title");
            }

            @Override
            public void onError(String error) {
                Log.e("error popular", error);

            }

            @Override
            public void onFinish() {
                Log.d("Finish", " Finalizou ");
            }
        });
    }

    public void onClickSendTop(View view) {
        repository.getTopMovieList(new MovielListCallback() {

            @Override
            public void onStart() {
                Log.d("Start top", " Começou ");
            }

            @Override
            public void onSuccess(MovieList list) {
                Log.d("Success top", list.results[0].id + " - title");
            }

            @Override
            public void onError(String error) {
                Log.e("error top", error);

            }

            @Override
            public void onFinish() {
                Log.d("Finish", " Finalizou ");
            }
        });

//        PopularMovieAPIServices.getInstance()
//                .getMovie(372058)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Movie>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("Movie"," Finalizou ");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("Movie","Error - " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(Movie movie) {
//                        Log.d("Movie",movie.title);
//                    }
//                });
    }

}
