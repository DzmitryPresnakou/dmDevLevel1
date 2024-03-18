package com.presnakou.multithreading;

import com.presnakou.multithreading.enums.CrystalType;
import com.presnakou.multithreading.model.Race;
import com.presnakou.multithreading.threads.Rocket;
import com.presnakou.multithreading.threads.Planet;
import com.presnakou.multithreading.utils.ThreadUtil;

import java.util.LinkedList;
import java.util.List;

public class TaskRunner {

    public static void main(String[] args) throws InterruptedException {

        List<CrystalType> list = new LinkedList<>();
        Thread crystalProduser = new Thread(new Planet(list));
        Thread fireMages = new Thread(new Rocket(list, new Race("Fire mages")));
        Thread airMages = new Thread(new Rocket(list, new Race("Air mages")));

        ThreadUtil.startThreads(crystalProduser, fireMages, airMages);
        ThreadUtil.joinThreads(crystalProduser, fireMages, airMages);


    }
}
