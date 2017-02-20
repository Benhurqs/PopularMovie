package benhurqs.com.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import benhurqs.com.popularmovies.movieList.data.MovieListRepository;
import benhurqs.com.popularmovies.movieList.data.MovielListCallback;
import benhurqs.com.popularmovies.movieList.data.api.MovieListAPIDataSource;
import benhurqs.com.popularmovies.movieList.data.local.MovieListLocalDataSource;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;

public class HomeActivity extends AppCompatActivity {

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

    private void init(){
        MovieListRepository m = new MovieListRepository(MovieListAPIDataSource.getInstance(), new MovieListLocalDataSource());
        m.getTopMovieList(new MovielListCallback() {

            @Override
            public void onStart() {
                Log.d("Start", " Começou ");
            }

            @Override
            public void onSuccess(MovieList list) {
                Log.d("Success", list.results.length + " - tamanho");
            }

            @Override
            public void onError(String error) {
                Log.e("error", error);

            }

            @Override
            public void onFinish() {
                Log.d("Finish", " Finalizou ");
            }
        });
    }
}
