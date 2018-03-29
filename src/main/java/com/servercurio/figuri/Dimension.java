/*
 *
 * File:		Dimension.java
 * Class:		com.servercurio.figuri.Dimension
 * Modified:	3/29/18 12:34 AM
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

package com.servercurio.figuri;

import com.servercurio.comune.util.CompareToBuilder;
import com.servercurio.comune.util.Copyable;
import com.servercurio.comune.util.EqualityBuilder;

import java.io.Serializable;
import java.util.Objects;

public class Dimension implements Serializable, Cloneable, Comparable<Dimension>, Copyable<Dimension> {

    private static final long serialVersionUID = -924346892445077352L;

    private double width;
    private double height;

    public Dimension() {
        this(0, 0);
    }

    public Dimension(double width, double height) {
        this.width = width;
        this.height = height;
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

    public Dimension getSize() {
        return new Dimension(width, height);
    }

    public void setSize(final double width, final double height) {
        this.width = width;
        this.height = height;
    }

    public void expand(final Dimension other) {
        width = Math.max(width, other.width);
        height = Math.max(height, other.height);
    }

    @Override
    public void copyTo(final Dimension other) {
        if (other == null) {
            return;
        }

        other.width = width;
        other.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dimension)) return false;

        Dimension that = (Dimension) o;
        return Double.compare(that.width, width) == 0 &&
                Double.compare(that.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public int compareTo(final Dimension that) {
        if (this == that) {
            return EqualityBuilder.EQUALITY;
        }

        if (that == null) {
            return EqualityBuilder.GREATER_THAN;
        }

        return new CompareToBuilder()
                .append(that.width, width)
                .append(that.height, height)
                .build();
    }


}
