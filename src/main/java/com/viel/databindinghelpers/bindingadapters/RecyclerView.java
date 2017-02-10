package com.viel.databindinghelpers.bindingadapters;

import android.databinding.BindingAdapter;

import com.viel.databindinghelpers.factories.LayoutManagers;

/**
 * Created by viel on 10/02/2017.
 */

public class RecyclerView {

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(android.support.v7.widget.RecyclerView rv, LayoutManagers.Factory factory) {
        rv.setLayoutManager(factory.create(rv.getContext()));
    }

}
