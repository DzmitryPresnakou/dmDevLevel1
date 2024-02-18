package com.presnakou.oop.principles.polymorphism.space.objects;

import java.util.Objects;

public class Star extends SpaceObject{

    private String type;
    private long lengthOfCircle;

    public Star(String name, Long id, long mass) {
        super(name, id, mass);
    }

    public Star(String name, Long id, long mass, String type, long lengthOfCircle) {
        super(name, id, mass);
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        Star star = (Star) o;
        return lengthOfCircle == star.lengthOfCircle && Objects.equals(type, star.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, lengthOfCircle);
    }

    @Override
    public String toString() {
        return "Star{" +
                "type='" + type + '\'' +
                ", lengthOfCircle=" + lengthOfCircle +
                '}';
    }
}
