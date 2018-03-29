/*
 *
 * File:		EqualityBuilder.java
 * Class:		com.servercurio.comune.util.EqualityBuilder
 * Modified:	3/28/18 11:48 PM
 *
 * Copyright 2018 Server Curio
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.servercurio.comune.util;

import java.util.Comparator;

public interface EqualityBuilder<T, B extends Builder<T>> extends Builder<T> {

    int LESS_THAN = -1;
    int EQUALITY = 0;
    int GREATER_THAN = 1;

    B append(final boolean lhs, final boolean rhs);

    B append(final boolean[] lhs, final boolean[] rhs);

    B append(final char lhs, final char rhs);

    B append(final char[] lhs, final char[] rhs);

    B append(final byte lhs, final byte rhs);

    B append(final byte[] lhs, final byte[] rhs);

    B append(final short lhs, final short rhs);

    B append(final short[] lhs, final short[] rhs);

    B append(final int lhs, final int rhs);

    B append(final int[] lhs, final int[] rhs);

    B append(final long lhs, final long rhs);

    B append(final long[] lhs, final long[] rhs);

    B append(final float lhs, final float rhs);

    B append(final float[] lhs, final float[] rhs);

    B append(final double lhs, final double rhs);

    B append(final double[] lhs, final double[] rhs);

    B append(final Object lhs, final Object rhs);

    B append(final Object lhs, final Object rhs, final Comparator<?> comparator);

    B append(final Object[] lhs, final Object[] rhs);

    B append(final Object[] lhs, final Object[] rhs, Comparator<?> comparator);

}
