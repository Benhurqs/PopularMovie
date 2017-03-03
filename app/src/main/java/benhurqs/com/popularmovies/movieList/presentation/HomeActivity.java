package benhurqs.com.popularmovies.movieList.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import benhurqs.com.popularmovies.R;
import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import benhurqs.com.popularmovies.injection.Injection;
import benhurqs.com.popularmovies.movie.data.managers.MovieCallback;
import benhurqs.com.popularmovies.movie.data.managers.MovieRepository;
import benhurqs.com.popularmovies.movieList.data.managers.MovieListRepository;
import benhurqs.com.popularmovies.movieList.data.managers.MovielListCallback;

public class HomeActivity extends AppCompatActivity {

    private MovieListRepository repository;
    private MovieRepository movieRepository;
    private TextView txtName;

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
        repository = Injection.provideMovieListRepository(this);
        movieRepository = Injection.provideMovieRepository(this);

        txtName = (TextView)this.findViewById(R.id.txt_name);
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
                txtName.setText(list.results[0].title);
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
                Log.d("Success top", list.toString() );
                txtName.setText(list.results[0].title);
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

    public void onClickMovie(View v){
            movieRepository.findMovie(372058, new MovieCallback() {
                @Override
                public void onStart() {
                    Log.d("Movie"," Start ");
                }

                @Override
                public void onSuccess(Movie movie) {
                    Log.d("Movie"," Success " + movie.title);
                    txtName.setText(movie.title);
                }

                @Override
                public void onError(String error) {
                    Log.e("MovieError",error);
                }

                @Override
                public void onFinish() {
                    Log.d("Movie"," Finalizou ");
                }
            });
    }

}
