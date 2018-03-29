/*
 *
 * File:		Point.java
 * Class:		com.servercurio.figuri.planar.Point
 * Modified:	3/29/18 12:36 AM
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

public class Point implements Serializable, Comparable<Point>, Copyable<Point> {

    private static final long serialVersionUID = 1457811866258607528L;

    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void copyTo(Point other) {
        if (other == null) {
            return;
        }

        other.x = x;
        other.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point that) {
        if (this == that) {
            return EqualityBuilder.EQUALITY;
        }

        if (that == null) {
            return EqualityBuilder.GREATER_THAN;
        }

        return new CompareToBuilder()
                .append(that.x, x)
                .append(that.y, y)
                .build();
    }
}
