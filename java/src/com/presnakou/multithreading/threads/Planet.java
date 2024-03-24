package com.presnakou.multithreading.threads;

import com.presnakou.multithreading.enums.CrystalType;
import com.presnakou.multithreading.model.Race;
import com.presnakou.multithreading.utils.RandomUtil;

import java.util.List;

public class Planet implements Runnable {
    private final int WAIT_VALUE = 20;
    private final List<String> LIST;
    private final int LIST_CAPACITY = 4;
    private final int MAX_VALUE = 20;
    private final int BOUND = CrystalType.values().length;
    private final List<Race> races;

    public Planet(List<String> list, List<Race> races) {
        this.LIST = list;
        this.races = races;
    }

    @Override
    public void run() {
        synchronized (LIST) {
            while (!isShouldStop()) {
                if (LIST.size() < LIST_CAPACITY) {
                    String crystalType = getRandomCrystalType();
                    LIST.add(crystalType);
                    System.out.println(crystalType + " crystals grew. Size " + LIST.size());
                } else {
                    System.out.println("Grew nothing");
                }
                LIST.notifyAll();
                try {
                    System.out.println("nothing grows: " + WAIT_VALUE);
                    LIST.wait(WAIT_VALUE);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Thread.currentThread().interrupt();
        }
    }

    private String getRandomCrystalType() {
        return CrystalType.values()[RandomUtil.getRandom(BOUND)].toString();
    }

    private boolean isShouldStop() {
        if (!races.isEmpty()) {
            for (Race race : races) {
                if (race.getCristals().get(CrystalType.RED.toString()) != null
                        && race.getCristals().get(CrystalType.WHITE.toString()) != null) {
                    return race.getCristals().get(CrystalType.RED.toString()) >= MAX_VALUE
                            && race.getCristals().get(CrystalType.WHITE.toString()) >= MAX_VALUE;
                }
            }
        }
        return false;
    }
}
