/*
 *
 * File:		StateContainer.java
 * Class:		com.servercurio.comune.drawing.StateContainer
 * Modified:	4/25/18 12:36 AM
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

package com.servercurio.comune.drawing;

import java.awt.*;
import java.awt.geom.AffineTransform;

class StateContainer {
    private RenderingHints hints;

    private Font font;
    private Stroke stroke;

    private Color foreground;
    private Color background;
    private Paint paint;

    private AffineTransform transform;
    private Composite composite;

    StateContainer() {

    }

    StateContainer(final RenderingHints hints, final Font font, final Stroke stroke, final Color foreground, final Color background, final Paint paint, final AffineTransform transform, final Composite composite) {
        this.hints = hints;
        this.font = font;
        this.stroke = stroke;
        this.foreground = foreground;
        this.background = background;
        this.paint = paint;
        this.transform = transform;
        this.composite = composite;
    }

    public RenderingHints getHints() {
        return hints;
    }

    public void setHints(final RenderingHints hints) {
        this.hints = hints;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(final Font font) {
        this.font = font;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(final Stroke stroke) {
        this.stroke = stroke;
    }

    public Color getForeground() {
        return foreground;
    }

    public void setForeground(final Color foreground) {
        this.foreground = foreground;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(final Color background) {
        this.background = background;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(final Paint paint) {
        this.paint = paint;
    }

    public AffineTransform getTransform() {
        return transform;
    }

    public void setTransform(final AffineTransform transform) {
        this.transform = transform;
    }

    public Composite getComposite() {
        return composite;
    }

    public void setComposite(final Composite composite) {
        this.composite = composite;
    }
}
