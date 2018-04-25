/*
 *
 * File:		Line.java
 * Class:		com.servercurio.figuri.planar.Line
 * Modified:	4/24/18 11:55 PM
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
import com.servercurio.comune.drawing.aware.StrokeAware;
import com.servercurio.comune.util.CompareToBuilder;
import com.servercurio.comune.util.Copyable;
import com.servercurio.comune.util.EqualityBuilder;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public class Line implements Shape, Copyable<Line>, Comparable<Line>, Renderable, ColorAware, StrokeAware {

    private static final long serialVersionUID = -99135311515440002L;

    private Point pointA;
    private Point pointB;

    private Color backgroundColor;
    private Color foregroundColor;
    private Stroke stroke;

    public Line() {
        this(new Point(), new Point());
    }

    public Line(final double xA, final double yA, final double xB, final double yB) {
        this(new Point(xA, yA), new Point(xB, yB));
    }

    public Line(final Point pointA, final Point pointB) {
        if (pointA == null) {
            throw new NullPointerException("pointA");
        }

        if (pointB == null) {
            throw new NullPointerException("pointB");
        }

        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(final Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(final Point pointB) {
        this.pointB = pointB;
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

    @Override
    public Stroke getStroke() {
        return stroke;
    }

    @Override
    public void setStroke(final Stroke stroke) {
        this.stroke = stroke;
    }

    @Override
    public void copyTo(final Line other) {
        if (other == null) {
            return;
        }

        other.pointA = pointA.copy();
        other.pointB = pointB.copy();
    }

    @Override
    public Line copy() {
        return new Line(pointA, pointB);
    }

    @Override
    public boolean contains(final double x, final double y) {
        return new Line2D.Double(pointA.getX(), pointA.getY(), pointB.getX(), pointB.getY()).contains(x, y);
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
        return new Line2D.Double(pointA.getX(), pointA.getY(), pointB.getX(), pointB.getY()).contains(x, y, w, h);
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
        Rectangle2D r = new Line2D.Double(pointA.getX(), pointA.getY(), pointB.getX(), pointB.getY()).getBounds2D();

        return new Rectangle(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    @Override
    public void paint(final Graphics2D g, final BoundingBox bounds) {
        GraphicsState stateMgr = new GraphicsState(g);
        stateMgr.save();
        stateMgr.apply(this);

        Line2D line = new Line2D.Double(pointA.getX(), pointA.getY(), pointB.getX(), pointB.getY());
        g.draw(line);

        stateMgr.restore();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;

        Line line = (Line) o;
        return Objects.equals(line.pointA, pointA) &&
                Objects.equals(line.pointB, pointB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB);
    }

    @Override
    public int compareTo(final Line that) {
        if (this == that) {
            return EqualityBuilder.EQUALITY;
        }

        if (that == null) {
            return EqualityBuilder.GREATER_THAN;
        }

        return new CompareToBuilder()
                .append(that.pointA, pointA)
                .append(that.pointB, pointB)
                .build();
    }
}
