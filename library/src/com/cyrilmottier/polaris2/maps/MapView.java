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

import com.google.android.gms.maps.GoogleMapOptions;

import android.content.Context;
import android.util.AttributeSet;

public class MapView extends com.google.android.gms.maps.MapView {

    public MapView(Context context) {
        super(context);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context, options);
    }


    /**
     * Gets the underlying GoogleMap that is tied to this view.
     *
     * @return the underlying GoogleMap. Null if the view of the map is not yet ready. This can happen when Google Play services is not
     *         available. If Google Play services becomes available afterwards, calling this method again will initialize and return the
     *         GoogleMap.
     */
    @Polaris
    public GoogleMap getPolarisMap() {
        final com.google.android.gms.maps.GoogleMap googleMap = getMap();
        return googleMap == null ? null : new GoogleMap(googleMap);
    }

}
