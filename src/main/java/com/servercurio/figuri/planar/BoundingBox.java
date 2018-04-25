/*
 *
 * File:		BoundingBox.java
 * Class:		com.servercurio.figuri.planar.BoundingBox
 * Modified:	4/25/18 12:20 AM
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

package com.servercurio.figuri.planar;

import com.servercurio.comune.util.CompareToBuilder;
import com.servercurio.comune.util.Copyable;
import com.servercurio.comune.util.EqualityBuilder;

import java.io.Serializable;
import java.util.Objects;

public class BoundingBox implements Serializable, Comparable<BoundingBox>, Copyable<BoundingBox> {

    private static final long serialVersionUID = 26435899460335490L;

    private double x;
    private double y;
    private double width;
    private double height;

    public BoundingBox() {
        this(0, 0, 0, 0);
    }

    public BoundingBox(final double width, final double height) {
        this(0, 0, width, height);
    }

    public BoundingBox(final double x, final double y, final double width, final double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(final double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(final double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(final double height) {
        this.height = height;
    }

    @Override
    public BoundingBox copy() {
        return new BoundingBox(x, y, width, height);
    }

    @Override
    public void copyTo(final BoundingBox other) {
        if (other == null) {
            return;
        }

        other.x = x;
        other.y = y;
        other.width = width;
        other.height = height;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BoundingBox)) return false;

        BoundingBox that = (BoundingBox) o;
        return Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0 &&
                Double.compare(that.width, width) == 0 &&
                Double.compare(that.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height);
    }

    @Override
    public int compareTo(final BoundingBox that) {
        if (this == that) return EqualityBuilder.EQUALITY;
        if (that == null) return EqualityBuilder.GREATER_THAN;

        return new CompareToBuilder()
                .append(that.x, x)
                .append(that.y, y)
                .append(that.width, width)
                .append(that.height, height)
                .build();
    }
}
