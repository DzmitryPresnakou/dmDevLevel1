package com.presnakou.strings;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * <p>
 * Написать 2 метода:
 * <p>
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * <p>
 * Посчитать сумму всех чисел из строки
 * <p>
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class Task2 {

    public static final String DIGIT_STRING = "0123456789";
    public static final int ZERO_IN_UNICODE = 48;

    public static void main(String[] args) {

        String string = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        char[] charArray = removeSpaces(string).toCharArray();
        int[] digits = getDigitsFromString(charArray);
        int sumOfDigits = sumOfDigits(digits);

        System.out.println(sumOfDigits);
    }

    private static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    private static int[] getDigitsFromString(char[] charArray) {


        int counter = counterOfDigitsInString(charArray, DIGIT_STRING);

        int[] digits = new int[counter];
        for (int i = 0, j = 0; i < charArray.length; i++) {
            if (DIGIT_STRING.contains(String.valueOf(charArray[i]))) {
                digits[j] = charArray[i] - ZERO_IN_UNICODE;
                j++;
            }
        }
        return digits;
    }

    private static int counterOfDigitsInString(char[] charArray, String digitString) {
        int counter = 0;
        for (char character : charArray) {
            if (digitString.contains(String.valueOf(character))) {
                counter++;
            }
        }
        return counter;
    }

    private static String removeSpaces(String string) {
        return string.replace(" ", "");
    }
}