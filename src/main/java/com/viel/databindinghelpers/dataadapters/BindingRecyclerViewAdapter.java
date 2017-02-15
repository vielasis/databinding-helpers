package com.viel.databindinghelpers.dataadapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by viel on 10/02/2017.
 */

public abstract class BindingRecyclerViewAdapter<T> extends RecyclerView.Adapter<BindingRecyclerViewAdapter.BindingViewHolder> implements IBindingAdapter {

    private List<T> items;
    private List<T> filteredItems;

    public void setItems(List<T> items) {
        if (this.items == items) {
            return;
        }
        this.items = items;
        filteredItems = new LinkedList<>();
        filteredItems.addAll(items);
        notifyDataSetChanged();
    }

    public List<T> getItems() {
        return items;
    }

    protected List<T> getFilteredItems() {
        return filteredItems;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BindingViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        holder.bind(getBindingVariable(), filteredItems.get(position));
        onBindViewBinding(holder.binding, position);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public abstract int getBindingVariable();

    public abstract
    @LayoutRes
    int getLayoutIdForPosition(int position);

    public abstract void onBindViewBinding(ViewDataBinding binding, int position);

    @Override
    public int getItemCount() {
        return filteredItems == null ? 0 : filteredItems.size();
    }

    static class BindingViewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding binding;

        public BindingViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public void bind(int bindingVariable, Object variable) {
            binding.setVariable(bindingVariable, variable);
            binding.executePendingBindings();
        }
    }
}
