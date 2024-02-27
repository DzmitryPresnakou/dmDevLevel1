package com.presnakou.oop.principles.polymorphism.space.utils;

import com.presnakou.oop.principles.polymorphism.space.spaceObject.SpaceObject;
import com.presnakou.oop.principles.polymorphism.space.spaceObject.star.Star;

public final class SpaceUtils {

    public static double GRAVITY_COEFICIENT = 1.2345;

    private SpaceUtils() {
    }

    public static double getGravityForce(SpaceObject firstObject, SpaceObject secondObject) {
        return GRAVITY_COEFICIENT * ((firstObject.getMass() >= secondObject.getMass()) ?
                ((double) firstObject.getMass() / secondObject.getMass()) :
                ((double) secondObject.getMass() / firstObject.getMass()));
    }

    public static boolean isStar(SpaceObject spaceObject) {
        return spaceObject instanceof Star;
    }
}
