package benhurqs.com.popularmovies.injection;

import android.content.Context;
import android.support.annotation.NonNull;

import benhurqs.com.popularmovies.commons.domain.usecases.UseCaseCallback;
import benhurqs.com.popularmovies.movie.data.managers.MovieRepository;
import benhurqs.com.popularmovies.movie.domain.usecases.ViewMovieDetailUseCase;
import benhurqs.com.popularmovies.movieList.domain.repositories.MovieListRepository;
import benhurqs.com.popularmovies.movieList.domain.usecases.ViewMovieListUseCase;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by benhur.souza on 23/02/2017.
 */

public class Injection {

    public static ViewMovieListUseCase provideMovieListUseCase(@NonNull Context context, @NonNull UseCaseCallback caseCallback) {
        checkNotNull(context);
        checkNotNull(caseCallback);

        return ViewMovieListUseCase.getInstance(
                Injection.provideMovieListRepository(context),
                caseCallback);
    }


    public static ViewMovieDetailUseCase provideMovieDetailUseCase(@NonNull Context context, @NonNull UseCaseCallback caseCallback) {
        checkNotNull(context);
        checkNotNull(caseCallback);

        return ViewMovieDetailUseCase.getInstance(
                Injection.provideMovieRepository(context),
                caseCallback);
    }

    public static MovieListRepository provideMovieListRepository(@NonNull Context context) {
        return MovieListRepository.getInstance(context);
    }

    public static MovieRepository provideMovieRepository(@NonNull Context context) {
        checkNotNull(context);
        return MovieRepository.getInstance(context);
    }
}
