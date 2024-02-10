package com.presnakou.oop.introduction.houses;

import com.presnakou.oop.introduction.houses.floors.Floor;

import java.util.Arrays;
import java.util.Objects;

public class House {

    int number;
    Floor[] floors;

    public void print() {
        System.out.println(toString());
    }

    public House(int number, Floor[] floors) {
        this.number = number;
        this.floors = floors;
        for (int i = 0; i < floors.length; i++) {
            this.floors[i].setNumber(i + 1);
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public void setFloors(Floor[] floors) {
        this.floors = floors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return number == house.number && Arrays.equals(floors, house.floors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(floors);
        return result;
    }

    @Override
    public String toString() {
        return "Дом " + number + ", количество этажей " + floors.length
                + ",\nЭтажи: " + Arrays.toString(floors);
    }
}
