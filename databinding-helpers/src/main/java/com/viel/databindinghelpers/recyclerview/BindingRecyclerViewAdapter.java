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

package com.viel.databindinghelpers.recyclerview;

import android.support.annotation.AnyRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BindingRecyclerViewAdapter<T> extends RecyclerView.Adapter<BindingViewHolder> implements IBindingAdapter {

    protected List<T> items;
    private ItemView itemView;

    public BindingRecyclerViewAdapter() {

    }

    public BindingRecyclerViewAdapter(ItemView itemView) {
        this.itemView = itemView;
    }

    public BindingRecyclerViewAdapter(@LayoutRes int layoutId, @AnyRes int bindingVarId) {
        this.itemView = new SimpleItemView(layoutId, bindingVarId);
    }

    @Override
    public void setItemView(ItemView itemView) {
        this.itemView = itemView;
    }

    @Override
    public ItemView getItemView() {
        return itemView;
    }

    public void setItems(List<T> items) {
        if (items == null || this.items == items) {
            return;
        }
        this.items = new ArrayList<>(items.size());
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    protected T getItem(int position) {
        return items.get(position);
    }

    @Override
    public final BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BindingViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
    }

    @Override
    public final void onBindViewHolder(BindingViewHolder holder, int position) {
        if (itemView instanceof AbsSimpleItemView) {
            holder.bind(((AbsSimpleItemView) itemView).getBindingVarId(holder.getAdapterPosition()), items.get(holder.getAdapterPosition()));
        } else {
            int[] varIds = itemView.getBindingVarIds(position);
            Object arg = items.get(holder.getAdapterPosition());
            if (varIds.length == 1) {
                holder.bind(varIds[0], arg);
            } else {
                List args = ((List) arg);
                for (int i = 0; i < varIds.length; i++) {
                    holder.bind(varIds[i], args == null || i >= args.size() ? null : args.get(i));
                }
            }
        }
        onBindViewBinding(holder, position);
    }

    @Override
    public final int getItemViewType(int position) {
        return itemView.getLayoutId(position);
    }

    @Override
    public final int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
