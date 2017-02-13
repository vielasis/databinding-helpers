package com.viel.databindinghelpers.dataadapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by viel on 10/02/2017.
 */

public abstract class BindingRecyclerViewAdapter<T> extends RecyclerView.Adapter<BindingRecyclerViewAdapter.BindingViewHolder> implements IBindingAdapter {

    private List<T> items;

    public void setItems(List<T> items) {
        if (this.items == items) {
            return;
        }
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BindingViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        holder.binding.setVariable(getBindingVariable(), items.get(position));
        onBindViewBinding(holder.binding, position);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition();
    }

    public abstract int getBindingVariable();

    public abstract @IdRes int getLayoutIdForPosition();

    public abstract void onBindViewBinding(ViewDataBinding binding, int position);

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    static class BindingViewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding binding;

        public BindingViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            binding.executePendingBindings();
        }
    }


}
