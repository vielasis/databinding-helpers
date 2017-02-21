package com.viel.databindinghelpers.bindingconversions;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.view.View;

/**
 * Created by viel on 10/02/2017.
 */

public class Visibility {

    private Visibility() {
    }

    @BindingConversion
    public static int booleanToIntVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }

    @BindingAdapter("invisible")
    public static void setViewInvisible(View v, boolean visible) {
        v.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

}
