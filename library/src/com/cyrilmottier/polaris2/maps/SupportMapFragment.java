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
package com.cyrilmottier.polaris2.maps;

import android.os.Bundle;

public class SupportMapFragment extends com.google.android.gms.maps.SupportMapFragment {

    // HACK Cyril: I'm using a hack here because the following String is
    // supposed to be private and may be changed in the future. The only
    // solution to overcome the problem would be to create a SupportMapFragment
    // wrap scratch instead of extending the original one. It would also let use
    // getMap() directly instead of getPolarisMap().
    private static final String ARGS_OPTIONS = "MapOptions";

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions options) {
        final SupportMapFragment f = new SupportMapFragment();

        final Bundle args = new Bundle();
        args.putParcelable(ARGS_OPTIONS, options);
        f.setArguments(args);

        return f;
    }

    /**
     * Gets the underlying GoogleMap that is tied to the view wrapped by this fragment.
     *
     * @return the underlying GoogleMap. Null if the view of the fragment is not yet ready. This can happen if the fragment lifecyle have
     *         not gone through {@link #onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)} yet. This can
     *         also happen if Google Play services is not available. If Google Play services becomes available afterwards and the fragment
     *         have gone through {@link #onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)} , calling
     *         this method again will initialize and return the GoogleMap.
     */
    @Polaris
    public GoogleMap getPolarisMap() {
        final com.google.android.gms.maps.GoogleMap googleMap = getMap();
        return googleMap == null ? null : new GoogleMap(googleMap);
    }

}
