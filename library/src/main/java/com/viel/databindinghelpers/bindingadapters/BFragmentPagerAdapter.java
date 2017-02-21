package com.viel.databindinghelpers.bindingadapters;

import android.databinding.BindingAdapter;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by viel on 14/02/2017.
 */

public class BFragmentPagerAdapter {

    @BindingAdapter(value = {"adapter", "pageLimit", "pageTransformer"}, requireAll = false)
    public static void setAdapter(ViewPager vp, FragmentPagerAdapter adapter, int pageLimit, ViewPager.PageTransformer pageTransformer) {
        vp.setAdapter(adapter);
        if (pageLimit > 0) {
            vp.setOffscreenPageLimit(pageLimit);
        }
        if (pageTransformer != null) {
            vp.setPageTransformer(false, pageTransformer);
        }
    }

}
