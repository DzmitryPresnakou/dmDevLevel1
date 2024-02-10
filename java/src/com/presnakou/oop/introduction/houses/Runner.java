package com.presnakou.oop.introduction.houses;

import com.presnakou.oop.introduction.houses.floors.Floor;
import com.presnakou.oop.introduction.houses.floors.flats.Flat;
import com.presnakou.oop.introduction.houses.floors.flats.rooms.Room;

public class Runner {

    public static void main(String[] args) {

        Room room1 = new Room(false);
        Room room2 = new Room(false);
        Room room3 = new Room(true);
        Room room4 = new Room(false);
        Room room5 = new Room(true);

        Room[] rooms1 = {room1, room2, room3};
        Room[] rooms2 = {room3, room4, room5};
        Room[] rooms3 = {room1, room5};

        Flat flat1 = new Flat(1, rooms1);
        Flat flat2 = new Flat(2, rooms1);
        Flat flat3 = new Flat(3, rooms1);

        Flat[] flats = {flat1, flat2, flat3};

        Floor floor1 = new Floor(1, flats);
        Floor floor2 = new Floor(2, flats);
        Floor floor3 = new Floor(3, flats);
        Floor floor4 = new Floor(4, flats);
        Floor floor5 = new Floor(5, flats);

        Floor[] floors = {floor1, floor2, floor3, floor4, floor5};

        House house = new House(34, floors);
        printAllInformation(house);
    }

    private static void printAllInformation(House house) {
        house.print();
    }
}