package com.presnakou.cycles;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число,
 * а возвращать количество четных цифр (вторая функция - нечетных).
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task1 {

    public static void main(String[] args) {

        int value = 228910;
        int numberOfEven = numberOfEven(value);
        int numberOfOdd = numberOfOdd(value);
        System.out.println("в числе " + value + " " + numberOfEven + " четных цифр");
        System.out.println("в числе " + value + " " + numberOfOdd + " нечетных цифр");
    }

    private static int numberOfEven(int value) {
        int counter = 0;
        while (value != 0) {
            int currentValue = value % 10;
            if (isAnEven(currentValue)) {
                counter++;
            }
            value /= 10;
        }
        return counter;
    }

    private static boolean isAnEven(int currentValue) {
        return currentValue % 2 == 0;
    }

    private static int numberOfOdd(int value) {
        int counter = 0;
        while (value != 0) {
            int currentValue = value % 10;
            if (!isAnEven(currentValue)) {
                counter++;
            }
            value /= 10;
        }
        return counter;
    }
}
