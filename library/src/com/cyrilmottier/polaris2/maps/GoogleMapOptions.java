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

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;

public final class GoogleMapOptions implements Parcelable {

    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new Parcelable.Creator<GoogleMapOptions>() {
        public GoogleMapOptions createFromParcel(Parcel in) {
            return new GoogleMapOptions((com.google.android.gms.maps.GoogleMapOptions) in.readParcelable(null));
        }

        public GoogleMapOptions[] newArray(int size) {
            return new GoogleMapOptions[size];
        }
    };

    final com.google.android.gms.maps.GoogleMapOptions mOriginal;

    private GoogleMapOptions mDefaultOptions;

    public GoogleMapOptions() {
        this(new com.google.android.gms.maps.GoogleMapOptions());
    }

    GoogleMapOptions(com.google.android.gms.maps.GoogleMapOptions original) {
        mOriginal = original;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(mOriginal, flags);
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        mOriginal.camera(camera.mOriginal);
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        mOriginal.compassEnabled(enabled);
        return this;
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        return new GoogleMapOptions(com.google.android.gms.maps.GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public CameraPosition getCamera() {
        final com.google.android.gms.maps.model.CameraPosition original = mOriginal.getCamera();
        return original == null ? null : CameraPosition.obtain(original);
    }

    public Boolean getCompassEnabled() {
        return mOriginal.getCompassEnabled();
    }

    public int getMapType() {
        return mOriginal.getMapType();
    }

    public Boolean getScrollGesturesEnabled() {
        return mOriginal.getScrollGesturesEnabled();
    }

    public Boolean getRotateGesturesEnabled() {
        return mOriginal.getRotateGesturesEnabled();
    }

    public Boolean getTiltGesturesEnabled() {
        return mOriginal.getTiltGesturesEnabled();
    }

    public Boolean getUseViewLifecycleInFragment() {
        return mOriginal.getUseViewLifecycleInFragment();
    }

    public Boolean getZoomControlsEnabled() {
        return mOriginal.getZoomControlsEnabled();
    }

    public Boolean getZoomGesturesEnabled() {
        return mOriginal.getZoomControlsEnabled();
    }

    public Boolean getZOrderOnTop() {
        return mOriginal.getZOrderOnTop();
    }

    public GoogleMapOptions mapType(int mapType) {
        mOriginal.mapType(mapType);
        return this;
    }

    /**
     * Reset the GoogleMapOptions by setting all of its properties to their default values.
     */
    @Polaris
    public void reset() {
        if (mDefaultOptions == null) {
            mDefaultOptions = new GoogleMapOptions();
        }
        camera(mDefaultOptions.getCamera());
        compassEnabled(mDefaultOptions.getCompassEnabled());
        mapType(mDefaultOptions.getMapType());
        scrollGesturesEnabled(mDefaultOptions.getScrollGesturesEnabled());
        rotateGesturesEnabled(mDefaultOptions.getRotateGesturesEnabled());
        tiltGesturesEnabled(mDefaultOptions.getTiltGesturesEnabled());
        useViewLifecycleInFragment(mDefaultOptions.getUseViewLifecycleInFragment());
        zoomControlsEnabled(mDefaultOptions.getZoomControlsEnabled());
        zoomGesturesEnabled(mDefaultOptions.getZoomGesturesEnabled());
        zOrderOnTop(mDefaultOptions.getZOrderOnTop());
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        mOriginal.rotateGesturesEnabled(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        mOriginal.scrollGesturesEnabled(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        mOriginal.tiltGesturesEnabled(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        mOriginal.useViewLifecycleInFragment(useViewLifecycleInFragment);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        mOriginal.zoomControlsEnabled(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        mOriginal.zoomGesturesEnabled(enabled);
        return this;
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        mOriginal.zOrderOnTop(zOrderOnTop);
        return this;
    }

}
