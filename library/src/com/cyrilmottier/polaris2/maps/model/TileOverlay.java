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

public final class TileOverlay {

    final com.google.android.gms.maps.model.TileOverlay mOriginal;

    private TileOverlay(com.google.android.gms.maps.model.TileOverlay original) {
        mOriginal = original;
    }

    /**
     * Obtain a new TileOverlay based an original one.
     *
     * @param original
     * @return
     * @hide
     */
    public static TileOverlay obtain(com.google.android.gms.maps.model.TileOverlay original) {
        return new TileOverlay(original);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TileOverlay)) {
            return false;
        }
        return mOriginal.equals(((TileOverlay) other).mOriginal);
    }

    @Override
    public int hashCode() {
        return mOriginal.hashCode();
    }

    public void clearTileCache() {
        mOriginal.clearTileCache();
    }

    public String getId() {
        return mOriginal.getId();
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

    public void setVisible(boolean visible) {
        mOriginal.setVisible(visible);
    }

    public void setZIndex(float zIndex) {
        mOriginal.setZIndex(zIndex);
    }

}
