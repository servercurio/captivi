/*
 *
 * File:		GraphicsState.java
 * Class:		com.servercurio.comune.drawing.GraphicsState
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

import com.servercurio.comune.Aware;
import com.servercurio.comune.drawing.aware.ColorAware;
import com.servercurio.comune.drawing.aware.FontAware;
import com.servercurio.comune.drawing.aware.PaintAware;
import com.servercurio.comune.drawing.aware.StrokeAware;

import java.awt.Graphics2D;
import java.util.Stack;

public class GraphicsState {

    private Graphics2D graphics;
    private Stack<StateContainer> state;

    public GraphicsState(final Graphics2D graphics) {
        if (graphics == null) {
            throw new NullPointerException("graphics");
        }

        this.graphics = graphics;
        this.state = new Stack<>();
    }

    public Graphics2D getGraphics() {
        return graphics;
    }

    protected Stack<StateContainer> getState() {
        return state;
    }

    public void save() {
        state.push(new StateContainer(
                graphics.getRenderingHints(),
                graphics.getFont(),
                graphics.getStroke(),
                graphics.getColor(),
                graphics.getBackground(),
                graphics.getPaint(),
                graphics.getTransform(),
                graphics.getComposite()
        ));
    }

    public void restore() {
        if (state.isEmpty()) {
            return;
        }

        StateContainer sc = state.pop();
        graphics.setRenderingHints(sc.getHints());
        graphics.setFont(sc.getFont());
        graphics.setStroke(sc.getStroke());
        graphics.setColor(sc.getForeground());
        graphics.setBackground(sc.getBackground());
        graphics.setPaint(sc.getPaint());
        graphics.setTransform(sc.getTransform());
        graphics.setComposite(sc.getComposite());
    }

    public <T extends Renderable> void apply(final T renderable) {
        apply(renderable, false);
    }

    public <T extends Renderable> void apply(final T renderable, boolean doSave) {
        if (renderable instanceof Aware) {

            if (doSave) {
                save();
            }

            applyAwareness((Aware)renderable);
        }
    }

    protected <T extends Aware> void applyAwareness(final T aware) {
        if (aware instanceof ColorAware) {
            ColorAware ca = (ColorAware)aware;
            graphics.setColor(ca.getForegroundColor());
            graphics.setBackground(ca.getBackgroundColor());
        }

        if (aware instanceof FontAware) {
            graphics.setFont(((FontAware) aware).getFont());
        }

        if (aware instanceof PaintAware) {
            graphics.setPaint(((PaintAware) aware).getPaint());
        }

        if (aware instanceof StrokeAware) {
            graphics.setStroke(((StrokeAware) aware).getStroke());
        }
    }

}
