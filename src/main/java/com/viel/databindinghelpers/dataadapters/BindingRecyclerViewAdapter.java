package com.viel.databindinghelpers.dataadapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
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

    protected List<T> items;
    protected List<T> filteredItems;

    public void setItems(List<T> items) {
        if (this.items == items) {
            return;
        }
        this.items = items;
        filteredItems = new LinkedList<>();
        filteredItems.addAll(items);
        notifyDataSetChanged();
    }

    protected T getItem(int position) {
        return items.get(position);
    }

    protected T getFilteredItem(int position) {
        return filteredItems.get(position);
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BindingViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        holder.bind(getBindingVariable(position), filteredItems.get(position));
        onBindViewBinding(holder.binding, position);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutId(position);
    }

    @Override
    public int getItemCount() {
        return filteredItems == null ? 0 : filteredItems.size();
    }

    static class BindingViewHolder extends RecyclerView.ViewHolder implements IBindingViewHolder {

        ViewDataBinding binding;

        public BindingViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        @Override
        public void bind(int varId, Object variable) {
            if (varId > 0) {
                binding.setVariable(varId, variable);
                binding.executePendingBindings();
            }
        }
    }
}
