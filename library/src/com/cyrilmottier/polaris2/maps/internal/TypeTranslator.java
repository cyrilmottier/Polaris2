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
package com.cyrilmottier.polaris2.maps.internal;

/**
 * A TypeTranslator can be used to "translate" an object from one type to another
 *
 * @param <O> The type of the internal object i.e. the hidden type
 * @param <N> The type returned by the methods of the API i.e. the exposed type
 * @author Cyril Mottier
 */
interface TypeTranslator<O, N> {

    O unwrap(N wrapper);

    N wrap(O original);
}
