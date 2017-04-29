package benhurqs.com.popularmovies.movie.presentation.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import benhurqs.com.popularmovies.R;
import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.databinding.ActivityMovieBinding;
import benhurqs.com.popularmovies.movie.domain.entities.MovieDetailObj;
import benhurqs.com.popularmovies.movie.presentation.presenters.MoviePresenter;
import benhurqs.com.popularmovies.movie.presentation.ui.contract.MovieContract;

/**
 * Created by benhur.souza on 22/02/2017.
 */

public class MovieActivity extends AppCompatActivity implements MovieContract.View{

    public static String MOVIE_ID = "movie_id";

    private ActivityMovieBinding binding;
    private MovieContract.Presenter presenter;
    private long movieId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        presenter = new MoviePresenter(this);

        getMovieId();
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.onStart(movieId);
    }

    private void getMovieId(){
        Intent intent = getIntent();
        if(intent != null && intent.getExtras() != null){
            movieId = intent.getLongExtra(MOVIE_ID, -1);
        }
    }

    @Override
    public void showProgress() {
        binding.contentMovie.progressbarMovieLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.contentMovie.progressbarMovieLoading.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void loadMovie(MovieDetailObj movie) {
        Log.d("Sucesso", movie.title);
    }

    @Override
    public Context getContext() {
        return binding.getRoot().getContext();
    }
}
