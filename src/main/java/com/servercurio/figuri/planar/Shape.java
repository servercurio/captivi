/*
 *
 * File:		Shape.java
 * Class:		com.servercurio.figuri.planar.Shape
 * Modified:	3/28/18 10:43 PM
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

import java.io.Serializable;

public interface Shape extends Serializable {

    boolean contains(double x, double y);

    boolean contains(Point point);

    boolean contains(double x, double y, double w, double h);

    boolean contains(Rectangle rectangle);

    Rectangle getBounds();

}
