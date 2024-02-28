package com.presnakou.oop.principles.polymorphism.space;

import com.presnakou.oop.principles.polymorphism.space.spaceObject.*;
import com.presnakou.oop.principles.polymorphism.space.spaceObject.meteoroid.Asteroid;
import com.presnakou.oop.principles.polymorphism.space.spaceObject.meteoroid.Comet;
import com.presnakou.oop.principles.polymorphism.space.spaceObject.meteoroid.Meteorite;
import com.presnakou.oop.principles.polymorphism.space.spaceObject.planet.Planet;
import com.presnakou.oop.principles.polymorphism.space.spaceObject.planet.PlanetType;
import com.presnakou.oop.principles.polymorphism.space.spaceObject.satellite.Satellite;
import com.presnakou.oop.principles.polymorphism.space.spaceObject.star.Star;
import com.presnakou.oop.principles.polymorphism.space.spaceObject.star.StarType;
import com.presnakou.oop.principles.polymorphism.space.utils.SpaceUtils;

public class SpaceRunner {

    public static void main(String[] args) {

        SpaceObject mars = new Planet("Mars", 1L, 1234567L, 321456L, false, 963258741L, PlanetType.TERRESTRIAL_PLANET);
        SpaceObject earth = new Planet("Earth", 2L, 2345697L, 521456L, true, 1963258741L, PlanetType.TERRESTRIAL_PLANET);
        SpaceObject venus = new Planet("Venus", 3L, 234567L, 21456L, false, 9658741L, PlanetType.TERRESTRIAL_PLANET);
        SpaceObject sun = new Star("Sun", 4L, 987654321L, StarType.SUN, 965874123L);

        SpaceObject moon = new Satellite("Moon", 5L, 321654L, "Earth", 321654L);
        SpaceObject comet = new Comet("Super Comet", 6L, 65454L, 3256L, 987L, 231L);
        SpaceObject asteroid = new Asteroid("Asteroid", 7L, 321L, false, 36L, 5L);
        SpaceObject meteorite = new Meteorite("Super Meteorite", 8L, 365L, false, 32L, 5L, false);

        System.out.println(SpaceUtils.isStar(sun) ? (sun.getName() + " is a star") : (sun.getName() + " isn't a Star, it's a " + sun.getClass().getSimpleName()));
        System.out.println(SpaceUtils.isStar(comet) ? (comet.getName() + " is a star") : (comet.getName() + " isn't a Star, it's a " + comet.getClass().getSimpleName()));
        System.out.println(SpaceUtils.isStar(mars) ? (mars.getName() + " is a star") : (mars.getName() + " isn't a Star, it's a " + mars.getClass().getSimpleName()));
        System.out.println(SpaceUtils.isStar(earth) ? (earth.getName() + " is a star") : (earth.getName() + " isn't a Star, it's a " + earth.getClass().getSimpleName()));
        System.out.println(SpaceUtils.isStar(venus) ? (venus.getName() + " is a star") : (venus.getName() + " isn't a Star, it's a " + venus.getClass().getSimpleName()));
        System.out.println(SpaceUtils.isStar(moon) ? (moon.getName() + " is a star") : (moon.getName() + " isn't a Star, it's a " + moon.getClass().getSimpleName()));
        System.out.println(SpaceUtils.isStar(asteroid) ? (asteroid.getName() + " is a star") : (asteroid.getName() + " isn't a Star, it's a " + asteroid.getClass().getSimpleName()));
        System.out.println(SpaceUtils.isStar(meteorite) ? (meteorite.getName() + " is a star") : (meteorite.getName() + " isn't a Star, it's a " + meteorite.getClass().getSimpleName()));
        System.out.println("The gravity force between " + mars.getName() + " and " + earth.getName() + " is " + SpaceUtils.getGravityForce(mars, earth));
        System.out.println("The gravity force between " + sun.getName() + " and " + earth.getName() + " is " + SpaceUtils.getGravityForce(sun, earth));
        System.out.println("The gravity force between " + comet.getName() + " and " + earth.getName() + " is " + SpaceUtils.getGravityForce(comet, earth));
        System.out.println("The gravity force between " + venus.getName() + " and " + earth.getName() + " is " + SpaceUtils.getGravityForce(venus, earth));
        System.out.println("The gravity force between " + moon.getName() + " and " + earth.getName() + " is " + SpaceUtils.getGravityForce(moon, earth));
        System.out.println("The gravity force between " + asteroid.getName() + " and " + earth.getName() + " is " + SpaceUtils.getGravityForce(asteroid, earth));
        System.out.println("The gravity force between " + meteorite.getName() + " and " + earth.getName() + " is " + SpaceUtils.getGravityForce(meteorite, earth));

    }
}
