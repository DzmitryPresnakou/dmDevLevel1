package com.presnakou.ioStreams;

import com.presnakou.ioStreams.utils.FileHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Задание 1
 * <p>
 * Даны два файла в формате CSV.
 * <p>
 * CSV (Comma-Separated Values) файл - это обычный текстовый файл,
 * где через запятую (может использоваться и любой другой символ) перечислены значения.
 * Также может быть в первой строчке таких файлов заголовок с названием колонок.
 * <p>
 * Формат первого файла items-price.csv:
 * <p>
 * ID,PRICE
 * 1,9.98
 * 2,25.05
 * 3,16.45
 * <p>
 * Формат второго файла items-name.csv:
 * <p>
 * ID,NAME,DESCRIPTION
 * 1,Шарф,Теплый зимний шарф красного цвета
 * 2,Шапка,Вязаная зеленая шапка
 * 3,Ботинки,Осенние ботинки на толстой подошве
 * <p>
 * Задача:
 * <p>
 * Считать оба CSV файла и объединить их по полю ID в один result.csv, где будут следующие поля: ID,NAME,PRICE.
 * <p>
 * Желательно реализовать доп. функционал:
 * Если для каких-то ID не будет значений в обоих файлах,
 * то записать их в один файл errors.csv, где будет лишь одно поле ID.
 */
public class Task1 {
    public static void main(String[] args) throws IOException {

        File itemsPrice = Path.of("resources", "items-price.csv").toFile();
        File itemsName = Path.of("resources", "items-name.csv").toFile();

        System.out.println("Список Цен:\n" + FileHelper.getPrices(itemsPrice));
        System.out.println("Список имен:\n" + FileHelper.getNames(itemsName));
        System.out.println("Объединенный список:\n" + FileHelper.mergeValuesAndWriteInFile(itemsPrice, itemsName));

    }
}