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

import java.awt.geom.Ellipse2D;

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

}
