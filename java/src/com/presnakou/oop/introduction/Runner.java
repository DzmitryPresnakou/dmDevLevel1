package com.presnakou.oop.introduction;

import com.presnakou.oop.introduction.houses.House;
import com.presnakou.oop.introduction.houses.floors.Floor;
import com.presnakou.oop.introduction.houses.floors.flats.Flat;
import com.presnakou.oop.introduction.houses.floors.flats.rooms.Room;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

        Room room1 = new Room(false);
        Room room2 = new Room(false);
        Room room3 = new Room(true);
        Room room4 = new Room(false);
        Room room5 = new Room(true);

        Flat flat1 = new Flat(1, new Room[]{room1, room2, room3});
        Flat flat2 = new Flat(2, new Room[]{room3, room4, room5});
        Flat flat3 = new Flat(3, new Room[]{room1, room5});

        Floor floor1 = new Floor(1, new Flat[]{flat1, flat2, flat3});
        Floor floor2 = new Floor(2, new Flat[]{flat1, flat2, flat3});
        Floor floor3 = new Floor(3, new Flat[]{flat1, flat2, flat3});
        Floor floor4 = new Floor(4, new Flat[]{flat1, flat2, flat3});
        Floor floor5 = new Floor(5, new Flat[]{flat1, flat2, flat3});

        House house = new House(34, new Floor[]{floor1, floor2, floor3, floor4, floor5});
        printAllInformation(house);
    }

    private static void printAllInformation(House house) {
        System.out.println(house.toString());
    }
}