package com.presnakou.multithreading.threads;

import com.presnakou.multithreading.enums.CrystalType;
import com.presnakou.multithreading.utils.RandomUtil;

import java.util.List;

public class Planet implements Runnable {
    private final int WAIT_VALUE = 20;
    private final List<CrystalType> LIST;
    private final int LIST_CAPACITY = 4;
    private final int BOUND = CrystalType.values().length;

    public Planet(List<CrystalType> list) {
        this.LIST = list;
    }

    @Override
    public void run() {
        synchronized (LIST) {
            while (true) {
                if (LIST.size() < LIST_CAPACITY) {
                    CrystalType crystalType = getRandomCrystalType();
                    LIST.add(crystalType);
                    System.out.println("producer adds value: " + crystalType + ". Size " + LIST.size());
                } else {
                    System.out.println("producer does nothing");
                }
                LIST.notifyAll();
                try {
                    System.out.println("producer waits: " + WAIT_VALUE);
                    LIST.wait(WAIT_VALUE);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private CrystalType getRandomCrystalType() {
        return CrystalType.values()[RandomUtil.getRandom(BOUND)];
    }
}
