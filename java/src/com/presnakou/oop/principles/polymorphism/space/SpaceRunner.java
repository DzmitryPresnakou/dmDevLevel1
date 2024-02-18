package com.presnakou.oop.principles.polymorphism.space;

import com.presnakou.oop.principles.polymorphism.space.objects.*;
import com.presnakou.oop.principles.polymorphism.space.utils.SpaceUtils;

public class SpaceRunner {

    public static void main(String[] args) {

        SpaceObject mars = new Planet("Mars", 1L, 1234567L, 321456L, false, 963258741L);
        SpaceObject earth = new Planet("Earth", 2L, 2345697L, 521456L, true, 1963258741L);
        SpaceObject venus = new Planet("Venus", 3L, 234567L, 21456L, false, 9658741L);
        SpaceObject sun = new Star("Sun", 4L, 987654321L, "giant", 965874123L);

        SpaceObject moon = new Satellite("Moon", 5L, 321654L, "Earth", 321654L);
        SpaceObject comet = new Comet("Super Comet", 6L, 65454L, 3256L, 987L, 231L);
        SpaceObject asteroid = new Asteroid("Asteroid", 7L, 321L, false, 36L, 5L);
        SpaceObject meteorite = new Meteorite("Super Meteorite", 8L, 365L, false, 32L, 5L, false);

        System.out.println(SpaceUtils.isStar(sun));
        System.out.println(SpaceUtils.isStar(comet));
        System.out.println(SpaceUtils.isStar(mars));
        System.out.println(SpaceUtils.isStar(earth));
        System.out.println(SpaceUtils.isStar(venus));
        System.out.println(SpaceUtils.isStar(moon));
        System.out.println(SpaceUtils.isStar(asteroid));
        System.out.println(SpaceUtils.isStar(meteorite));
        System.out.println(SpaceUtils.getGravityForce(mars, earth));
        System.out.println(SpaceUtils.getGravityForce(sun, earth));
        System.out.println(SpaceUtils.getGravityForce(comet, earth));
        System.out.println(SpaceUtils.getGravityForce(venus, earth));
        System.out.println(SpaceUtils.getGravityForce(moon, earth));
        System.out.println(SpaceUtils.getGravityForce(asteroid, earth));
        System.out.println(SpaceUtils.getGravityForce(meteorite, earth));

    }
}
