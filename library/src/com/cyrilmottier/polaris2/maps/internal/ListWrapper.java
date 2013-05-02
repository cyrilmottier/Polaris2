/*
 * Copyright (C) 2013 Cyril Mottier (http://cyrilmottier.com)
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
package com.cyrilmottier.polaris2.maps.internal;

import java.util.AbstractList;
import java.util.List;

/**
 * An implementation of a List that translates the returned object from the internal type to the external type.
 *
 * @param <O> The type of the internal object i.e. the hidden type
 * @param <N> The type returned by the methods of the API i.e. the exposed type
 * @author Cyril Mottier
 */
final class ListWrapper<O, N> extends AbstractList<N> {

    private final TypeTranslator<O, N> mTypeTranslator;
    private final List<O> mOriginal;

    public ListWrapper(List<O> original, TypeTranslator<O, N> typeTranslator) {
        mTypeTranslator = typeTranslator;
        mOriginal = original;
    }

    @Override
    public N get(int location) {
        final O original = mOriginal.get(location);
        return original == null ? null : mTypeTranslator.wrap(mOriginal.get(location));
    }

    @Override
    public int size() {
        return mOriginal.size();
    }

    @Override
    public void add(int location, N object) {
        mOriginal.add(location, object == null ? null : mTypeTranslator.unwrap(object));
    }

    @Override
    public N remove(int location) {
        final O original = mOriginal.remove(location);
        return original == null ? null : mTypeTranslator.wrap(mOriginal.remove(location));
    }

    @Override
    public N set(int location, N object) {
        final O original = mOriginal.set(location, object == null ? null : mTypeTranslator.unwrap(object));
        return original == null ? null : mTypeTranslator.wrap(original);
    }
}
