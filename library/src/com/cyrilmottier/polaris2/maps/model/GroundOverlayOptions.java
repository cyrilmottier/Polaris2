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

import com.cyrilmottier.polaris2.maps.Polaris;

import android.os.Parcel;
import android.os.Parcelable;

public final class GroundOverlayOptions implements Parcelable {

    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new Parcelable.Creator<GroundOverlayOptions>() {
        public GroundOverlayOptions createFromParcel(Parcel in) {
            return new GroundOverlayOptions((com.google.android.gms.maps.model.GroundOverlayOptions) in.readParcelable(null));
        }

        public GroundOverlayOptions[] newArray(int size) {
            return new GroundOverlayOptions[size];
        }
    };

    public static final float NO_DIMENSION = com.google.android.gms.maps.model.GroundOverlayOptions.NO_DIMENSION;

    /**
     * <strong>DO NOT USE.</strong>
     * <p/>
     * The original CameraPosition.
     *
     * @hide
     */
    public final com.google.android.gms.maps.model.GroundOverlayOptions mOriginal;

    private GroundOverlayOptions mDefaultOptions;

    public GroundOverlayOptions() {
        this(new com.google.android.gms.maps.model.GroundOverlayOptions());
    }

    GroundOverlayOptions(com.google.android.gms.maps.model.GroundOverlayOptions original) {
        mOriginal = original;
    }

    @Override
    public int describeContents() {
        return mOriginal.describeContents();
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(mOriginal, flags);
    }

    public GroundOverlayOptions anchor(float u, float v) {
        mOriginal.anchor(u, v);
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        mOriginal.bearing(bearing);
        return this;
    }

    public float getAnchorU() {
        return mOriginal.getAnchorU();
    }

    public float getAnchorV() {
        return mOriginal.getAnchorV();
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

    public BitmapDescriptor getImage() {
        final com.google.android.gms.maps.model.BitmapDescriptor original = mOriginal.getImage();
        return original == null ? null : new BitmapDescriptor(mOriginal.getImage());
    }

    public LatLng getLocation() {
        final com.google.android.gms.maps.model.LatLng original = mOriginal.getLocation();
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

    public GroundOverlayOptions image(BitmapDescriptor image) {
        mOriginal.image(image == null ? null : image.mOriginal);
        return this;
    }

    public boolean isVisible() {
        return mOriginal.isVisible();
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        mOriginal.position(location == null ? null : location.mOriginal, width);
        return this;
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        mOriginal.position(location == null ? null : location.mOriginal, width, height);
        return this;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        mOriginal.positionFromBounds(bounds == null ? null : bounds.mOriginal);
        return this;
    }

    /**
     * Reset the GroundOverlayOptions by setting all of its properties to their default values.
     */
    @Polaris
    public void reset() {
        if (mDefaultOptions == null) {
            mDefaultOptions = new GroundOverlayOptions();
        }
        anchor(mDefaultOptions.getAnchorU(), mDefaultOptions.getAnchorV());
        bearing(mDefaultOptions.getBearing());
        image(mDefaultOptions.getImage());
        position(mDefaultOptions.getLocation(), mDefaultOptions.getWidth(), mDefaultOptions.getHeight());
        transparency(mDefaultOptions.getTransparency());
        visible(mDefaultOptions.isVisible());
        zIndex(mDefaultOptions.getZIndex());
    }

    public GroundOverlayOptions transparency(float transparency) {
        mOriginal.transparency(transparency);
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        mOriginal.visible(visible);
        return this;
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        mOriginal.zIndex(zIndex);
        return this;
    }

}
