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

public final class TileOverlayOptions implements Parcelable {

    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new Parcelable.Creator<TileOverlayOptions>() {
        public TileOverlayOptions createFromParcel(Parcel in) {
            return new TileOverlayOptions((com.google.android.gms.maps.model.TileOverlayOptions) in.readParcelable(null));
        }

        public TileOverlayOptions[] newArray(int size) {
            return new TileOverlayOptions[size];
        }
    };

    /**
     * DO NOT USE (for internal use only). The original TileOverlayOptions.
     *
     * @hide
     */
    public final com.google.android.gms.maps.model.TileOverlayOptions mOriginal;

    private TileProvider mTileProvider;
    private TileOverlayOptions mDefaultOptions;

    public TileOverlayOptions() {
        this(new com.google.android.gms.maps.model.TileOverlayOptions());
    }

    TileOverlayOptions(com.google.android.gms.maps.model.TileOverlayOptions original) {
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

    public TileProvider getTileProvider() {
        return mTileProvider;
    }

    public float getZIndex() {
        return mOriginal.getZIndex();
    }

    public boolean isVisible() {
        return mOriginal.isVisible();
    }

    /**
     * Reset the TileOverlayOptions by setting all of its properties to their default values.
     */
    @Polaris
    public void reset() {
        if (mDefaultOptions == null) {
            mDefaultOptions = new TileOverlayOptions();
        }
        tileProvider(mDefaultOptions.getTileProvider());
        visible(mDefaultOptions.isVisible());
        zIndex(mDefaultOptions.getZIndex());
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        mTileProvider = tileProvider;

        final TileProvider fTileProvider = tileProvider;
        mOriginal.tileProvider(fTileProvider == null ? null : new com.google.android.gms.maps.model.TileProvider() {
            @Override
            public com.google.android.gms.maps.model.Tile getTile(int x, int y, int zoom) {
                return fTileProvider.getTile(x, y, zoom).mOriginal;
            }
        });

        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        mOriginal.visible(visible);
        return this;
    }

    public TileOverlayOptions zIndex(float zIndex) {
        mOriginal.zIndex(zIndex);
        return this;
    }

}
