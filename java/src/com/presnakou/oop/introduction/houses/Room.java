package com.presnakou.oop.introduction.houses;

import java.util.Objects;

public class Room {

    private boolean isPassageway;

    public Room(boolean isPassageway) {
        this.isPassageway = isPassageway;
    }

    public void print() {
        System.out.println(toString());
    }

    public boolean isPassageway() {
        return isPassageway;
    }

    public void setPassageway(boolean passageway) {
        isPassageway = passageway;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return isPassageway == room.isPassageway;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPassageway);
    }

    @Override
    public String toString() {
        return "Комната " + (isPassageway ? "проходная" : "непроходная");
    }
}
