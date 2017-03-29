package benhurqs.com.popularmovies.movieList.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import benhurqs.com.popularmovies.R;
import benhurqs.com.popularmovies.commons.domain.usecases.UseCase;
import benhurqs.com.popularmovies.commons.domain.usecases.UseCaseCallback;
import benhurqs.com.popularmovies.commons.domain.entities.Movie;
import benhurqs.com.popularmovies.commons.domain.entities.MovieList;
import benhurqs.com.popularmovies.injection.Injection;
import benhurqs.com.popularmovies.movie.data.managers.MovieCallback;
import benhurqs.com.popularmovies.movie.data.managers.MovieRepository;
import benhurqs.com.popularmovies.movie.domain.entities.MovieDetailObj;
import benhurqs.com.popularmovies.movie.domain.usecases.MovieRequestValue;
import benhurqs.com.popularmovies.movie.domain.usecases.ViewMovieDetailUseCase;
import benhurqs.com.popularmovies.movieList.domain.entities.MovieListObj;
import benhurqs.com.popularmovies.movieList.domain.usecases.MovieListType;
import benhurqs.com.popularmovies.movieList.domain.usecases.ViewMovieListUseCase;

public class HomeActivity extends AppCompatActivity {

    private ViewMovieListUseCase useCase;
    private ViewMovieDetailUseCase detailUseCase;
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
        detailUseCase = Injection.provideMovieDetailUseCase(this, new UseCaseCallback<MovieDetailObj>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(MovieDetailObj movie) {
                txtName.setText(movie.title);
            }

            @Override
            public void onError(String error) {

            }

            @Override
            public void onFinish() {

            }
        });

        useCase = Injection.provideMovieListUseCase(this, new UseCaseCallback<MovieListObj>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(MovieListObj response) {
                txtName.setText(response.movies.get(0).title);
            }

            @Override
            public void onError(String error) {

            }

            @Override
            public void onFinish() {

            }
        });

        txtName = (TextView)this.findViewById(R.id.txt_name);
    }

    public void onClickSendPopular(View view) {
        useCase.executeUseCase(MovieListType.setPopularOrder());
    }

    public void onClickSendTop(View view) {
        useCase.executeUseCase(MovieListType.setTopOrder());
    }

    public void onClickMovie(View v){
        detailUseCase.executeUseCase(MovieRequestValue.setMovieId(372058));
    }

}
