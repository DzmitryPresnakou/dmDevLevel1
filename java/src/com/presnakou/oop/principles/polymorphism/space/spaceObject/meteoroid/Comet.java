package com.presnakou.oop.principles.polymorphism.space.spaceObject.meteoroid;

import com.presnakou.oop.principles.polymorphism.space.spaceObject.SpaceObject;

import java.util.Objects;

public class Comet extends SpaceObject {

    private long tailLength;
    private long length;
    private long height;

    public Comet(String name, Long id, long mass, long tailLength, long length, long height) {
        super(name, id, mass);
        this.tailLength = tailLength;
        this.length = length;
        this.height = height;
    }

    @Override
    public double calculateDiameter() {
        return 2 * Math.sqrt(calculateSquare() / Math.PI);
    }

    @Override
    public int compareMasses(SpaceObject spaceObject) {
        return Long.compare(this.getMass(), spaceObject.getMass());
    }

    private long calculateSquare() {
        return length * height;
    }

    public long getTailLength() {
        return tailLength;
    }

    public void setTailLength(long tailLength) {
        this.tailLength = tailLength;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comet comet = (Comet) o;
        return tailLength == comet.tailLength && length == comet.length && height == comet.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tailLength, length, height);
    }

    @Override
    public String toString() {
        return "Comet{" +
                "tailLength=" + tailLength +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}
