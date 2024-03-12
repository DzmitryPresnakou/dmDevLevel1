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
    private static final int ID = 0;
    private static final int PRICE_OR_NAME = 1;

    private FileHelper() {
    }

    public static LinkedHashMap<String, String> getPrices(File itemsPrice) {
        return getDataFromFile(itemsPrice);
    }

    public static LinkedHashMap<String, String> getNames(File itemsName) {
        return getDataFromFile(itemsName);
    }

    private static LinkedHashMap<String, String> getDataFromFile(File file) {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                String key = values[ID];
                String value = (values.length > 1) ? values[PRICE_OR_NAME] : null;
                data.put(key, value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
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