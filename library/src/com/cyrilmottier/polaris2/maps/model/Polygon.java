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

public final class Polygon {

    final com.google.android.gms.maps.model.Polygon mOriginal;

    private Polygon(com.google.android.gms.maps.model.Polygon original) {
        mOriginal = original;
    }

    /**
     * Obtain a new Polygon based an original one.
     *
     * @param original
     * @return
     * @hide
     */
    public static Polygon obtain(com.google.android.gms.maps.model.Polygon original) {
        return new Polygon(original);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Polygon)) {
            return false;
        }
        return mOriginal.equals(((Polygon) other).mOriginal);
    }

    @Override
    public int hashCode() {
        return mOriginal.hashCode();
    }

    public int getFillColor() {
        return mOriginal.getFillColor();
    }

    public List<List<LatLng>> getHoles() {
        final List<List<com.google.android.gms.maps.model.LatLng>> original = mOriginal.getHoles();
        return original == null ? null : ListWrappers.forLatLngList(original);
    }

    public String getId() {
        return mOriginal.getId();
    }

    public List<LatLng> getPoints() {
        final List<com.google.android.gms.maps.model.LatLng> original = mOriginal.getPoints();
        return original == null ? null : ListWrappers.forLatLng(original);
    }

    public int getStrokeColor() {
        return mOriginal.getStrokeColor();
    }

    public float getStrokeWidth() {
        return mOriginal.getStrokeWidth();
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

    public void setGeodesic(boolean geodesic) {
        mOriginal.setGeodesic(geodesic);
    }

    public void setFillColor(int color) {
        mOriginal.setFillColor(color);
    }

    public void setHoles(List<? extends List<LatLng>> holes) {
        mOriginal.setHoles(holes == null ? null : ListTranslators.latLngListList(holes));
    }

    public void setPoints(List<LatLng> points) {
        mOriginal.setPoints(points == null ? null : ListTranslators.latLngList(points));
    }

    public void setStrokeColor(int color) {
        mOriginal.setStrokeColor(color);
    }

    public void setStrokeWidth(float width) {
        mOriginal.setStrokeWidth(width);
    }

    public void setVisible(boolean visible) {
        mOriginal.setVisible(visible);
    }

    public void setZIndex(float zIndex) {
        mOriginal.setZIndex(zIndex);
    }

}
