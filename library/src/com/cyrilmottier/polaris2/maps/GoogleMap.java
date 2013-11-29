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

import com.cyrilmottier.polaris2.maps.model.CameraPosition;
import com.cyrilmottier.polaris2.maps.model.Circle;
import com.cyrilmottier.polaris2.maps.model.CircleOptions;
import com.cyrilmottier.polaris2.maps.model.GroundOverlay;
import com.cyrilmottier.polaris2.maps.model.GroundOverlayOptions;
import com.cyrilmottier.polaris2.maps.model.LatLng;
import com.cyrilmottier.polaris2.maps.model.Marker;
import com.cyrilmottier.polaris2.maps.model.MarkerOptions;
import com.cyrilmottier.polaris2.maps.model.Polygon;
import com.cyrilmottier.polaris2.maps.model.PolygonOptions;
import com.cyrilmottier.polaris2.maps.model.Polyline;
import com.cyrilmottier.polaris2.maps.model.PolylineOptions;
import com.cyrilmottier.polaris2.maps.model.TileOverlay;
import com.cyrilmottier.polaris2.maps.model.TileOverlayOptions;

import android.location.Location;
import android.view.View;

public final class GoogleMap {

    public static final int MAP_TYPE_HYBRID = com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID;
    public static final int MAP_TYPE_NONE = com.google.android.gms.maps.GoogleMap.MAP_TYPE_NONE;
    public static final int MAP_TYPE_NORMAL = com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL;
    public static final int MAP_TYPE_SATELLITE = com.google.android.gms.maps.GoogleMap.MAP_TYPE_SATELLITE;
    public static final int MAP_TYPE_TERRAIN = com.google.android.gms.maps.GoogleMap.MAP_TYPE_TERRAIN;

    public interface CancelableCallback {
        void onFinish();

        void onCancel();
    }

    public interface InfoWindowAdapter {
        View getInfoWindow(Marker paramMarker);

        View getInfoContents(Marker paramMarker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition position);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker paramMarker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng paramLatLng);
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng paramLatLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker paramMarker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDragStart(Marker paramMarker);

        void onMarkerDrag(Marker paramMarker);

