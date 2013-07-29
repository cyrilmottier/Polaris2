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

public final class LatLngBounds implements Parcelable {

    public static final Parcelable.Creator<LatLngBounds> CREATOR = new Parcelable.Creator<LatLngBounds>() {
        public LatLngBounds createFromParcel(Parcel in) {
            return new LatLngBounds((com.google.android.gms.maps.model.LatLngBounds) in.readParcelable(com.google.android.gms.maps.model.LatLngBounds.class.getClassLoader()));
        }

        public LatLngBounds[] newArray(int size) {
            return new LatLngBounds[size];
        }
    };

    @Polaris
    public static final LatLngBounds EARTH_BOUNDS = new LatLngBounds(new LatLng(LatLng.MIN_LATITUDE, LatLng.MIN_LONGITUDE), new LatLng(
            LatLng.MAX_LATITUDE, LatLng.MAX_LONGITUDE));

    /**
     * <strong>DO NOT USE.</strong>
     * <p/>
     * The original (immutable) LatLngBounds.
     *
     * @hide
     */
    public final com.google.android.gms.maps.model.LatLngBounds mOriginal;

    public final LatLng southwest;
    public final LatLng northeast;

    public LatLngBounds(LatLng southwest, LatLng northeast) {
        this(new com.google.android.gms.maps.model.LatLngBounds(southwest == null ? null : southwest.mOriginal,
                northeast == null ? null : northeast.mOriginal));
    }

    private LatLngBounds(com.google.android.gms.maps.model.LatLngBounds original) {
        mOriginal = original;

        southwest = original.southwest == null ? null : LatLng.obtain(original.southwest);
        northeast = original.northeast == null ? null : LatLng.obtain(original.northeast);
    }

    static LatLngBounds obtain(com.google.android.gms.maps.model.LatLngBounds original) {
        return new LatLngBounds(original);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LatLngBounds)) {
            return false;
        }
        return mOriginal.equals(((LatLngBounds) other).mOriginal);
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

    public boolean contains(LatLng point) {
        return mOriginal.contains(point == null ? null : point.mOriginal);
    }

    public LatLngBounds including(LatLng point) {
        return new LatLngBounds(mOriginal.including(point == null ? null : point.mOriginal));
    }

    /**
     * Check whether the given bounds intersects with ourselves.
     *
     * @param bounds The bounds to check
     * @return true if the given bounds intersect ourselves, false otherwise
     */
    @Polaris
    public boolean intersects(LatLngBounds bounds) {
        final boolean latIntersects =
                (bounds.northeast.latitude >= southwest.latitude) && (bounds.southwest.latitude <= northeast.latitude);
        final boolean lngIntersects =
                (bounds.northeast.longitude >= southwest.longitude) && (bounds.southwest.longitude <= northeast.longitude);

        return latIntersects && lngIntersects;
    }

    public static final class Builder {
        private final com.google.android.gms.maps.model.LatLngBounds.Builder mOriginal;

        public Builder() {
            this(new com.google.android.gms.maps.model.LatLngBounds.Builder());
        }

        private Builder(com.google.android.gms.maps.model.LatLngBounds.Builder original) {
            mOriginal = original;
        }

        public LatLngBounds build() {
            return new LatLngBounds(mOriginal.build());
        }

        public Builder include(LatLng point) {
            mOriginal.include(point.mOriginal);
            return this;
        }
    }

}
