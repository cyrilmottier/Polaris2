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

public final class Circle {

    final com.google.android.gms.maps.model.Circle mOriginal;

    private Circle(com.google.android.gms.maps.model.Circle original) {
        mOriginal = original;
    }

    /**
     * <strong>DO NOT USE.</strong>
     * <p/>
     * Obtain a new Circle based an original one.
     *
     * @param original
     * @return
     * @hide
     */
    public static Circle obtain(com.google.android.gms.maps.model.Circle original) {
        return new Circle(original);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Circle)) {
            return false;
        }
        return mOriginal.equals(((Circle) other).mOriginal);
    }

    @Override
    public int hashCode() {
        return mOriginal.hashCode();
    }

    public LatLng getCenter() {
        final com.google.android.gms.maps.model.LatLng original = mOriginal.getCenter();
        return original == null ? null : LatLng.obtain(original);
    }

    public int getFillColor() {
        return mOriginal.getFillColor();
    }

    public String getId() {
        return mOriginal.getId();
    }

    public double getRadius() {
        return mOriginal.getRadius();
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

    public boolean isVisible() {
        return mOriginal.isVisible();
    }

    public void remove() {
        mOriginal.remove();
    }

    public void setCenter(LatLng center) {
        mOriginal.setCenter(center == null ? null : center.mOriginal);
    }

    public void setFillColor(int fillColor) {
        mOriginal.setFillColor(fillColor);
    }

    public void setRadius(double radius) {
        mOriginal.setRadius(radius);
    }

    public void setStrokeWidth(float strokeWidth) {
        mOriginal.setStrokeWidth(strokeWidth);
    }

    public void setStrokeColor(int strokeColor) {
        mOriginal.setStrokeColor(strokeColor);
    }

    public void setVisible(boolean visible) {
        mOriginal.setVisible(visible);
    }

    public void setZIndex(float zIndex) {
        mOriginal.setZIndex(zIndex);
    }

}
