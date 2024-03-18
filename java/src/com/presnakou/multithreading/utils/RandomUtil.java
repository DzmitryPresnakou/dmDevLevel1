package com.presnakou.multithreading.utils;

import java.util.Random;

public final class RandomUtil {

    public static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int getRandom(int bound) {

        return RANDOM.nextInt(bound);

    }
}
