package com.presnakou.functions;

/**
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * Протестировать функцию в main.
 */
public class Exercise1 {

    public static void main(String[] args) {

        int minutes = 15;
        whatQuarterOfAnHour(minutes);
    }

    private static void whatQuarterOfAnHour(int minutes) {
        if (isRange(minutes, 0, 16)) {
            System.out.println(minutes + " minutes is the first quarter of an hour");
        } else if (isRange(minutes, 16, 31)) {
            System.out.println(minutes + " minutes is the second quarter of an hour");
        } else if (isRange(minutes, 31, 46)) {
            System.out.println(minutes + " minutes is the third quarter of an hour");
        } else if (isRange(minutes, 46, 60)) {
            System.out.println(minutes + " minutes is the fourth quarter of an hour");
        } else {
            System.out.println(minutes + " minutes is invalid value");
        }
    }

    private static boolean isRange(int value, int begin, int endExcluded) {
        return begin <= value && value < endExcluded;
    }
}
