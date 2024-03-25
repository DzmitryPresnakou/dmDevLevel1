package com.presnakou.regex;

import com.presnakou.regex.model.Complaint;
import com.presnakou.regex.utils.RegexHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RegexRunner {

    public static void main(String[] args) throws IOException, InterruptedException {

        File complaints = Path.of("resources", "complaints.csv").toFile();
        List<Complaint> complaintsList = RegexHelper.getDataFromFile(complaints);

        RegexHelper.writeNewComplaint(
                new Complaint("Вася Васильев", "+375442352689", "Не работает кнопка вызова на телефоне"),
                Path.of("resources", "complaints.csv"));
        System.out.println("Новая жалоба добавлена");

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future<Integer> complaintHandling = threadPool.submit(() -> {

            Thread.sleep(2000L);
            if (!complaintsList.isEmpty()) {
                System.out.println("Старт считывания всех новых жалоб");
                Thread.sleep(5000L);
                System.out.println("Считывание всех новых жалоб завершено");
                Thread.sleep(2000L);
                System.out.println("Передача списка жалоб диспетчерам");
                Thread.sleep(2000L);
                System.out.println("Обработка всех новых жалоб");
                Thread.sleep(2000L);
            }
            while (complaintsList.size() > 0) {
                System.out.println("Обработка жалобы №" + complaintsList.size());
                Thread.sleep(5000L);
                RegexHelper.writeStringInFile(RegexHelper.processedString(complaintsList));
                System.out.println("Жалоба №" + complaintsList.size() + " обработана");
                complaintsList.remove(0);
                Thread.sleep(2000L);
            }
            System.out.println("Все жалобы обработаны");
            return 1;
        });

        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);

        System.out.println("Работа завершена");
    }
}