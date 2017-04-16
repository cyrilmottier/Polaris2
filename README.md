Polaris v2
==========

Polaris is a framework enhancing the Google Maps Android API v2. It aims to fix some of the most frustrating bugs of the original library and provide additional features.

Polaris v2 has been released as a pretty basic library wrapping the original Google Maps Android API v2. Releasing and open-sourcing this code is an attempt to let the community contribute to it and enhance it with some awesome new features and fixes.

Features
--------

Here are the current additions to Google Maps Android API v2 included in Polaris v2:

  * Add a `reset()` methods to all of the 'Options' classes: `CircleOptions`, `GoogleMapOptions`, `GroundOverlayOptions`, `MarkerOptions`, `PolygonOptions`, `PolylinesOptions`, `TileOverlayOptions`
  * Add of new constants `MIN_LATITUDE`, `MAX_LATITUDE`, `MIN_LONGITUDE` and `MAX_LONGITUDE` in `LatLng` respectively defining the minimum/maximum valid latitude and the minimum/maximum longitude
  * Add of a new constant `EARTH_BOUNDS` in `LatLngBounds` defining the bounds of the entire Earth globe
  * Add of a `getPolarisMap()` method in `MapView`, `MapFragment` and `MapSupportFragment`

Limitations
-----------
Polaris offers a super-set of the APIs from Google Maps Android v2. In other words, you can do exactly the same (or more) things you already do with Google Maps Android v2.

Polaris v2 makes extensive use of the encapsulation paradigm by wrapping/unwrapping original Google Maps objects into Polaris objects. Quite obviously, boxing/unboxing results in the creation of several additional objects that may slightly reduce the performance of your application by forcing the garbage collector to cleanup the wrapper objects.

While enhancing the Google Maps Android v2 with some new fiels/methods and classes annotated with `@Polaris`, Polaris tries to keep the API as close to the original as possible. However, you may have access to some methods/fields you shouldn't use:

  * Public final field called `mOriginal`
  * Public static factory method called `obtain(T original)` 

Usage
-----

  1. Switch all of the imports from Google Maps Android API v2 to Polaris v2. In other words, replace `com.google.android.gms.maps.*` by `com.cyrilmottier.polaris2.maps.*`

  2. Use `getPolarisMap()`instead of `getMap()`to retrieve an instance of `GoogleMap`

         mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                     .getPolarisMap();

### Including Polaris v2 in your project

Polaris v2 is presented as an [Android library project](http://developer.android.com/guide/developing/projects/projects-eclipse.html). You can include it by [referencing it as a library project](http://developer.android.com/guide/developing/projects/projects-eclipse.html#ReferencingLibraryProject) in Eclipse, IntelliJ or ant.

### Building the sample application

Using the Google Maps Android API v2 requires you to register a signing key to Google. When doing so, Google generates an API key you must add to the Android manifest. For obvious reasons, you must keep these keys private.

Logically, the sample application doesn't include API keys. In order to run the project correctly you must change the appropriate `meta-data` in the `AndroidManifest.xml`:

	<meta-data
	    android:name="com.google.android.maps.v2.API_KEY"
	    android:value="your_key_here" />


Developed By
------------

Cyril Mottier - <cyril@cyrilmottier.com>

License
-------

	Copyright (C) 2013 Cyril Mottier (http://www.cyrilmottier.com)
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	     http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.