package com.presnakou.oop.principles.polymorphism.space.objects;

import java.util.Objects;

public class Asteroid extends SpaceObject {

    private boolean isHasASatellite;
    private long length;
    private long height;

    public Asteroid(String name, Long id, long mass) {
        super(name, id, mass);
    }

    public Asteroid(String name, Long id, long mass, boolean isHasASatellite, long length, long height) {
        super(name, id, mass);
        this.isHasASatellite = isHasASatellite;
        this.length = length;
        this.height = height;
    }

    @Override
    public double calculateDiameter() {
        return 2 * Math.sqrt(calculateSquare() / Math.PI);
    }

    private long calculateSquare() {
        return length * height;
    }

    @Override
    public int compareMasses(SpaceObject spaceObject) {
        return Long.compare(this.getMass(), spaceObject.getMass());
    }

    public boolean isHasASatellite() {
        return isHasASatellite;
    }

    public void setHasASatellite(boolean hasASatellite) {
        isHasASatellite = hasASatellite;
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
        Asteroid asteroid = (Asteroid) o;
        return isHasASatellite == asteroid.isHasASatellite && length == asteroid.length && height == asteroid.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isHasASatellite, length, height);
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "isHasASatellite=" + isHasASatellite +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}


