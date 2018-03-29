/*
 *
 * File:		Rectangle.java
 * Class:		com.servercurio.figuri.planar.Rectangle
 * Modified:	3/29/18 12:43 AM
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

public class Rectangle implements Serializable, Comparable<Rectangle>, Copyable<Rectangle> {

    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle() {
        this(0, 0, 0, 0);
    }

    public Rectangle(double width, double height) {
        this(0, 0, width, height);
    }

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public void copyTo(Rectangle other) {
        if (other == null) {
            return;
        }

        other.x = x;
        other.y = y;
        other.width = width;
        other.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;

        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.x, x) == 0 &&
                Double.compare(rectangle.y, y) == 0 &&
                Double.compare(rectangle.width, width) == 0 &&
                Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height);
    }

    @Override
    public int compareTo(Rectangle that) {
        if (this == that) {
            return EqualityBuilder.EQUALITY;
        }

        if (that == null) {
            return EqualityBuilder.GREATER_THAN;
        }

        return new CompareToBuilder()
                .append(that.x, x)
                .append(that.y, y)
                .append(that.width, width)
                .append(that.height, height)
                .build();
    }
}
