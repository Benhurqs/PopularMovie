package benhurqs.com.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import benhurqs.com.popularmovies.movieList.data.MovieListRepository;
import benhurqs.com.popularmovies.movieList.data.MovielListCallback;
import benhurqs.com.popularmovies.movieList.data.api.MovieListAPIDataSource;
import benhurqs.com.popularmovies.movieList.data.local.MovieListLocalDataSource;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieList;

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

    private void init(){
        repository = MovieListRepository.getInstance(MovieListAPIDataSource.getInstance(), new MovieListLocalDataSource());
    }

    public void onClickSendPopular(View view){
        repository.getPopularMovieList(new MovielListCallback() {

            @Override
            public void onStart() {
                Log.d("Start popular", " Começou ");
            }

            @Override
            public void onSuccess(MovieList list) {
                Log.d("Success popular", list.results.length + " - tamanho");
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

    public void onClickSendTop(View view){
        repository.getTopMovieList(new MovielListCallback() {

            @Override
            public void onStart() {
                Log.d("Start top", " Começou ");
            }

            @Override
            public void onSuccess(MovieList list) {
                Log.d("Success top", list.results.length + " - tamanho");
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
    }
}
