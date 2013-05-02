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

import android.graphics.Bitmap;

public final class BitmapDescriptorFactory {

    public static final float HUE_AZURE = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_AZURE;
    public static final float HUE_BLUE = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_BLUE;
    public static final float HUE_CYAN = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_CYAN;
    public static final float HUE_GREEN = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_GREEN;
    public static final float HUE_MAGENTA = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_MAGENTA;
    public static final float HUE_ORANGE = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_ORANGE;
    public static final float HUE_RED = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_RED;
    public static final float HUE_ROSE = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_ROSE;
    public static final float HUE_VIOLET = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_VIOLET;
    public static final float HUE_YELLOW = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_YELLOW;

    private BitmapDescriptorFactory() {
        // No instance
    }

    public static BitmapDescriptor defaultMarker() {
        return new BitmapDescriptor(com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker());
    }

    public static BitmapDescriptor defaultMarker(float hue) {
        return new BitmapDescriptor(com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker(hue));
    }

    public static BitmapDescriptor fromAsset(String assetName) {
        return new BitmapDescriptor(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(assetName));
    }

    public static BitmapDescriptor fromBitmap(Bitmap image) {
        return new BitmapDescriptor(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(image));
    }

    public static BitmapDescriptor fromFile(String fileName) {
        return new BitmapDescriptor(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromFile(fileName));
    }

    public static BitmapDescriptor fromPath(String absolutePath) {
        return new BitmapDescriptor(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromPath(absolutePath));
    }

    public static BitmapDescriptor fromResource(int resourceId) {
        return new BitmapDescriptor(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource(resourceId));
    }

}
