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

public final class CircleOptions implements Parcelable {

    public static final Parcelable.Creator<CircleOptions> CREATOR = new Parcelable.Creator<CircleOptions>() {
        public CircleOptions createFromParcel(Parcel in) {
            return new CircleOptions((com.google.android.gms.maps.model.CircleOptions) in.readParcelable(com.google.android.gms.maps.model.CircleOptions.class.getClassLoader()));
        }

        public CircleOptions[] newArray(int size) {
            return new CircleOptions[size];
        }
    };

    /**
     * <strong>DO NOT USE.</strong>
     * <p/>
     * The original CircleOptions.
     *
     * @hide
     */
    public final com.google.android.gms.maps.model.CircleOptions mOriginal;

    private CircleOptions mDefaultOptions;

    public CircleOptions() {
        this(new com.google.android.gms.maps.model.CircleOptions());
    }

    CircleOptions(com.google.android.gms.maps.model.CircleOptions original) {
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

    public CircleOptions center(LatLng point) {
        mOriginal.center(point == null ? null : point.mOriginal);
        return this;
    }

    public CircleOptions fillColor(int color) {
        mOriginal.fillColor(color);
        return this;
    }

    public LatLng getCenter() {
        final com.google.android.gms.maps.model.LatLng original = mOriginal.getCenter();
        return original == null ? null : LatLng.obtain(original);
    }

    public int getFillColor() {
        return mOriginal.getFillColor();
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

    public CircleOptions radius(double radius) {
        mOriginal.radius(radius);
        return this;
    }

    /**
     * Reset the CircleOptions by setting all of its properties to their default values.
     */
    @Polaris
    public void reset() {
        if (mDefaultOptions == null) {
            mDefaultOptions = new CircleOptions();
        }
        center(mDefaultOptions.getCenter());
        fillColor(mDefaultOptions.getFillColor());
        radius(mDefaultOptions.getRadius());
        strokeColor(mDefaultOptions.getStrokeColor());
        strokeWidth(mDefaultOptions.getStrokeWidth());
        visible(mDefaultOptions.isVisible());
        zIndex(mDefaultOptions.getZIndex());
    }

    public CircleOptions strokeColor(int color) {
        mOriginal.strokeColor(color);
        return this;
    }

    public CircleOptions strokeWidth(float width) {
        mOriginal.strokeWidth(width);
        return this;
    }

    public CircleOptions visible(boolean visible) {
        mOriginal.visible(visible);
        return this;
    }

    public CircleOptions zIndex(float zIndex) {
        mOriginal.zIndex(zIndex);
        return this;
    }

}
