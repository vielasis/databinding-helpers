package com.viel.databindinghelpers.dataadapters;

import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;

/**
 * Created by viel on 13/02/2017.
 */

public interface IBindingAdapter {

    int getBindingVariable(int position);

    @LayoutRes
    int getLayoutId(int position);

    void onBindViewBinding(ViewDataBinding binding, int position);

}