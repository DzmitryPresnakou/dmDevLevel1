package com.presnakou.oop.principles.polymorphism.space.objects;

import java.util.Objects;

public class Satellite extends SpaceObject implements RotatingOnAxis {

    private String owner;
    private long lengthOfCircle;

    public Satellite(String name, Long id, long mass) {
        super(name, id, mass);
    }

    public Satellite(String name, Long id, long mass, String owner, long lengthOfCircle) {
        super(name, id, mass);
        this.owner = owner;
        this.lengthOfCircle = lengthOfCircle;
    }

    @Override
    public double calculateDiameter() {
        return lengthOfCircle / Math.PI;
    }

    @Override
    public int compareMasses(SpaceObject spaceObject) {
        return Long.compare(this.getMass(), spaceObject.getMass());
    }

    @Override
    public long getRotationSpeed() {
        return (long) (FIRST_SPACESPEED_COEFICIENT / super.getMass() * Math.PI);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getLengthOfCircle() {
        return lengthOfCircle;
    }

    public void setLengthOfCircle(long lengthOfCircle) {
        this.lengthOfCircle = lengthOfCircle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Satellite satellite = (Satellite) o;
        return lengthOfCircle == satellite.lengthOfCircle && Objects.equals(owner, satellite.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, lengthOfCircle);
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "owner='" + owner + '\'' +
                ", lengthOfCircle=" + lengthOfCircle +
                '}';
    }
}
