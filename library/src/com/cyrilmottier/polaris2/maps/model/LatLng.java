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

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

public final class LatLng implements Parcelable {

    public static final Parcelable.Creator<LatLng> CREATOR = new Parcelable.Creator<LatLng>() {
        public LatLng createFromParcel(Parcel in) {
            return new LatLng((com.google.android.gms.maps.model.LatLng) in.readParcelable(null));
        }

        public LatLng[] newArray(int size) {
            return new LatLng[size];
        }
    };

    /**
     * The minimum valid latitude
     */
    @Polaris
    public static final double MIN_LATITUDE = -90d;

    /**
     * The maximum valid latitude
     */
    @Polaris
    public static final double MAX_LATITUDE = 90d;

    /**
     * The minimum valid longitude
     */
    @Polaris
    public static final double MIN_LONGITUDE = -180d;

    /**
     * The maximum valid longitude
     */
    @Polaris
    public static final double MAX_LONGITUDE = getMaxLongitude();

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    private static double getMaxLongitude() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
            return 0x1.67fffffffffffp7;
        }
        return Math.nextAfter(180d, -1d);
    }

    /**
     * <strong>DO NOT USE.</strong>
     * <p/>
     * The original (immutable) LatLng.
     *
     * @hide
     */
    public final com.google.android.gms.maps.model.LatLng mOriginal;

    public final double latitude;
    public final double longitude;

    public LatLng(double latitude, double longitude) {
        this(new com.google.android.gms.maps.model.LatLng(latitude, longitude));
    }

    private LatLng(com.google.android.gms.maps.model.LatLng original) {
        mOriginal = original;
        this.latitude = original.latitude;
        this.longitude = original.longitude;
    }

    /**
     * <strong>DO NOT USE.</strong>
     * <p/>
     * Obtain a new LatLng based an original one.
     *
     * @param original
     * @return
     * @hide
     */
    public static LatLng obtain(com.google.android.gms.maps.model.LatLng original) {
        return new LatLng(original);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LatLng)) {
            return false;
        }
        return mOriginal.equals(((LatLng) other).mOriginal);
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
