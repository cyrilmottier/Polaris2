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

public final class Tile implements Parcelable {

    public static final Parcelable.Creator<Tile> CREATOR = new Parcelable.Creator<Tile>() {
        public Tile createFromParcel(Parcel in) {
            return new Tile((com.google.android.gms.maps.model.Tile) in.readParcelable(com.google.android.gms.maps.model.Tile.class.getClassLoader()));
        }

        public Tile[] newArray(int size) {
            return new Tile[size];
        }
    };

    public final int width;
    public final int height;
    public final byte[] data;

    final com.google.android.gms.maps.model.Tile mOriginal;

    public Tile(int width, int height, byte[] data) {
        this(new com.google.android.gms.maps.model.Tile(width, height, data));
    }

    Tile(com.google.android.gms.maps.model.Tile original) {
        mOriginal = original;

        this.width = original.width;
        this.height = original.height;
        this.data = original.data;
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
