package com.presnakou.oop.principles.polymorphism.space.objects;

import java.util.Objects;

public class Planet extends SpaceObject implements RotatingOnAxis, MovingOwnOrbit {

    private long weight;
    private boolean isInhabited;
    private long lengthOfCircle;

    public Planet(String name, Long id, long mass) {
        super(name, id, mass);
    }

    public Planet(String name, Long id, long mass, long weight, boolean isInhabited, long lengthOfCircle) {
        super(name, id, mass);
        this.weight = weight;
        this.isInhabited = isInhabited;
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
        return (long) (FIRST_SPACESPEED_COEFICIENT / getMass() * Math.PI);
    }

    @Override
    public long getSpeed() {
        return (long) (getMass() / SECOND_SPACESPEED_COEFICIENT * Math.PI);
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public boolean isInhabited() {
        return isInhabited;
    }

    public void setInhabited(boolean inhabited) {
        isInhabited = inhabited;
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
        Planet planet = (Planet) o;
        return weight == planet.weight && isInhabited == planet.isInhabited && lengthOfCircle == planet.lengthOfCircle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, isInhabited, lengthOfCircle);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "weight=" + weight +
                ", isInhabited=" + isInhabited +
                ", lengthOfCircle=" + lengthOfCircle +
                '}';
    }
}
