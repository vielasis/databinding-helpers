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
import android.view.View;

import java.util.List;

public class SimpleBindingAdapter<T> {

    private BindingRecyclerViewAdapter<T> adapter;

    public BindingRecyclerViewAdapter<T> getAdapter() {
        return adapter;
    }

    public void setItems(List<T> items) {
        adapter.setItems(items);
    }

    public SimpleBindingAdapter(@LayoutRes int layoutId, @AnyRes int bindingVarId) {
        this(layoutId, bindingVarId, null, null);
    }

    public SimpleBindingAdapter(@LayoutRes int layoutId, @AnyRes int bindingVarId, List<T> items) {
        this(layoutId, bindingVarId, items, null);
    }

    public SimpleBindingAdapter(@LayoutRes int layoutId, @AnyRes int bindingVarId, ItemClickListener<T> itemClickListener) {
        this(layoutId, bindingVarId, null, itemClickListener);
    }

    public SimpleBindingAdapter(@LayoutRes int layoutId, @AnyRes int bindingVarId, List<T> items, final ItemClickListener<T> itemClickListener) {
        adapter = new BindingRecyclerViewAdapter<T>(layoutId, bindingVarId) {
            @Override
            public void onBindViewBinding(final BindingViewHolder holder, final int position) {
                if (itemClickListener != null) {
                    holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            itemClickListener.onItemClick(getItem(holder.getAdapterPosition()), holder.getAdapterPosition());
                        }
                    });
                } else {
                    holder.binding.getRoot().setOnClickListener(null);
                }
            }
        };
        adapter.setItems(items);
    }

    public interface ItemClickListener<T> {
        void onItemClick(T item, int position);
    }
}
