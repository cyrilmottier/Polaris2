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
package com.cyrilmottier.polaris2.maps.model;

import com.cyrilmottier.polaris2.maps.internal.ListTranslators;
import com.cyrilmottier.polaris2.maps.internal.ListWrappers;

import java.util.List;

public final class Polyline {

    final com.google.android.gms.maps.model.Polyline mOriginal;

    private Polyline(com.google.android.gms.maps.model.Polyline original) {
        mOriginal = original;
    }

    /**
     * Obtain a new Polyline based an original one.
     *
     * @param original
     * @return
     * @hide
     */
    public static Polyline obtain(com.google.android.gms.maps.model.Polyline original) {
        return new Polyline(original);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Polyline)) {
            return false;
        }
        return mOriginal.equals(((Polyline) other).mOriginal);
    }

    @Override
    public int hashCode() {
        return mOriginal.hashCode();
    }

    public int getColor() {
        return mOriginal.getColor();
    }

    public String getId() {
        return mOriginal.getId();
    }

    public List<LatLng> getPoints() {
        final List<com.google.android.gms.maps.model.LatLng> original = mOriginal.getPoints();
        return original == null ? null : ListWrappers.forLatLng(original);
    }

    public float getWidth() {
        return mOriginal.getWidth();
    }

    public float getZIndex() {
        return mOriginal.getZIndex();
    }

    public boolean isGeodesic() {
        return mOriginal.isGeodesic();
    }

    public boolean isVisible() {
        return mOriginal.isVisible();
    }

    public void remove() {
        mOriginal.remove();
    }

    public void setColor(int color) {
        mOriginal.setColor(color);
    }

    public void setGeodesic(boolean geodesic) {
        mOriginal.setGeodesic(geodesic);
    }

    public void setPoints(List<LatLng> points) {
        mOriginal.setPoints(points == null ? null : ListTranslators.latLngList(points));
    }

    public void setVisible(boolean visible) {
        mOriginal.setVisible(visible);
    }

    public void setWidth(float width) {
        mOriginal.setWidth(width);
    }

    public void setZIndex(float zIndex) {
        mOriginal.setZIndex(zIndex);
    }

}
