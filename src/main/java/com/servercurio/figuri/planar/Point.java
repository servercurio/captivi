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

import com.servercurio.comune.drawing.GraphicsState;
import com.servercurio.comune.drawing.Renderable;
import com.servercurio.comune.drawing.aware.ColorAware;
import com.servercurio.comune.util.CompareToBuilder;
import com.servercurio.comune.util.Copyable;
import com.servercurio.comune.util.EqualityBuilder;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public class Point implements Shape, Comparable<Point>, Copyable<Point>, Renderable, ColorAware {

    private static final long serialVersionUID = 1457811866258607528L;

    private double x;
    private double y;

    private Color backgroundColor;
    private Color foregroundColor;

    public Point() {
    }

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
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

    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(final Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public Color getForegroundColor() {
        return foregroundColor;
    }

    @Override
    public void setForegroundColor(final Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public double distance(Point point) {
        if (point == null) {
            throw new NullPointerException("point");
        }

        return new Point2D.Double(this.x, this.y).distance(point.getX(), point.getY());
    }

    public double distanceSquare(Point point) {
        if (point == null) {
            throw new NullPointerException("point");
        }

        return new Point2D.Double(this.x, this.y).distanceSq(point.getX(), point.getY());
    }

    @Override
    public boolean contains(final double x, final double y) {
        return false;
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
        return false;
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
        return new Rectangle(x, y, 1, 1);
    }

    @Override
    public void paint(final Graphics2D g, final BoundingBox bounds) {
        GraphicsState stateMgr = new GraphicsState(g);
        stateMgr.save();
        stateMgr.apply(this);

        Line2D line = new Line2D.Double(x, y, x, y);
        g.draw(line);

        stateMgr.restore();
    }

    @Override
    public void copyTo(final Point other) {
        if (other == null) {
            return;
        }

        other.x = x;
        other.y = y;
    }

    @Override
    public Point copy() {
        return new Point(x, y);
    }

    @Override
    public boolean equals(final Object o) {
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
    public int compareTo(final Point that) {
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
