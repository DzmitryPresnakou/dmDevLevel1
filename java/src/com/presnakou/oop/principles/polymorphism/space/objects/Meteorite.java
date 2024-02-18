package com.presnakou.oop.principles.polymorphism.space.objects;

import java.util.Objects;

public class Meteorite extends Asteroid {

    private boolean isFallen;

    public Meteorite(String name, Long id, long mass, boolean isHasASatellite, long length, long height) {
        super(name, id, mass, isHasASatellite, length, height);
    }

    public Meteorite(String name, Long id, long mass, boolean isHasASatellite, long length, long height, boolean isFallen) {
        super(name, id, mass, isHasASatellite, length, height);
        this.isFallen = isFallen;
    }

    public boolean isFallen() {
        return isFallen;
    }

    public void setFallen(boolean fallen) {
        isFallen = fallen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Meteorite meteorite = (Meteorite) o;
        return isFallen == meteorite.isFallen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isFallen);
    }

    @Override
    public String toString() {
        return "Meteorite{" +
                "isFallen=" + isFallen +
                '}';
    }
}
