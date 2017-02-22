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

package com.viel.databindinghelpers.factories;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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
