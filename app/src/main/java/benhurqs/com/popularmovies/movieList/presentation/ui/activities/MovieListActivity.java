package benhurqs.com.popularmovies.movieList.presentation.ui.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import benhurqs.com.popularmovies.R;
import benhurqs.com.popularmovies.databinding.ActivityMovielistBinding;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieListObj;
import benhurqs.com.popularmovies.movieList.domain.usecases.MovieListType;
import benhurqs.com.popularmovies.movieList.presentation.presenters.MovieListPresenter;
import benhurqs.com.popularmovies.movieList.presentation.ui.adapters.FeaturedAdapter;
import benhurqs.com.popularmovies.movieList.presentation.ui.adapters.MoviesListAdapter;
import benhurqs.com.popularmovies.movieList.presentation.ui.views.MovieListContract;

public class MovieListActivity extends AppCompatActivity implements MovieListContract.View {

    private MovieListPresenter presenter;
    private FeaturedAdapter featuredAdapter;
    private ActivityMovielistBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movielist);

    }

    @Override
    protected void onStart() {
        super.onStart();

        init();
    }


    @Override
    public void showProgress() {
        binding.contentMovielist.progressbarMovielist.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        binding.contentMovielist.progressbarMovielist.setVisibility(View.GONE);

    }

    @Override
    public void showError(String error) {
        Snackbar.make(binding.getRoot(), error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void loadMovieList(MovieListObj movieListObj) {
        binding.contentMovielist.contentListMovies.recyclerViewMovielistList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.contentMovielist.contentListMovies.recyclerViewMovielistList.setAdapter(new MoviesListAdapter(movieListObj.movies));


        featuredAdapter = new FeaturedAdapter(getSupportFragmentManager(), movieListObj.movies);
        binding.contentMovielist.viewpagerMovielistFeatured.setAdapter(featuredAdapter);
        binding.contentMovielist.indicatorMovelist.setViewPager(binding.contentMovielist.viewpagerMovielistFeatured);

    }

    private void init() {
        presenter = new MovieListPresenter(this);
        presenter.onStart();
    }

    public void onClickSendPopular(View view) {
        presenter.sort(MovieListType.POPULAR);
    }

    public void onClickSendTop(View view) {
        presenter.sort(MovieListType.TOP);
    }

    public void onClickMovie(View v){
        presenter.clickMovie(372058);
//        detailUseCase.executeUseCase(MovieRequestValue.setMovieId(372058));
    }

    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }
}
