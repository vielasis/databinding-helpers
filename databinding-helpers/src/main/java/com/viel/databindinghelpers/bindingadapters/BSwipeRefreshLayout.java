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

package com.viel.databindinghelpers.bindingadapters;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;

public class BSwipeRefreshLayout {

    @BindingAdapter(value = {"colorScheme", "refreshListener"}, requireAll = false)
    public static void setColorSchemeColors(SwipeRefreshLayout view, int[] colors, SwipeRefreshLayout.OnRefreshListener listener) {
        view.setColorSchemeColors(colors);
        if (listener != null) {
            view.setOnRefreshListener(listener);
        }
    }

}
