package com.presnakou.oop.introduction.houses.floors.flats;

import com.presnakou.oop.introduction.houses.floors.flats.rooms.Room;

import java.util.Arrays;
import java.util.Objects;

public class Flat {

    int number;
    Room[] rooms;

    public Flat(int number, Room[] rooms) {
        this.number = number;
        this.rooms = rooms;
    }

    public void print() {
        System.out.println(toString());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number && Arrays.equals(rooms, flat.rooms);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(rooms);
        return result;
    }

    @Override
    public String toString() {
        return "\nКвартира " + number + ", количество комнат "
                + rooms.length + ",\nКомнаты: "
                + Arrays.toString(rooms);
    }


}
