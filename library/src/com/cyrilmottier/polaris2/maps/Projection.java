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
package com.cyrilmottier.polaris2.maps;

import com.cyrilmottier.polaris2.maps.model.LatLng;
import com.cyrilmottier.polaris2.maps.model.VisibleRegion;

import android.graphics.Point;

public final class Projection {

    final com.google.android.gms.maps.Projection mOriginal;

    Projection(com.google.android.gms.maps.Projection original) {
        mOriginal = original;
    }

    public LatLng fromScreenLocation(Point point) {
        return LatLng.obtain(mOriginal.fromScreenLocation(point));
    }

    public VisibleRegion getVisibleRegion() {
        return VisibleRegion.obtain(mOriginal.getVisibleRegion());
    }

    public Point toScreenLocation(LatLng location) {
        return mOriginal.toScreenLocation(location.mOriginal);
    }
}
