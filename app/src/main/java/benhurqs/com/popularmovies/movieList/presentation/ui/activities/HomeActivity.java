package benhurqs.com.popularmovies.movieList.presentation.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import benhurqs.com.popularmovies.R;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieListObj;
import benhurqs.com.popularmovies.movieList.domain.usecases.MovieListType;
import benhurqs.com.popularmovies.movieList.presentation.presenters.MovieListPresenter;
import benhurqs.com.popularmovies.movieList.presentation.ui.views.MovieListContract;

public class HomeActivity extends AppCompatActivity implements MovieListContract.View {

//    private ViewMovieDetailUseCase detailUseCase;
    private MovieListPresenter presenter;
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
        txtName.setText(list.movies.get(0).title);

    }

    private void init() {
        presenter = new MovieListPresenter(this);
        txtName = (TextView)this.findViewById(R.id.txt_name);
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
