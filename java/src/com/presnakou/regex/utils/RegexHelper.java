package com.presnakou.regex.utils;

import com.presnakou.regex.model.Complaint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public final class RegexHelper {
    private static final String COMMA_DELIMITER = ",";
    private static final int ID = 0;
    private static final int TIME = 1;
    private static final int FULL_NAME = 2;
    private static final int PHONE_NUMBER = 3;
    private static final int DESCRIPTION = 4;
    private static final Path RESULT_PATH = Path.of("resources", "processed complaints.csv");
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    public static final DateTimeFormatter NEW_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final String TIME_REGEX = "(\\d{4}-\\d{2}-\\d{2})T(\\d{2}):(\\d{2}):(\\d{2})";
    private static final String PHONE_REGEX = "(\\+375)*\\s*(\\d{2})\\s*(\\d{3})\\s*(\\d{2})\\s*(\\d{2})";


    private RegexHelper() {
    }

    public static List<Complaint> getDataFromFile(File file) {
        List<Complaint> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                Long id = Long.parseLong(values[ID]);
                String time = values[TIME].trim();
                String phoneNumber = values[PHONE_NUMBER].trim();
                Complaint complaint =
                        new Complaint(id, LocalDateTime.parse(time, FORMATTER), values[FULL_NAME], correctPhoneNumber(phoneNumber), values[DESCRIPTION]);
                data.add(complaint);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    private static String correctTime(String time) {
        return time.replaceAll(TIME_REGEX, "$1 $2:$3");
    }

    private static String correctPhoneNumber(String phoneNumber) {
        return phoneNumber.replaceAll(PHONE_REGEX, "+375 ($2) $3-$4-$5");
    }

    public static List<String> processedAndwriteInFile(File file) {

        List<Complaint> complaints = getDataFromFile(file);
        List<String> processedComplaints = new ArrayList<>();

        for (Complaint complaint : complaints) {
            String newString = complaint.getId() + ", "
                    + getTimeDateNow(NEW_FORMATTER) + ", "
                    + complaint.getPhoneNumber().trim();
            processedComplaints.add(newString);
            writeString(newString, RESULT_PATH);
        }
        return processedComplaints;
    }

    public static String getTimeDateNow(DateTimeFormatter formatter) {
        String timeDateNow = formatter.format(ZonedDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return timeDateNow;
    }

    public static void writeFile(List<String> list, Path path) throws IOException {
        Files.write(path, list);
    }

    public static void writeString(String s, Path path) {
        try {
            Files.writeString(path, s + System.lineSeparator(), CREATE, APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeNewComplaint(Complaint complaint, Path path) {
        String result = "\n" + complaint.getId() + ", " + getTimeDateNow(FORMATTER)
                + ", " + complaint.getFullName() + ", " + correctPhoneNumber(complaint.getPhoneNumber())
                + ", " + complaint.getDescription();
        try {
            Files.writeString(path, result + System.lineSeparator(), CREATE, APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
