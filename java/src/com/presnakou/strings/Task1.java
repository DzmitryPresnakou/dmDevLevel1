package com.presnakou.strings;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * <p>
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */

public final class Task1 {
    public static void main(String[] args) {

        String string = "abc Cpddd Dio OsfWw";
        String result = removeDuplicateCharacters(string);
        System.out.println(result);
    }

    private static String removeDuplicateCharacters(String string) {
        char[] charArray = removeSpaces(string).toUpperCase().toCharArray();
        StringBuilder stringBuilder = new StringBuilder(charArray.length);
        char previousChar = 0;
        for (char character : charArray) {
            if (character != previousChar) {
                stringBuilder.append(character);
            }
            previousChar = character;
        }
        return stringBuilder.toString();
    }

    private static String removeSpaces(String string) {
        return string.replace(" ", "");
    }
}
