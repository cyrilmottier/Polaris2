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

import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {

    final com.google.android.gms.maps.model.UrlTileProvider mOriginal;

    public UrlTileProvider(int width, int height) {
        mOriginal = new com.google.android.gms.maps.model.UrlTileProvider(width, height) {
            @Override
            public URL getTileUrl(int x, int y, int zoom) {
                return innerGetTileUrl(x, y, zoom);
            }

            private URL innerGetTileUrl(int x, int y, int zoom) {
                return getTileUrl(x, y, zoom);
            }
        };
    }

    @Override
    public final Tile getTile(int x, int y, int zoom) {
        return new Tile(mOriginal.getTile(x, y, zoom));
    }

    public abstract URL getTileUrl(int x, int y, int zoom);

}