        void onMarkerDragEnd(Marker paramMarker);
    }

    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location paramLocation);
    }

    final com.google.android.gms.maps.GoogleMap mOriginal;

    GoogleMap(com.google.android.gms.maps.GoogleMap original) {
        mOriginal = original;
    }

    public final Circle addCircle(CircleOptions options) {
        final com.google.android.gms.maps.model.Circle original = mOriginal.addCircle(options.mOriginal);
        return original == null ? null : Circle.obtain(original);
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        final com.google.android.gms.maps.model.GroundOverlay original = mOriginal.addGroundOverlay(options.mOriginal);
        return original == null ? null : GroundOverlay.obtain(original);
    }

    public Marker addMarker(MarkerOptions options) {
        final com.google.android.gms.maps.model.Marker original = mOriginal.addMarker(options.mOriginal);
        return original == null ? null : Marker.obtain(original);
    }

    public final Polygon addPolygon(PolygonOptions options) {
        final com.google.android.gms.maps.model.Polygon original = mOriginal.addPolygon(options.mOriginal);
        return original == null ? null : Polygon.obtain(original);
    }

    public final Polyline addPolyline(PolylineOptions options) {
        final com.google.android.gms.maps.model.Polyline original = mOriginal.addPolyline(options.mOriginal);
        return original == null ? null : Polyline.obtain(original);
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        final com.google.android.gms.maps.model.TileOverlay original = mOriginal.addTileOverlay(options.mOriginal);
        return original == null ? null : TileOverlay.obtain(original);
    }

    public void animateCamera(CameraUpdate update) {
        mOriginal.animateCamera(update.mOriginal);
    }

    public void animateCamera(CameraUpdate update, CancelableCallback callback) {
        final CancelableCallback fCallback = callback;
        mOriginal.animateCamera(update.mOriginal, callback == null ? null : new com.google.android.gms.maps.GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {
                fCallback.onFinish();
            }

            @Override
            public void onCancel() {
                fCallback.onCancel();
            }
        });
    }

    public void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        final CancelableCallback fCallback = callback;
        mOriginal.animateCamera(update.mOriginal, durationMs,
                callback == null ? null : new com.google.android.gms.maps.GoogleMap.CancelableCallback() {
                    @Override
                    public void onFinish() {
                        fCallback.onFinish();
                    }

                    @Override
                    public void onCancel() {
                        fCallback.onCancel();
                    }
                });
    }

    public void clear() {
        mOriginal.clear();
    }

    public CameraPosition getCameraPosition() {
        final com.google.android.gms.maps.model.CameraPosition original = mOriginal.getCameraPosition();
        return original == null ? null : CameraPosition.obtain(original);
    }

    public int getMapType() {
        return mOriginal.getMapType();
    }

    public float getMaxZoomLevel() {
        return mOriginal.getMaxZoomLevel();
    }

    public float getMinZoomLevel() {
        return mOriginal.getMinZoomLevel();
    }

    public Location getMyLocation() {
        return mOriginal.getMyLocation();
    }

    public Projection getProjection() {
        final com.google.android.gms.maps.Projection original = mOriginal.getProjection();
        return original == null ? null : new Projection(original);
    }

    public UiSettings getUiSettings() {
        final com.google.android.gms.maps.UiSettings original = mOriginal.getUiSettings();
        return original == null ? null : new UiSettings(original);
    }

    public boolean isIndoorEnabled() {
        return mOriginal.isIndoorEnabled();
    }

    public boolean isMyLocationEnabled() {
        return mOriginal.isMyLocationEnabled();
    }

    public boolean isTrafficEnabled() {
        return mOriginal.isTrafficEnabled();
    }

    public void moveCamera(CameraUpdate update) {
        mOriginal.moveCamera(update.mOriginal);
    }

    public boolean setIndoorEnabled(boolean enabled) {
        return mOriginal.setIndoorEnabled(enabled);
    }

    public void setLocationSource(LocationSource source) {
        final LocationSource fSource = source;
        mOriginal.setLocationSource(fSource == null ? null : new com.google.android.gms.maps.LocationSource() {
            @Override
            public void activate(final com.google.android.gms.maps.LocationSource.OnLocationChangedListener listener) {
                fSource.activate(new com.cyrilmottier.polaris2.maps.LocationSource.OnLocationChangedListener() {
                    @Override
                    public void onLocationChanged(final Location location) {
                        listener.onLocationChanged(location);
                    }
                });
            }

            @Override
            public void deactivate() {
                fSource.deactivate();
            }
        });
    }

    public void setMapType(int type) {
        mOriginal.setMapType(type);
    }

    public void setMyLocationEnabled(boolean enabled) {
        mOriginal.setMyLocationEnabled(enabled);
    }

    public void setOnCameraChangeListener(OnCameraChangeListener listener) {
        final OnCameraChangeListener fListener = listener;
        mOriginal.setOnCameraChangeListener(fListener == null ? null : new com.google.android.gms.maps.GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(com.google.android.gms.maps.model.CameraPosition position) {
                fListener.onCameraChange(CameraPosition.obtain(position));
            }
        });
    }

    public void setOnMapClickListener(OnMapClickListener listener) {
        final OnMapClickListener fListener = listener;
        mOriginal.setOnMapClickListener(fListener == null ? null : new com.google.android.gms.maps.GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(com.google.android.gms.maps.model.LatLng point) {
                fListener.onMapClick(LatLng.obtain(point));
            }
        });
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener listener) {
        final OnMapLongClickListener fListener = listener;
        mOriginal.setOnMapLongClickListener(fListener == null ? null : new com.google.android.gms.maps.GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(com.google.android.gms.maps.model.LatLng point) {
                fListener.onMapLongClick(LatLng.obtain(point));
            }
        });
    }

    public void setOnMarkerClickListener(OnMarkerClickListener listener) {
        final OnMarkerClickListener fListener = listener;
        mOriginal.setOnMarkerClickListener(fListener == null ? null : new com.google.android.gms.maps.GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker) {
                return fListener.onMarkerClick(Marker.obtain(marker));
            }
        });
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter adapter) {
        final InfoWindowAdapter fAdapter = adapter;
        mOriginal.setInfoWindowAdapter(fAdapter == null ? null : new com.google.android.gms.maps.GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(com.google.android.gms.maps.model.Marker marker) {
                return fAdapter.getInfoWindow(Marker.obtain(marker));
            }

            @Override
            public View getInfoContents(com.google.android.gms.maps.model.Marker marker) {
                return fAdapter.getInfoContents(Marker.obtain(marker));
            }
        });
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener listener) {
        final OnInfoWindowClickListener fListener = listener;
        mOriginal.setOnInfoWindowClickListener(
                fListener == null ? null : new com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(com.google.android.gms.maps.model.Marker marker) {
                        fListener.onInfoWindowClick(Marker.obtain(marker));
                    }
                });
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener listener) {
        final OnMarkerDragListener fListener = listener;
        mOriginal.setOnMarkerDragListener(fListener == null ? null : new com.google.android.gms.maps.GoogleMap.OnMarkerDragListener() {

            @Override
            public void onMarkerDrag(com.google.android.gms.maps.model.Marker marker) {
                fListener.onMarkerDrag(Marker.obtain(marker));
            }

            @Override
            public void onMarkerDragEnd(com.google.android.gms.maps.model.Marker marker) {
                fListener.onMarkerDragEnd(Marker.obtain(marker));
            }

            @Override
            public void onMarkerDragStart(com.google.android.gms.maps.model.Marker marker) {
                fListener.onMarkerDragStart(Marker.obtain(marker));
            }
        });
    }


    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener listener) {
        final OnMyLocationChangeListener fListener = listener;
        mOriginal.setOnMyLocationChangeListener(
                fListener == null ? null : new com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener() {
                    @Override
                    public void onMyLocationChange(Location location) {
                        fListener.onMyLocationChange(location);
                    }
                });
    }

    public void setTrafficEnabled(boolean enabled) {
        mOriginal.setTrafficEnabled(enabled);
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        mOriginal.setPadding(left ,top ,right ,bottom);
            
    }
    
    public void stopAnimation() {
        mOriginal.stopAnimation();
    }

}
