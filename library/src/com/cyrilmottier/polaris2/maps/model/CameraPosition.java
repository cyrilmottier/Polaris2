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

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;

public final class CameraPosition implements Parcelable {

    public static final Parcelable.Creator<CameraPosition> CREATOR = new Parcelable.Creator<CameraPosition>() {
        public CameraPosition createFromParcel(Parcel in) {
            return new CameraPosition((com.google.android.gms.maps.model.CameraPosition) in.readParcelable(com.google.android.gms.maps.model.CameraPosition.class.getClassLoader()));
        }

        public CameraPosition[] newArray(int size) {
            return new CameraPosition[size];
        }
    };

    /**
     * <strong>DO NOT USE.</strong>
     * <p/>
     * The original (immutable) CameraPosition.
     *
     * @hide
     */
    public final com.google.android.gms.maps.model.CameraPosition mOriginal;

    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    private CameraPosition(com.google.android.gms.maps.model.CameraPosition original) {
        mOriginal = original;

        this.bearing = original.bearing;
        this.target = LatLng.obtain(original.target);
        this.tilt = original.tilt;
        this.zoom = original.zoom;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attrs) {
        return new CameraPosition(com.google.android.gms.maps.model.CameraPosition.createFromAttributes(context, attrs));
    }

    public static CameraPosition fromLatLngZoom(LatLng target, float zoom) {
        return new CameraPosition(com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(target == null ? null : target.mOriginal,
                zoom));
    }

    /**
     * <strong>DO NOT USE.</strong>
     * <p/>
     * Obtain a new CameraPosition based on an original one.
     *
     * @param original The original CameraPosition instance.
     * @return A CameraPosition wrapper instance
     * @hide
     */
    public static CameraPosition obtain(com.google.android.gms.maps.model.CameraPosition original) {
        return new CameraPosition(original);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraPosition)) {
            return false;
        }
        return mOriginal.equals(((CameraPosition) other).mOriginal);
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

    public final static class Builder {

        private com.google.android.gms.maps.model.CameraPosition.Builder mOriginal;

        public Builder() {
            this(new com.google.android.gms.maps.model.CameraPosition.Builder());
        }

        public Builder(CameraPosition previous) {
            this(new com.google.android.gms.maps.model.CameraPosition.Builder(previous == null ? null : previous.mOriginal));
        }

        private Builder(com.google.android.gms.maps.model.CameraPosition.Builder original) {
            mOriginal = original;
        }

        public Builder bearing(float bearing) {
            mOriginal.bearing(bearing);
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(mOriginal.build());
        }

        public Builder target(LatLng location) {
            mOriginal.target(location == null ? null : location.mOriginal);
            return this;
        }

        public Builder tilt(float tilt) {
            mOriginal.tilt(tilt);
            return this;
        }

        public Builder zoom(float zoom) {
            mOriginal.zoom(zoom);
            return this;
        }
    }

}
