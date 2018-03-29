/*
 *
 * File:		CompareToBuilder.java
 * Class:		com.servercurio.comune.lang.CompareToBuilder
 * Modified:	3/28/18 11:17 PM
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
import java.util.Objects;

public class CompareToBuilder implements EqualityBuilder<Integer, CompareToBuilder> {

    private int comparison;

    public CompareToBuilder() {
        super();
        comparison = EQUALITY;
    }

    public CompareToBuilder appendSuper(final int superComparison) {
        if (comparison != EQUALITY) {
            return this;
        }

        comparison = superComparison;
        return this;
    }

    @Override
    public CompareToBuilder append(final boolean lhs, final boolean rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        comparison = Boolean.compare(lhs, rhs);
        return this;
    }

    @Override
    public CompareToBuilder append(final boolean[] lhs, final boolean[] rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        if (lhs == null) {
            comparison = LESS_THAN;
            return this;
        }

        if (rhs == null) {
            comparison = GREATER_THAN;
            return this;
        }

        if (lhs.length != rhs.length) {
            comparison = Integer.compare(lhs.length, rhs.length);
            return this;
        }

        for (int i = 0; i < lhs.length && comparison == 0; i++) {
            append(lhs[i], rhs[i]);
        }

        return this;
    }

    @Override
    public CompareToBuilder append(final char lhs, final char rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        comparison = Character.compare(lhs, rhs);
        return this;
    }

    @Override
    public CompareToBuilder append(final char[] lhs, final char[] rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        if (lhs == null) {
            comparison = LESS_THAN;
            return this;
        }

        if (rhs == null) {
            comparison = GREATER_THAN;
            return this;
        }

        if (lhs.length != rhs.length) {
            comparison = Integer.compare(lhs.length, rhs.length);
            return this;
        }

        for (int i = 0; i < lhs.length && comparison == 0; i++) {
            append(lhs[i], rhs[i]);
        }

        return this;
    }

    @Override
    public CompareToBuilder append(final byte lhs, final byte rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        comparison = Byte.compare(lhs, rhs);
        return this;
    }

    @Override
    public CompareToBuilder append(final byte[] lhs, final byte[] rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        if (lhs == null) {
            comparison = LESS_THAN;
            return this;
        }

        if (rhs == null) {
            comparison = GREATER_THAN;
            return this;
        }

        if (lhs.length != rhs.length) {
            comparison = Integer.compare(lhs.length, rhs.length);
            return this;
        }

        for (int i = 0; i < lhs.length && comparison == 0; i++) {
            append(lhs[i], rhs[i]);
        }

        return this;
    }

    @Override
    public CompareToBuilder append(final short lhs, final short rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        comparison = Short.compare(lhs, rhs);
        return this;
    }

    @Override
    public CompareToBuilder append(final short[] lhs, final short[] rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        if (lhs == null) {
            comparison = LESS_THAN;
            return this;
        }

        if (rhs == null) {
            comparison = GREATER_THAN;
            return this;
        }

        if (lhs.length != rhs.length) {
            comparison = Integer.compare(lhs.length, rhs.length);
            return this;
        }

        for (int i = 0; i < lhs.length && comparison == 0; i++) {
            append(lhs[i], rhs[i]);
        }

        return this;
    }

    @Override
    public CompareToBuilder append(final int lhs, final int rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        comparison = Integer.compare(lhs, rhs);
        return this;
    }

    @Override
    public CompareToBuilder append(final int[] lhs, final int[] rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        if (lhs == null) {
            comparison = LESS_THAN;
            return this;
        }

        if (rhs == null) {
            comparison = GREATER_THAN;
            return this;
        }

        if (lhs.length != rhs.length) {
            comparison = Integer.compare(lhs.length, rhs.length);
            return this;
        }

        for (int i = 0; i < lhs.length && comparison == 0; i++) {
            append(lhs[i], rhs[i]);
        }

        return this;
    }

    @Override
    public CompareToBuilder append(final long lhs, final long rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        comparison = Long.compare(lhs, rhs);
        return this;
    }

    @Override
    public CompareToBuilder append(final long[] lhs, final long[] rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        if (lhs == null) {
            comparison = LESS_THAN;
            return this;
        }

        if (rhs == null) {
            comparison = GREATER_THAN;
            return this;
        }

        if (lhs.length != rhs.length) {
            comparison = Integer.compare(lhs.length, rhs.length);
            return this;
        }

        for (int i = 0; i < lhs.length && comparison == 0; i++) {
            append(lhs[i], rhs[i]);
        }

        return this;
    }

    @Override
    public CompareToBuilder append(final float lhs, final float rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        comparison = Float.compare(lhs, rhs);
        return this;
    }

    @Override
    public CompareToBuilder append(final float[] lhs, final float[] rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        if (lhs == null) {
            comparison = LESS_THAN;
            return this;
        }

        if (rhs == null) {
            comparison = GREATER_THAN;
            return this;
        }

        if (lhs.length != rhs.length) {
            comparison = Integer.compare(lhs.length, rhs.length);
            return this;
        }

        for (int i = 0; i < lhs.length && comparison == 0; i++) {
            append(lhs[i], rhs[i]);
        }

        return this;
    }

    @Override
    public CompareToBuilder append(final double lhs, final double rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        comparison = Double.compare(lhs, rhs);
        return this;
    }

    @Override
    public CompareToBuilder append(final double[] lhs, final double[] rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        if (lhs == null) {
            comparison = LESS_THAN;
            return this;
        }

        if (rhs == null) {
            comparison = GREATER_THAN;
            return this;
        }

        if (lhs.length != rhs.length) {
            comparison = Integer.compare(lhs.length, rhs.length);
            return this;
        }

        for (int i = 0; i < lhs.length && comparison == 0; i++) {
            append(lhs[i], rhs[i]);
        }

        return this;
    }

    @Override
    public CompareToBuilder append(final Object lhs, final Object rhs) {
        return append(lhs, rhs, null);
    }

    @Override
    public CompareToBuilder append(final Object lhs, final Object rhs, final Comparator<?> comparator) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        if (lhs == null) {
            comparison = LESS_THAN;
            return this;
        }

        if (rhs == null) {
            comparison = GREATER_THAN;
            return this;
        }

        if (lhs.getClass().isArray()) {
            appendArray(lhs, rhs, comparator);
        } else {
            if (comparator == null) {
                @SuppressWarnings("unchecked") final Comparable<Object> comparable = (Comparable<Object>) lhs;
                comparison = comparable.compareTo(rhs);
            } else {
                @SuppressWarnings("unchecked") final Comparator<Object> typedComparator = (Comparator<Object>) comparator;
                comparison = Objects.compare(lhs, rhs, typedComparator);
            }
        }

        return this;
    }

    @Override
    public CompareToBuilder append(final Object[] lhs, final Object[] rhs) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        if (lhs == null) {
            comparison = LESS_THAN;
            return this;
        }

        if (rhs == null) {
            comparison = GREATER_THAN;
            return this;
        }

        if (lhs.length != rhs.length) {
            comparison = Integer.compare(lhs.length, rhs.length);
            return this;
        }

        for (int i = 0; i < lhs.length && comparison == 0; i++) {
            append(lhs[i], rhs[i]);
        }

        return this;
    }

    @Override
    public CompareToBuilder append(final Object[] lhs, final Object[] rhs, final Comparator<?> comparator) {
        if (comparison != EQUALITY) {
            return this;
        }

        if (lhs == rhs) {
            return this;
        }

        if (lhs == null) {
            comparison = LESS_THAN;
            return this;
        }

        if (rhs == null) {
            comparison = GREATER_THAN;
            return this;
        }

        if (lhs.length != rhs.length) {
            comparison = Integer.compare(lhs.length, rhs.length);
            return this;
        }

        for (int i = 0; i < lhs.length && comparison == 0; i++) {
            append(lhs[i], rhs[i], comparator);
        }

        return this;
    }

    @Override
    public Integer build() {
        return comparison;
    }

    private void appendArray(final Object lhs, final Object rhs, final Comparator<?> comparator) {
        if (lhs instanceof long[]) {
            append((long[]) lhs, (long[]) rhs);
        } else if (lhs instanceof int[]) {
            append((int[]) lhs, (int[]) rhs);
        } else if (lhs instanceof short[]) {
            append((short[]) lhs, (short[]) rhs);
        } else if (lhs instanceof char[]) {
            append((char[]) lhs, (char[]) rhs);
        } else if (lhs instanceof byte[]) {
            append((byte[]) lhs, (byte[]) rhs);
        } else if (lhs instanceof double[]) {
            append((double[]) lhs, (double[]) rhs);
        } else if (lhs instanceof float[]) {
            append((float[]) lhs, (float[]) rhs);
        } else if (lhs instanceof boolean[]) {
            append((boolean[]) lhs, (boolean[]) rhs);
        } else {
            append((Object[]) lhs, (Object[]) rhs, comparator);
        }
    }
}
