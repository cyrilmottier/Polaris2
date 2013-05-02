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

public final class UiSettings {

    final com.google.android.gms.maps.UiSettings mOriginal;

    UiSettings(com.google.android.gms.maps.UiSettings original) {
        mOriginal = original;
    }

    public boolean isCompassEnabled() {
        return mOriginal.isCompassEnabled();
    }

    public boolean isMyLocationButtonEnabled() {
        return mOriginal.isMyLocationButtonEnabled();
    }

    public boolean isRotateGesturesEnabled() {
        return mOriginal.isRotateGesturesEnabled();
    }

    public boolean isScrollGesturesEnabled() {
        return mOriginal.isScrollGesturesEnabled();
    }

    public boolean isTiltGesturesEnabled() {
        return mOriginal.isTiltGesturesEnabled();
    }

    public boolean isZoomControlsEnabled() {
        return mOriginal.isZoomControlsEnabled();
    }

    public boolean isZoomGesturesEnabled() {
        return mOriginal.isZoomGesturesEnabled();
    }

    public void setAllGesturesEnabled(boolean enabled) {
        mOriginal.setAllGesturesEnabled(enabled);
    }

    public void setCompassEnabled(boolean enabled) {
        mOriginal.setCompassEnabled(enabled);
    }

    public void setMyLocationButtonEnabled(boolean enabled) {
        mOriginal.setMyLocationButtonEnabled(enabled);
    }

    public void setRotateGesturesEnabled(boolean enabled) {
        mOriginal.setRotateGesturesEnabled(enabled);
    }

    public void setScrollGesturesEnabled(boolean enabled) {
        mOriginal.setScrollGesturesEnabled(enabled);
    }

    public void setTiltGesturesEnabled(boolean enabled) {
        mOriginal.setTiltGesturesEnabled(enabled);
    }

    public void setZoomControlsEnabled(boolean enabled) {
        mOriginal.setZoomControlsEnabled(enabled);
    }

    public void setZoomGesturesEnabled(boolean enabled) {
        mOriginal.setZoomGesturesEnabled(enabled);
    }

}
