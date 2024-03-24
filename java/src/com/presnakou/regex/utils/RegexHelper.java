package com.presnakou.regex.utils;

import com.presnakou.regex.model.Complaint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class RegexHelper {
    private static final String COMMA_DELIMITER = ",";
    private static final int ID = 0;
    private static final int TIME = 1;
    private static final int FULL_NAME = 2;
    private static final int PHONE_NUMBER = 3;
    private static final int DESCRIPTION = 4;
    private static final Path RESULT_PATH = Path.of("resources", "processed complaints.csv");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private static final String TIME_REGEX = "(\\d{4}-\\d{2}-\\d{2})T(\\d{2}):(\\d{2}):(\\d{2})";


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
                Complaint complaint =
                        new Complaint(id, LocalDateTime.parse(time, FORMATTER), values[FULL_NAME], values[PHONE_NUMBER], values[DESCRIPTION]);
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

    public static List<String> processedAndwriteInFile(File file) {

        List<Complaint> complaints = getDataFromFile(file);
        List<String> processedComplaints = new ArrayList<>();

        for (Complaint complaint : complaints) {
            processedComplaints.add(complaint.getId() + ", "
            + correctTime(complaint.getTime().toString()) + ", "
            + complaint.getPhoneNumber().trim());
        }

        try {
            writeFile(processedComplaints, RESULT_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return processedComplaints;
    }

    public static void writeFile(List<String> list, Path path) throws IOException {
        Files.write(path, list);
    }

}
