package com.viel.databindinghelpers.factories;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by viel on 10/02/2017.
 */

public class LayoutManagers {

    private LayoutManagers() {
    }

    public interface Factory {
        RecyclerView.LayoutManager create(Context context);
    }

    public static Factory linear() {
        return new Factory() {
            @Override
            public RecyclerView.LayoutManager create(Context context) {
                return new LinearLayoutManager(context);
            }
        };
    }

    public static Factory linear(@IntOrientation final int orientation, final boolean reverseLayout) {
        return new Factory() {
            @Override
            public RecyclerView.LayoutManager create(Context context) {
                return new LinearLayoutManager(context, orientation, reverseLayout);
            }
        };
    }

    public static Factory grid(final int spanCount) {
        return new Factory() {
            @Override
            public RecyclerView.LayoutManager create(Context context) {
                return new GridLayoutManager(context, spanCount);
            }
        };
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({LinearLayoutManager.VERTICAL, LinearLayoutManager.HORIZONTAL})
    public @interface IntOrientation {
    }
}
