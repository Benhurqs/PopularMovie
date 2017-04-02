package benhurqs.com.popularmovies.movieList.presentation.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import benhurqs.com.popularmovies.movieList.domain.entities.PlotMovieObj;
import benhurqs.com.popularmovies.movieList.presentation.ui.fragment.FeaturedFragment;

/**
 * Created by benhursouza on 02/04/17.
 */

public class FeaturedAdapter extends FragmentStatePagerAdapter {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;
    private ArrayList<PlotMovieObj> mMovieList;

    public FeaturedAdapter(FragmentManager fm, ArrayList<PlotMovieObj> list) {
        super(fm);
        this.mMovieList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return FeaturedFragment.newInstance(mMovieList.get(position));
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
