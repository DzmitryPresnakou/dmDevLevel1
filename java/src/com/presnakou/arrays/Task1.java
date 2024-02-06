package com.presnakou.arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы
 * (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции.
 * main - только для тестирования написанного функционала.
 */
public class Task1 {

    public static void main(String[] args) {

        int[] array = {3, 5, -6, 3, 2, -9, 0, -123};
        int positiveArrayLength = getPositiveArrayLength(array);
        int[] newArray = new int[positiveArrayLength];

        copyArray(array, newArray, positiveArrayLength);
        printArray(newArray);

    }

    private static void printArray(int[] newArray) {
        for (int i : newArray) {
            System.out.print(i + " ");
        }
    }

    private static void copyArray(int[] array, int[] newArray, int newArrayLength) {
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                newArray[j] = array[i] * newArrayLength;
                j++;
            }
        }
    }

    private static int getPositiveArrayLength(int[] array) {
        int newArrayLength = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                newArrayLength++;
            }
        }
        return newArrayLength;
    }
}