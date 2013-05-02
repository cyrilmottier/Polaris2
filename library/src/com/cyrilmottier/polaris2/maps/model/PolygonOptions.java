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

public final class PolygonOptions implements Parcelable {

    public static final Parcelable.Creator<PolygonOptions> CREATOR = new Parcelable.Creator<PolygonOptions>() {
        public PolygonOptions createFromParcel(Parcel in) {
            return new PolygonOptions((com.google.android.gms.maps.model.PolygonOptions) in.readParcelable(null));
        }

        public PolygonOptions[] newArray(int size) {
            return new PolygonOptions[size];
        }
    };

    /**
     * DO NOT USE. The original CameraPosition.
     *
     * @hide
     */
    public final com.google.android.gms.maps.model.PolygonOptions mOriginal;

    private PolygonOptions mDefaultOptions;

    public PolygonOptions() {
        this(new com.google.android.gms.maps.model.PolygonOptions());
    }

    PolygonOptions(com.google.android.gms.maps.model.PolygonOptions original) {
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

    public PolygonOptions add(LatLng point) {
        mOriginal.add(point.mOriginal);
        return this;
    }

    public PolygonOptions add(LatLng... points) {
        mOriginal.add(points == null ? null : ListTranslators.latLngs(points));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> points) {
        mOriginal.addAll(points == null ? null : ListTranslators.latLngList(points));
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> points) {
        mOriginal.addHole(points == null ? null : ListTranslators.latLngList(points));
        return this;
    }

    public PolygonOptions fillColor(int color) {
        mOriginal.fillColor(color);
        return this;
    }

    public int getFillColor() {
        return mOriginal.getFillColor();
    }

    public List<List<LatLng>> getHoles() {
        final List<List<com.google.android.gms.maps.model.LatLng>> originals = mOriginal.getHoles();
        return originals == null ? null : ListWrappers.forLatLngList(originals);
    }

    public List<LatLng> getPoints() {
        final List<com.google.android.gms.maps.model.LatLng> originals = mOriginal.getPoints();
        return originals == null ? null : ListWrappers.forLatLng(originals);
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

    public PolygonOptions geodesic(boolean geodesic) {
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
     * Reset the PolygonOptions by setting all of its properties to their default values.
     */
    @Polaris
    public void reset() {
        if (mDefaultOptions == null) {
            mDefaultOptions = new PolygonOptions();
        }

        fillColor(mDefaultOptions.getFillColor());
        geodesic(mDefaultOptions.isGeodesic());
        strokeColor(mDefaultOptions.getStrokeColor());
        strokeWidth(mDefaultOptions.getStrokeWidth());
        visible(mDefaultOptions.isVisible());
        zIndex(mDefaultOptions.getZIndex());
        // HACK Cyril: The following lines imply get[Points|Holes]() return the internal
        // list of points instead of a copy ... actually there's no guarantee of it.
        getPoints().clear();
        getHoles().clear();
    }

    public PolygonOptions strokeColor(int color) {
        mOriginal.strokeColor(color);
        return this;
    }

    public PolygonOptions strokeWidth(float width) {
        mOriginal.strokeWidth(width);
        return this;
    }

    public PolygonOptions visible(boolean visible) {
        mOriginal.visible(visible);
        return this;
    }

    public PolygonOptions zIndex(float zIndex) {
        mOriginal.zIndex(zIndex);
        return this;
    }

}
