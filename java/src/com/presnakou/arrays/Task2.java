package com.presnakou.arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа
 * (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива
 * и вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class Task2 {

    public static void main(String[] args) {

        char[] array = {'a', '6', 'y', 'P', 'T', 'q', '9', '+' };
        int[] newArray = new int[array.length];

        copyCharArrayToNumbers(array, newArray);
        printValuesAboveAverage(newArray);

    }

    private static void printValuesAboveAverage(int[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] > getAverageValue(newArray)) {
                System.out.print(newArray[i] + " ");
            }
        }
    }

    private static int getAverageValue(int[] newArray) {
        int sum = 0;
        for (int i = 0; i < newArray.length; i++) {
            sum += newArray[i];
        }
        return sum / newArray.length;
    }

    private static void copyCharArrayToNumbers(char[] array, int[] newArray) {
        for (int i = 0; i < array.length; i++) {
            newArray[i] = (int) array[i];
        }
    }
}
