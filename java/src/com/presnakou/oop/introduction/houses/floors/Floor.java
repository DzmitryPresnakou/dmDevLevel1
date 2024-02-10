package com.presnakou.oop.introduction.houses.floors;

import com.presnakou.oop.introduction.houses.floors.flats.Flat;

import java.util.Arrays;
import java.util.Objects;

public class Floor {

    int number;
    Flat[] flats;

    public Floor(int number, Flat[] flats) {
        this.number = number;
        this.flats = flats;
        for (int i = 0; i < flats.length; i++) {
            this.flats[i].setNumber(i + 1);
        }
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

    public Flat[] getFlats() {
        return flats;
    }

    public void setFlats(Flat[] flats) {
        this.flats = flats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return number == floor.number && Arrays.equals(flats, floor.flats);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(flats);
        return result;
    }

    @Override
    public String toString() {
        return "\nЭтаж " + number + ", количество квартир "
                + flats.length + ",\nКвартиры: "
                + Arrays.toString(flats);
    }
}
