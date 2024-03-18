package com.presnakou.multithreading.threads;

import com.presnakou.multithreading.enums.CrystalType;
import com.presnakou.multithreading.model.Race;

import java.util.*;

public class Rocket implements Runnable {

    private final int WAIT_VALUE = 100;
    private final int MAX_VALUE = 20;
    private final List<CrystalType> LIST;
    private int numberOfRedCrystals;
    private int numberOfWhiteCrystals;

    private final Race race;

    public Rocket(List<CrystalType> list, Race race) {
        this.LIST = list;
        this.race = race;
    }

    @Override
    public void run() {
        synchronized (LIST) {
            while (numberOfRedCrystals <= MAX_VALUE && numberOfWhiteCrystals <= MAX_VALUE) {
                if (!LIST.isEmpty()) {
                    for (CrystalType crystalType : LIST) {
                        if (!race.getCristals().containsKey(crystalType)) {
                            race.getCristals().put(crystalType, 0);
                        } else {
                            int currentValue = race.getCristals().get(crystalType);
                            currentValue++;
                            race.getCristals().put(crystalType, currentValue);
                            System.out.println(crystalType + " crystal added, " + "all capacity: " + currentValue);
                            if (crystalType.equals(CrystalType.RED.toString())) {
                                numberOfRedCrystals = currentValue;
                            }
                            if (crystalType.equals(CrystalType.WHITE.toString())) {
                                numberOfWhiteCrystals = currentValue;
                            }
                        }
                    }
                    LIST.clear();
                    System.out.println(race.getCristals().entrySet());
                } else {
                    System.out.println("the consumer is waiting, list is empty");
                }
                try {
                    System.out.println("consumer wait: " + WAIT_VALUE);
                    LIST.notifyAll();
                    LIST.wait(WAIT_VALUE);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


//    @Override
//    public void run() {
//        synchronized (LIST) {
//            while (numberOfRedCrystals <= MAX_VALUE && numberOfWhiteCrystals <= MAX_VALUE) {
//                if (!LIST.isEmpty()) {
//                    for (String crystalType : LIST) {
//                        if (!CRYSTALS.containsKey(crystalType)) {
//                            CRYSTALS.put(crystalType, 0);
//                        } else {
//                            int currentValue = CRYSTALS.get(crystalType);
//                            currentValue++;
//                            CRYSTALS.put(crystalType, currentValue);
//                            System.out.println(crystalType + " crystal added, " + "all capacity: " + currentValue);
//                            if (crystalType.equals(CrystalType.RED.toString())) {
//                                numberOfRedCrystals = currentValue;
//                            }
//                            if (crystalType.equals(CrystalType.WHITE.toString())) {
//                                numberOfWhiteCrystals = currentValue;
//                            }
//                        }
//                    }
//                    LIST.clear();
//                    System.out.println(CRYSTALS.entrySet().toString());
//                } else {
//                    System.out.println("the consumer is waiting, list is empty");
//                }
//                try {
//                    System.out.println("consumer wait: " + WAIT_VALUE);
//                    LIST.notifyAll();
//                    LIST.wait(WAIT_VALUE);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }

    public Race getRace() {
        return race;
    }
}
