package com.presnakou.multithreading.threads;

import com.presnakou.multithreading.enums.CrystalType;
import com.presnakou.multithreading.model.Race;

import java.util.*;

public class Rocket implements Runnable {

    private final int WAIT_VALUE = 80;
    private final int MAX_VALUE = 20;
    private final List<String> LIST;
    private final Race race;

    public Rocket(List<String> list, Race race) {
        this.LIST = list;
        this.race = race;
    }

    @Override
    public void run() {
        synchronized (LIST) {
            while (!isRaceWin()) {
                if (!LIST.isEmpty()) {
                    for (String crystalType : LIST) {
                        if (!race.getCristals().containsKey(crystalType)) {
                            race.getCristals().put(crystalType, 0);
                        } else {
                            int currentValue = race.getCristals().get(crystalType);
                            currentValue++;
                            race.getCristals().put(crystalType, currentValue);
                            System.out.println("The race " + race.getName()
                                    + " added " + crystalType + " crystal, " + "all capacity: " + currentValue);
                        }
                    }
                    LIST.clear();
                    System.out.println(race.getCristals().entrySet());
                } else {
                    System.out.println("The Rocket is waiting, list is empty");
                }
                try {
                    System.out.println("The Rocket wait: " + WAIT_VALUE);
                    LIST.notifyAll();
                    LIST.wait(WAIT_VALUE);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("The race " + race.getName() + "win!");
            Thread.currentThread().interrupt();
        }
    }

    private boolean isRaceWin() {
        if (race.getCristals().get(CrystalType.RED.toString()) != null
                && race.getCristals().get(CrystalType.WHITE.toString()) != null) {
            Integer numberOfRedCristals = race.getCristals().get(CrystalType.RED.toString());
            Integer numberOfWhiteCristals = race.getCristals().get(CrystalType.WHITE.toString());
            return numberOfRedCristals >= MAX_VALUE && numberOfWhiteCristals >= MAX_VALUE;
        }
        return false;
    }
}
