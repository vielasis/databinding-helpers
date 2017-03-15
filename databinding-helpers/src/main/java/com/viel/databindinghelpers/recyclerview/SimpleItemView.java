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

package com.viel.databindinghelpers.recyclerview;

import android.support.annotation.AnyRes;
import android.support.annotation.LayoutRes;

public class SimpleItemView implements ItemView {

    private int layoutId, bindingVarId;

    public SimpleItemView(@LayoutRes int layoutId, @AnyRes int bindingVarId) {
        this.layoutId = layoutId;
        this.bindingVarId = bindingVarId;
    }

    @Override
    public int getLayoutId(int position) {
        return layoutId;
    }

    @Override
    public int getBindingVarId(int position) {
        return bindingVarId;
    }
}
