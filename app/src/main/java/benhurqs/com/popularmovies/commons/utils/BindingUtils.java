package benhurqs.com.popularmovies.commons.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import benhurqs.com.popularmovies.R;

/**
 * Created by benhursouza on 02/04/17.
 */

public class BindingUtils {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .error(R.color.gray)
                .placeholder(R.color.gray)
                .into(view);
    }


}
