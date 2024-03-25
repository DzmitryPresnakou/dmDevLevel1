package com.presnakou.regex;

import com.presnakou.regex.model.Complaint;
import com.presnakou.regex.utils.RegexHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class RegexRunner {

    public static void main(String[] args) throws IOException {

        File complaints = Path.of("resources", "complaints.csv").toFile();

        DateTimeFormatter NEW_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        RegexHelper.writeNewComplaint(
                new Complaint("Вася Васильев", "+375442352689", "Не работает кнопка вызова на телефоне"),
                Path.of("resources", "complaints.csv"));

        List<Complaint> complaintsList = RegexHelper.getDataFromFile(complaints);

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);


//        threadPool.scheduleAtFixedRate(() -> System.out.println(RegexHelper.processedAndwriteInFile(complaints)), 2L, 2L, TimeUnit.SECONDS);

//        threadPool.shutdown();
//        threadPool.awaitTermination(1L, TimeUnit.HOURS);

    }

//    private static void test() throws InterruptedException {
//        ExecutorService threadPool = Executors.newFixedThreadPool(2);
//        Future<Integer> future = threadPool.submit(() -> {
//            Thread.sleep(2000L);
//            System.out.println("It's calable");
//            return 1;
//        });
//
//        threadPool.shutdown();
//        threadPool.awaitTermination(1L, TimeUnit.HOURS);
//        System.out.println("main end");
//    }
}
