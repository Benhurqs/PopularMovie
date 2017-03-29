package benhurqs.com.popularmovies.movieList.presentation.ui.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import benhurqs.com.popularmovies.R;
import benhurqs.com.popularmovies.databinding.ActivityMovielistBinding;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieListObj;
import benhurqs.com.popularmovies.movieList.domain.usecases.MovieListType;
import benhurqs.com.popularmovies.movieList.presentation.presenters.MovieListPresenter;
import benhurqs.com.popularmovies.movieList.presentation.ui.views.MovieListContract;

public class MovieListActivity extends AppCompatActivity implements MovieListContract.View {

//    private ViewMovieDetailUseCase detailUseCase;
    private MovieListPresenter presenter;
    private ActivityMovielistBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movielist);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.onStart();
    }


    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void loadMovieList(MovieListObj list) {

    }

    private void init() {
        presenter = new MovieListPresenter(this);
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
