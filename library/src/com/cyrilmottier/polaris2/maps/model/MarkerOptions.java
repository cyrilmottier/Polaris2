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

public final class MarkerOptions implements Parcelable {

    public static final Parcelable.Creator<MarkerOptions> CREATOR = new Parcelable.Creator<MarkerOptions>() {
        public MarkerOptions createFromParcel(Parcel in) {
            return new MarkerOptions((com.google.android.gms.maps.model.MarkerOptions) in.readParcelable(null));
        }

        public MarkerOptions[] newArray(int size) {
            return new MarkerOptions[size];
        }
    };

    /**
     * DO NOT USE. The original CameraPosition.
     *
     * @hide
     */
    public final com.google.android.gms.maps.model.MarkerOptions mOriginal;

    private MarkerOptions mDefaultOptions;

    public MarkerOptions() {
        this(new com.google.android.gms.maps.model.MarkerOptions());
    }

    MarkerOptions(com.google.android.gms.maps.model.MarkerOptions original) {
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

    public MarkerOptions anchor(float u, float v) {
        mOriginal.anchor(u, v);
        return this;
    }

    public MarkerOptions draggable(boolean draggable) {
        mOriginal.draggable(draggable);
        return this;
    }

    public float getAnchorU() {
        return mOriginal.getAnchorU();
    }

    public float getAnchorV() {
        return mOriginal.getAnchorV();
    }

    public BitmapDescriptor getIcon() {
        final com.google.android.gms.maps.model.BitmapDescriptor original = mOriginal.getIcon();
        return original == null ? null : new BitmapDescriptor(original);
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

    public MarkerOptions icon(BitmapDescriptor icon) {
        mOriginal.icon(icon == null ? null : icon.mOriginal);
        return this;
    }

    public boolean isDraggable() {
        return mOriginal.isDraggable();
    }

    public boolean isVisible() {
        return mOriginal.isVisible();
    }

    public MarkerOptions position(LatLng position) {
        mOriginal.position(position == null ? null : position.mOriginal);
        return this;
    }

    /**
     * Reset the MarkerOptions by setting all of its properties to their default values.
     */
    @Polaris
    public void reset() {
        if (mDefaultOptions == null) {
            mDefaultOptions = new MarkerOptions();
        }
        anchor(mDefaultOptions.getAnchorU(), mDefaultOptions.getAnchorV());
        draggable(mDefaultOptions.isDraggable());
        icon(mDefaultOptions.getIcon());
        position(mDefaultOptions.getPosition());
        snippet(mDefaultOptions.getSnippet());
        title(mDefaultOptions.getTitle());
        visible(mDefaultOptions.isVisible());
    }

    public MarkerOptions snippet(String snippet) {
        mOriginal.snippet(snippet);
        return this;
    }

    public MarkerOptions title(String title) {
        mOriginal.title(title);
        return this;
    }

    public MarkerOptions visible(boolean visible) {
        mOriginal.visible(visible);
        return this;
    }

}
