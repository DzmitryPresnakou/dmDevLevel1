package com.presnakou.multithreading;

import com.presnakou.multithreading.model.Race;
import com.presnakou.multithreading.threads.Planet;
import com.presnakou.multithreading.threads.Rocket;
import com.presnakou.multithreading.utils.ThreadUtil;

import java.util.LinkedList;
import java.util.List;

public class TaskRunner {

    public static void main(String[] args) throws InterruptedException {

        Race fireMages = new Race("Fire Mages");
        Race airMages = new Race("Air Mages");

        List<String> list = new LinkedList<>();
        List<Race> races = new LinkedList<>();
        races.add(fireMages);
        races.add(airMages);

        Thread crystalProduser = new Thread(new Planet(list, races));
        Thread fireMagesThread = new Thread(new Rocket(list, fireMages));
        Thread airMagesThread = new Thread(new Rocket(list, airMages));

        ThreadUtil.startThreads(crystalProduser, fireMagesThread, airMagesThread);
        ThreadUtil.joinThreads(crystalProduser, fireMagesThread, airMagesThread);

        if (fireMagesThread.getState().toString().equalsIgnoreCase("Terminated")
        && airMagesThread.getState().toString().equalsIgnoreCase("Terminated")) {
            crystalProduser.interrupt();
        }
    }
}
