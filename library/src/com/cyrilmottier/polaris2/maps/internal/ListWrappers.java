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

import com.cyrilmottier.polaris2.maps.model.LatLng;

import java.util.List;

/**
 * @author Cyril Mottier
 */
public final class ListWrappers {

    private static final TypeTranslator<com.google.android.gms.maps.model.LatLng, LatLng> LAT_LNG_TRANSLATOR =
            new TypeTranslator<com.google.android.gms.maps.model.LatLng, LatLng>() {
                @Override
                public com.google.android.gms.maps.model.LatLng unwrap(LatLng wrapper) {
                    return wrapper.mOriginal;
                }

                @Override
                public LatLng wrap(com.google.android.gms.maps.model.LatLng original) {
                    return LatLng.obtain(original);
                }
            };

    private static final TypeTranslator<List<com.google.android.gms.maps.model.LatLng>, List<LatLng>> LAT_LNG_LIST_TRANSLATOR =
            new TypeTranslator<List<com.google.android.gms.maps.model.LatLng>, List<LatLng>>() {
                @Override
                public List<com.google.android.gms.maps.model.LatLng> unwrap(List<LatLng> wrapper) {
                    return ListTranslators.latLngList(wrapper);
                }

                @Override
                public List<LatLng> wrap(List<com.google.android.gms.maps.model.LatLng> original) {
                    return forLatLng(original);
                }
            };

    private ListWrappers() {
    }

    public static List<LatLng> forLatLng(List<com.google.android.gms.maps.model.LatLng> original) {
        return new ListWrapper<com.google.android.gms.maps.model.LatLng, LatLng>(original, LAT_LNG_TRANSLATOR);
    }

    public static List<List<LatLng>> forLatLngList(List<List<com.google.android.gms.maps.model.LatLng>> original) {
        return new ListWrapper<List<com.google.android.gms.maps.model.LatLng>, List<LatLng>>(original, LAT_LNG_LIST_TRANSLATOR);
    }

}
