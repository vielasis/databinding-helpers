package com.viel.databindinghelpers.bindingadapters;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.viel.databindinghelpers.factories.LayoutManagers;

/**
 * Created by viel on 10/02/2017.
 */

public class BRecyclerView {

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView rv, LayoutManagers.Factory factory) {
        rv.setLayoutManager(factory.create(rv.getContext()));
    }

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView rv, RecyclerView.Adapter adapter) {
        rv.setAdapter(adapter);
    }

}
