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

public final class Marker {

    final com.google.android.gms.maps.model.Marker mOriginal;

    private Marker(com.google.android.gms.maps.model.Marker original) {
        mOriginal = original;
    }

    /**
     * <strong>DO NOT USE.</strong>
     * <p/>
     * Obtain a new Marker based an original one.
     *
     * @param original
     * @return
     * @hide
     */
    public static Marker obtain(com.google.android.gms.maps.model.Marker original) {
        return new Marker(original);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Marker)) {
            return false;
        }

        return mOriginal.equals(((Marker) other).mOriginal);
    }

    @Override
    public int hashCode() {
        return mOriginal.hashCode();
    }

    public String getId() {
        return mOriginal.getId();
    }

    public LatLng getPosition() {
        final com.google.android.gms.maps.model.LatLng original = mOriginal.getPosition();
        return original == null ? null : LatLng.obtain(original);
    }

    public String getSnippet() {
        return mOriginal.getSnippet();
    }

    public String getTitle() {
        return mOriginal.getTitle();
    }

    public void hideInfoWindow() {
        mOriginal.hideInfoWindow();
    }

    public boolean isDraggable() {
        return mOriginal.isDraggable();
    }

    public boolean isInfoWindowShown() {
        return mOriginal.isInfoWindowShown();
    }

    public boolean isVisible() {
        return mOriginal.isVisible();
    }

    public void remove() {
        mOriginal.remove();
    }

    public void setDraggable(boolean draggable) {
        mOriginal.setDraggable(draggable);
    }

    public void setPosition(LatLng latLng) {
        mOriginal.setPosition(latLng.mOriginal);
    }

    public void setSnippet(String snippet) {
        mOriginal.setSnippet(snippet);
    }

    public void setTitle(String title) {
        mOriginal.setTitle(title);
    }

    public void setVisible(boolean visible) {
        mOriginal.setVisible(visible);
    }

    public void showInfoWindow() {
        mOriginal.showInfoWindow();
    }

}
