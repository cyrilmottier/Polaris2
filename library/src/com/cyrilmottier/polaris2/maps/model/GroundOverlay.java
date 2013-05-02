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

public final class GroundOverlay {

    final com.google.android.gms.maps.model.GroundOverlay mOriginal;

    private GroundOverlay(com.google.android.gms.maps.model.GroundOverlay original) {
        mOriginal = original;
    }

    /**
     * <strong>DO NOT USE.</strong>
     * <p/>
     * Obtain a new GroundOverlay based an original one.
     *
     * @param original
     * @return
     * @hide
     */
    public static GroundOverlay obtain(com.google.android.gms.maps.model.GroundOverlay original) {
        return new GroundOverlay(original);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroundOverlay)) {
            return false;
        }
        return mOriginal.equals(((GroundOverlay) other).mOriginal);
    }

    @Override
    public int hashCode() {
        return mOriginal.hashCode();
    }

    public float getBearing() {
        return mOriginal.getBearing();
    }

    public LatLngBounds getBounds() {
        final com.google.android.gms.maps.model.LatLngBounds original = mOriginal.getBounds();
        return original == null ? null : LatLngBounds.obtain(original);
    }

    public float getHeight() {
        return mOriginal.getHeight();
    }

    public String getId() {
        return mOriginal.getId();
    }

    public LatLng getPosition() {
        final com.google.android.gms.maps.model.LatLng original = mOriginal.getPosition();
        return original == null ? null : LatLng.obtain(original);
    }

    public float getTransparency() {
        return mOriginal.getTransparency();
    }

    public float getWidth() {
        return mOriginal.getWidth();
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

    public void setBearing(float bearing) {
        mOriginal.setBearing(bearing);
    }

    public void setDimensions(float width) {
        mOriginal.setDimensions(width);
    }

    public void setDimensions(float width, float height) {
        mOriginal.setDimensions(width, height);
    }

    public void setPosition(LatLng position) {
        mOriginal.setPosition(position == null ? null : position.mOriginal);
    }

    public void setPositionFromBounds(LatLngBounds bounds) {
        mOriginal.setPositionFromBounds(bounds == null ? null : bounds.mOriginal);
    }

    public void setTransparency(float transparency) {
        mOriginal.setTransparency(transparency);
    }

    public void setVisible(boolean visible) {
        mOriginal.setVisible(visible);
    }

    public void setZIndex(float zIndex) {
        mOriginal.setZIndex(zIndex);
    }

}
