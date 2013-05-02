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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cyril Mottier
 */
public final class ListTranslators {

    private ListTranslators() {
    }

    public static List<List<com.google.android.gms.maps.model.LatLng>> latLngListList(List<? extends List<LatLng>> holes) {
        final ArrayList<List<com.google.android.gms.maps.model.LatLng>> originals = newArrayList(holes.size());
        for (int i = 0; i < holes.size(); i++) {
            final List<LatLng> hole = holes.get(i);
            final ArrayList<com.google.android.gms.maps.model.LatLng> originalHole = newArrayList(hole.size());
            for (int j = 0; j < hole.size(); j++) {
                originalHole.add(hole.get(j).mOriginal);
            }
            originals.add(originalHole);
        }
        return originals;
    }

    public static com.google.android.gms.maps.model.LatLng[] latLngs(LatLng[] points) {
        final com.google.android.gms.maps.model.LatLng[] originals = new com.google.android.gms.maps.model.LatLng[points.length];
        for (int i = 0; i < points.length; i++) {
            originals[i] = points[i].mOriginal;
        }
        return originals;
    }

    public static List<com.google.android.gms.maps.model.LatLng> latLngList(Iterable<LatLng> points) {
        final ArrayList<com.google.android.gms.maps.model.LatLng> originals = new ArrayList<com.google.android.gms.maps.model.LatLng>();
        for (LatLng latLng : points) {
            originals.add(latLng.mOriginal);
        }
        return originals;
    }

    private static <E> ArrayList<E> newArrayList(int capacity) {
        return new ArrayList<E>(capacity);
    }

}
