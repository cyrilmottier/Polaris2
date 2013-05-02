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

import android.os.Parcel;
import android.os.Parcelable;

public final class VisibleRegion implements Parcelable {

    public static final Parcelable.Creator<VisibleRegion> CREATOR = new Parcelable.Creator<VisibleRegion>() {
        public VisibleRegion createFromParcel(Parcel in) {
            return new VisibleRegion((com.google.android.gms.maps.model.VisibleRegion) in.readParcelable(null));
        }

        public VisibleRegion[] newArray(int size) {
            return new VisibleRegion[size];
        }
    };

    final com.google.android.gms.maps.model.VisibleRegion mOriginal;

    public final LatLng nearLeft;
    public final LatLng nearRight;
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;

    public VisibleRegion(LatLng nearLeft, LatLng nearRight, LatLng farLeft, LatLng farRight, LatLngBounds latLngBounds) {
        this(new com.google.android.gms.maps.model.VisibleRegion(nearLeft.mOriginal, nearRight.mOriginal, farLeft.mOriginal,
                farRight.mOriginal, latLngBounds.mOriginal));
    }

    private VisibleRegion(com.google.android.gms.maps.model.VisibleRegion original) {
        mOriginal = original;

        this.nearLeft = LatLng.obtain(original.nearLeft);
        this.nearRight = LatLng.obtain(original.nearRight);
        this.farLeft = LatLng.obtain(original.farLeft);
        this.farRight = LatLng.obtain(original.farRight);
        this.latLngBounds = LatLngBounds.obtain(original.latLngBounds);
    }

    /**
     * Obtain a new VisibleRegion based an original one.
     *
     * @param original
     * @return
     * @hide
     */
    public static VisibleRegion obtain(com.google.android.gms.maps.model.VisibleRegion original) {
        return new VisibleRegion(original);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VisibleRegion)) {
            return false;
        }
        return mOriginal.equals(((VisibleRegion) other).mOriginal);
    }

    @Override
    public int hashCode() {
        return mOriginal.hashCode();
    }

    @Override
    public String toString() {
        return mOriginal.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(mOriginal, flags);
    }

}
