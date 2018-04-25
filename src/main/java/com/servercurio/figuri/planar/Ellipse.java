/*
 *
 * File:		Ellipse.java
 * Class:		com.servercurio.figuri.planar.Ellipse
 * Modified:	4/3/18 6:50 PM
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

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ellipse extends Rectangle {

    private static final long serialVersionUID = -7892652994176565961L;

    public Ellipse() {
    }

    public Ellipse(final double width, final double height) {
        super(width, height);
    }

    public Ellipse(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
    }

    @Override
    public boolean contains(final double x, final double y) {
        return new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight()).contains(x, y);
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
        return new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight()).contains(x, y, w, h);
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
        Rectangle2D r = new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight()).getBounds2D();

        return new Rectangle(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    @Override
    public Rectangle copy() {
        return new Ellipse(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void paint(final Graphics2D g, final BoundingBox bounds) {
        GraphicsState stateMgr = new GraphicsState(g);
        stateMgr.save();
        stateMgr.apply(this);

        Ellipse2D ellipse = new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight());

        if (isFilled()) {
            g.fill(ellipse);
        } else {
            g.draw(ellipse);
        }

        stateMgr.restore();
    }
}
