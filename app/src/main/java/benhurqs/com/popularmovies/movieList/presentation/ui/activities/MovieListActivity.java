package benhurqs.com.popularmovies.movieList.presentation.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import benhurqs.com.popularmovies.R;
import benhurqs.com.popularmovies.databinding.ActivityMovielistBinding;
import benhurqs.com.popularmovies.movie.presentation.ui.activities.MovieActivity;
import benhurqs.com.popularmovies.movieList.data.managers.OnClickMovieCallback;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieListObj;
import benhurqs.com.popularmovies.movieList.domain.usecases.MovieListType;
import benhurqs.com.popularmovies.movieList.presentation.presenters.MovieListPresenter;
import benhurqs.com.popularmovies.movieList.presentation.ui.adapters.FeaturedAdapter;
import benhurqs.com.popularmovies.movieList.presentation.ui.adapters.MoviesListAdapter;
import benhurqs.com.popularmovies.movieList.presentation.ui.contract.MovieListContract;

public class MovieListActivity extends AppCompatActivity implements MovieListContract.View, OnClickMovieCallback {

    private MovieListPresenter presenter;
    private FeaturedAdapter featuredAdapter;
    private ActivityMovielistBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movielist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        init();

    }


    @Override
    public void changeTitle(String title) {
        getSupportActionBar().setTitle(title);
        binding.contentMovielist.contentListMovies.textviewMovielistListTitle.setText(title);
    }

    @Override
    public void showProgress() {
        binding.contentMovielist.progressbarMovielist.setVisibility(View.VISIBLE);
        binding.contentMovielist.layoutMovielist.setVisibility(View.GONE);

    }

    @Override
    public void hideProgress() {
        binding.contentMovielist.progressbarMovielist.setVisibility(View.GONE);
        binding.contentMovielist.layoutMovielist.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError(String error) {
        Snackbar.make(binding.getRoot(), error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void loadMovieList(MovieListObj movieListObj) {
        binding.contentMovielist.contentListMovies.recyclerViewMovielistList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.contentMovielist.contentListMovies.recyclerViewMovielistList.setAdapter(new MoviesListAdapter(movieListObj.movies, this));


        featuredAdapter = new FeaturedAdapter(getSupportFragmentManager(), movieListObj.movies, this);
        binding.contentMovielist.viewpagerMovielistFeatured.setAdapter(featuredAdapter);
        binding.contentMovielist.indicatorMovelist.setViewPager(binding.contentMovielist.viewpagerMovielistFeatured);

    }

    private void init() {
        presenter = new MovieListPresenter(this);
        presenter.onStart();
    }

    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.movie_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_movielist_top:
                presenter.sort(MovieListType.TOP);
                return true;
            case R.id.action_movielist_popular:
                presenter.sort(MovieListType.POPULAR);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClickItem(long movieId) {
        Intent movieActivity = new Intent(this, MovieActivity.class);
        movieActivity.putExtra(MovieActivity.MOVIE_ID, movieId);
        startActivity(movieActivity);
    }

}
