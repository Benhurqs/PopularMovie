package benhurqs.com.popularmovies.movieList.presentation.ui.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import benhurqs.com.popularmovies.R;
import benhurqs.com.popularmovies.commons.presentation.utils.DefaultViewHolder;
import benhurqs.com.popularmovies.databinding.ItemMovieBinding;
import benhurqs.com.popularmovies.movieList.domain.entities.PlotMovieObj;

/**
 * Created by Benhur on 23/04/17.
 */

public class MoviesListAdapter extends RecyclerView.Adapter<DefaultViewHolder<ItemMovieBinding>> {

    private ArrayList<PlotMovieObj> mMovieList;

    public MoviesListAdapter(ArrayList<PlotMovieObj> mMovieList) {
        this.mMovieList = mMovieList;
    }

    @Override
    public DefaultViewHolder<ItemMovieBinding> onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final ItemMovieBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_movie, viewGroup, false);
        return new DefaultViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DefaultViewHolder<ItemMovieBinding> holder, int position) {
        ItemMovieBinding binding = holder.getViewDataBinding();
        PlotMovieObj item = getItem(position);
        if (item != null) {
            binding.setMovie(item);
        }
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    private PlotMovieObj getItem(int position){
        return mMovieList.get(position);
    }
}
