package com.presnakou.arrays;

/**
 * Дан одномерный массив целых чисел.
 * <p>
 * Написать функцию, которая принимает этот массив и разбивает на 3 других:
 * с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * <p>
 * Пример:
 * <p>
 * [-4, -18]
 * <p>
 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
 * <p>
 * [1, 9, 3]
 */
public class Task3 {

    public static void main(String[] args) {

        int[] array = {-4, 0, 1, 9, 0, -18, 3};
        int[][] newArray = arraysSeparator(array);

        printATwoDimensionalArray(newArray);
    }

    private static void printATwoDimensionalArray(int[][] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                System.out.print(newArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] arraysSeparator(int[] array) {
        int countNegatives = 0;
        int countPositives = 0;
        int countZeroes = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                countNegatives++;
            } else if (array[i] > 0) {
                countPositives++;
            } else {
                countZeroes++;
            }
        }
        int[] negativeArray = new int[countNegatives];
        int[] positiveArray = new int[countPositives];
        int[] zeroArray = new int[countZeroes];

        for (int i = 0, n = 0, p = 0, z = 0; i < array.length; i++) {
            if (array[i] < 0) {
                negativeArray[n] = array[i];
                n++;
            } else if (array[i] > 0) {
                positiveArray[p] = array[i];
                p++;
            } else {
                zeroArray[z] = array[i];
                z++;
            }
        }
        return new int[][]{negativeArray, positiveArray, zeroArray};
    }
}
