package benhurqs.com.popularmovies.movieList.presentation.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.Collections;

import benhurqs.com.popularmovies.movieList.data.managers.OnClickMovieCallback;
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
    private OnClickMovieCallback listener;

    public FeaturedAdapter(FragmentManager fm, ArrayList<PlotMovieObj> list, OnClickMovieCallback listener) {
        super(fm);
        this.mMovieList = new ArrayList<>(list);
        this.listener = listener;

        Collections.sort(mMovieList);
    }

    @Override
    public Fragment getItem(int position) {
        FeaturedFragment fragment = FeaturedFragment.newInstance(mMovieList.get(position));
        fragment.setCallback(listener);
        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
