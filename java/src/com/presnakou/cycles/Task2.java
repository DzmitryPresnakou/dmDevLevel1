package com.presnakou.cycles;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */
public class Task2 {

    public static void main(String[] args) {

        int value = 4508;
        int reverseValue = reverseValue(value);
        System.out.println(reverseValue);
    }

    private static int reverseValue(int value) {
        int reverseValue = 0;
        while (value % 10 == 0) {
            value /= 10;
        }
        while (value > 0) {
            reverseValue *= 10;
            reverseValue += value % 10;
            value /= 10;
        }
        return reverseValue;
    }
}


