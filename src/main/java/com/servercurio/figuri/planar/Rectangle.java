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
import com.servercurio.figuri.Dimension;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public class Rectangle implements Shape, Comparable<Rectangle>, Copyable<Rectangle> {

    private static final long serialVersionUID = 4815557825521106169L;

    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle() {
        this(0, 0, 0, 0);
    }

    public Rectangle(final double width, final double height) {
        this(0, 0, width, height);
    }

    public Rectangle(final double x, final double y, final double width, final double height) {
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

    public Dimension getSize() {
        return new Dimension(width, height);
    }

    public void setSize(final Dimension dimension) {
        if (dimension == null) {
            throw new NullPointerException("dimension");
        }

        setSize(dimension.getWidth(), dimension.getHeight());
    }

    public void setSize(final double width, final double height) {
        this.width = width;
        this.height = height;
    }

    public Point getLocation() {
        return new Point(x, y);
    }

    public void setLocation(final Point point) {
        if (point == null) {
            throw new NullPointerException("point");
        }

        setLocation(point.getX(), point.getY());
    }

    public void setLocation(final double x, final double y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean contains(final double x, final double y) {
        return new Rectangle2D.Double(this.x, this.y, this.width, this.height).contains(x, y);
    }

    @Override
    public boolean contains(final Point point) {
        if (point == null) {
            throw new NullPointerException("point");
        }

        return contains(point.getX(), point.getY());
    }

    @Override
    public boolean contains(final double x, final double y, final double w, final double h) {
        return new Rectangle2D.Double(this.x, this.y, this.width, this.height).contains(x, y, w, h);
    }

    @Override
    public boolean contains(final Rectangle rectangle) {
        if (rectangle == null) {
            throw new NullPointerException("rectangle");
        }

        return contains(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void copyTo(final Rectangle other) {
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
    public int compareTo(final Rectangle that) {
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
