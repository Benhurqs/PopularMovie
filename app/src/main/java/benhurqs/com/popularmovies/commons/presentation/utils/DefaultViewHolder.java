package benhurqs.com.popularmovies.commons.presentation.utils;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Benhur on 23/04/17.
 */

public class DefaultViewHolder<H extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private final H binding;

    public DefaultViewHolder(H viewDataBinding) {
        super(viewDataBinding.getRoot());

        binding = viewDataBinding;
        binding.executePendingBindings();
    }

    public H getViewDataBinding() {
        return binding;
    }
}
