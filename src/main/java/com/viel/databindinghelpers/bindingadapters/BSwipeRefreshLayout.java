package com.viel.databindinghelpers.bindingadapters;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by viel on 10/02/2017.
 */

public class BSwipeRefreshLayout {

    @BindingAdapter(value = {"colorScheme", "refreshListener"}, requireAll = false)
    public static void setColorSchemeColors(SwipeRefreshLayout view, int[] colors, SwipeRefreshLayout.OnRefreshListener listener) {
        view.setColorSchemeColors(colors);
        if (listener != null) {
            view.setOnRefreshListener(listener);
        }
    }

}
