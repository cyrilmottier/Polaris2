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

import com.cyrilmottier.polaris2.maps.model.CameraPosition;
import com.cyrilmottier.polaris2.maps.model.LatLng;
import com.cyrilmottier.polaris2.maps.model.LatLngBounds;

import android.graphics.Point;

public final class CameraUpdateFactory {

    private CameraUpdateFactory() {
        // No instances
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        return new CameraUpdate(com.google.android.gms.maps.CameraUpdateFactory.newCameraPosition(cameraPosition.mOriginal));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        return new CameraUpdate(com.google.android.gms.maps.CameraUpdateFactory.newLatLng(latLng.mOriginal));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds laLngBounds, int padding) {
        return new CameraUpdate(com.google.android.gms.maps.CameraUpdateFactory.newLatLngBounds(laLngBounds.mOriginal, padding));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int width, int height, int padding) {
        return new CameraUpdate(com.google.android.gms.maps.CameraUpdateFactory.newLatLngBounds(latLngBounds.mOriginal, width, height,
                padding));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float zoom) {
        return new CameraUpdate(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(latLng.mOriginal, zoom));
    }

    public static CameraUpdate scrollBy(float xPixel, float yPixel) {
        return new CameraUpdate(com.google.android.gms.maps.CameraUpdateFactory.scrollBy(xPixel, yPixel));
    }

    public static CameraUpdate zoomBy(float amount) {
        return new CameraUpdate(com.google.android.gms.maps.CameraUpdateFactory.zoomBy(amount));
    }

    public static CameraUpdate zoomBy(float amount, Point focus) {
        return new CameraUpdate(com.google.android.gms.maps.CameraUpdateFactory.zoomBy(amount, focus));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(com.google.android.gms.maps.CameraUpdateFactory.zoomIn());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(com.google.android.gms.maps.CameraUpdateFactory.zoomOut());
    }

    public static CameraUpdate zoomTo(float zoom) {
        return new CameraUpdate(com.google.android.gms.maps.CameraUpdateFactory.zoomTo(zoom));
    }

}
