package com.presnakou.ioStreams.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class FileHelper {
    private static final String COMMA_DELIMITER = ",";
    private static final Path RESULT_PATH = Path.of("resources", "result.csv");
    private static final Path ERRORS_PATH = Path.of("resources", "errors.csv");

    private FileHelper() {
    }

    public static LinkedHashMap<String, String> getPrices(File itemsPrice) {
        LinkedHashMap<String, String> prices = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(itemsPrice))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                if (values.length > 1) {
                    prices.put(values[0], (values[1]));
                } else {
                    prices.put(values[0], null);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prices;
    }

    public static LinkedHashMap<String, String> getNames(File itemsName) {
        LinkedHashMap<String, String> names = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(itemsName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                if (values.length > 1) {
                    names.put((values[0]), (values[1]));
                } else {
                    names.put(values[0], null);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return names;
    }

    public static List<String> mergeValuesAndWriteInFile(File itemsPrice, File itemsName) throws IOException {

        LinkedHashMap<String, String> names = getNames(itemsName);
        LinkedHashMap<String, String> prices = getPrices(itemsPrice);

        prices.forEach((key, value) -> names.merge(key, ((value != null) ? value : ""), (v1, v2) -> v1 + "," + v2));

        List<String> mergedList = new ArrayList<>();
        List<String> errorList = new ArrayList<>();

        for (Map.Entry<String, String> entry : names.entrySet()) {
            if (entry.getValue().isEmpty()) {
                errorList.add(entry.getKey());

            } else {
                mergedList.add(entry.getKey() + "," + entry.getValue());
            }
        }
        writeFile(errorList, ERRORS_PATH);
        writeFile(mergedList, RESULT_PATH);
        return mergedList;
    }

    public static void writeFile(List<String> list, Path path) throws IOException {
        Files.write(path, list);
    }
}