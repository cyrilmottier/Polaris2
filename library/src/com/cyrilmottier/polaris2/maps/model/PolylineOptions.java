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
import com.cyrilmottier.polaris2.maps.internal.ListTranslators;
import com.cyrilmottier.polaris2.maps.internal.ListWrappers;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public final class PolylineOptions implements Parcelable {

    public static final Parcelable.Creator<PolylineOptions> CREATOR = new Parcelable.Creator<PolylineOptions>() {
        public PolylineOptions createFromParcel(Parcel in) {
            return new PolylineOptions((com.google.android.gms.maps.model.PolylineOptions) in.readParcelable(null));
        }

        public PolylineOptions[] newArray(int size) {
            return new PolylineOptions[size];
        }
    };

    /**
     * DO NOT USE. The original CameraPosition.
     *
     * @hide
     */
    public final com.google.android.gms.maps.model.PolylineOptions mOriginal;

    private PolylineOptions mDefaultOptions;

    public PolylineOptions() {
        this(new com.google.android.gms.maps.model.PolylineOptions());
    }

    PolylineOptions(com.google.android.gms.maps.model.PolylineOptions original) {
        mOriginal = original;
    }

    @Override
    public int describeContents() {
        return mOriginal.describeContents();
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        mOriginal.writeToParcel(out, flags);
    }

    public PolylineOptions add(LatLng point) {
        mOriginal.add(point.mOriginal);
        return this;
    }

    public PolylineOptions add(LatLng... points) {
        mOriginal.add(points == null ? null : ListTranslators.latLngs(points));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> points) {
        mOriginal.addAll(points == null ? null : ListTranslators.latLngList(points));
        return this;
    }

    public PolylineOptions color(int color) {
        mOriginal.color(color);
        return this;
    }

    public int getColor() {
        return mOriginal.getColor();
    }

    public List<LatLng> getPoints() {
        final List<com.google.android.gms.maps.model.LatLng> originals = mOriginal.getPoints();
        return originals == null ? null : ListWrappers.forLatLng(originals);
    }

    public float getWidth() {
        return mOriginal.getWidth();
    }

    public float getZIndex() {
        return mOriginal.getZIndex();
    }

    public PolylineOptions geodesic(boolean geodesic) {
        mOriginal.geodesic(geodesic);
        return this;
    }

    public boolean isGeodesic() {
        return mOriginal.isGeodesic();
    }

    public boolean isVisible() {
        return mOriginal.isVisible();
    }

    /**
     * Reset the PolylineOptions by setting all of its properties to their default values.
     */
    @Polaris
    public void reset() {
        if (mDefaultOptions == null) {
            mDefaultOptions = new PolylineOptions();
        }
        color(mDefaultOptions.getColor());
        geodesic(mDefaultOptions.isGeodesic());
        visible(mDefaultOptions.isVisible());
        width(mDefaultOptions.getWidth());
        zIndex(mDefaultOptions.getZIndex());
        // HACK Cyril: The following line implies getPoints() returns the internal
        // list of points instead of a copy ... actually there's no guarantee of it.
        mOriginal.getPoints().clear();
    }

    public PolylineOptions visible(boolean visible) {
        mOriginal.visible(visible);
        return this;
    }

    public PolylineOptions width(float width) {
        mOriginal.width(width);
        return this;
    }

    public PolylineOptions zIndex(float zIndex) {
        mOriginal.zIndex(zIndex);
        return this;
    }

}
