/*
 * Copyright (C) 2017 Krystian Viel Asis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.viel.databindinghelpers.dataadapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

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

    public static class BindingViewHolder extends RecyclerView.ViewHolder implements IBindingViewHolder {

        public ViewDataBinding binding;

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
