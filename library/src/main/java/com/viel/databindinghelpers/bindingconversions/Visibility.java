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

package com.viel.databindinghelpers.bindingconversions;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.view.View;

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
