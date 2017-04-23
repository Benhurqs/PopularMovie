package benhurqs.com.popularmovies.movieList.presentation.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import benhurqs.com.popularmovies.R;
import benhurqs.com.popularmovies.databinding.ItemMovieFeaturedBinding;
import benhurqs.com.popularmovies.movieList.domain.entities.PlotMovieObj;


/**
 * Created by benhursouza on 02/04/17.
 */

public class FeaturedFragment extends Fragment {

    private static String MOVIE = "movie";
    private ItemMovieFeaturedBinding binding;
    private PlotMovieObj movieObj;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FeaturedFragment newInstance(PlotMovieObj movie) {
        FeaturedFragment fragment = new FeaturedFragment();
        Bundle args = new Bundle();
        args.putSerializable(MOVIE, movie);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(container.getContext()), R.layout.item_movie_featured, container, false);

        if(getArguments() != null) {
            movieObj = (PlotMovieObj) getArguments().getSerializable(MOVIE);
            binding.setMovie(movieObj);
        }

        setRetainInstance(true);
        return binding.getRoot();
    }

}