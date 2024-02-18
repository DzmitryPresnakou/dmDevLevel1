package com.presnakou.oop.principles.polymorphism.space.objects;

import java.util.Objects;

public abstract class SpaceObject {
    private String name;
    private Long id;
    private long mass;

    public SpaceObject(String name, Long id, long mass) {
        this.name = name;
        this.id = id;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getMass() {
        return mass;
    }

    public void setMass(long mass) {
        this.mass = mass;
    }

    public abstract double calculateDiameter();

    public abstract int compareMasses(SpaceObject spaceObject);
}
