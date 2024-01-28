package com.presnakou.functions;

/**
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * Протестировать функцию в main.
 */
public class Exercise1 {

    public static void main(String[] args) {

        int minutes = 16;
        whatQuarterOfAnHour(minutes);
    }

    public static void whatQuarterOfAnHour(int minutes) {
        if (0 <= minutes && minutes <= 15) {
            System.out.println(minutes + " minutes is the first quarter of an hour");
        } else if (16 <= minutes && minutes <= 30) {
            System.out.println(minutes + " minutes is the second quarter of an hour");
        } else if (31 <= minutes && minutes <= 45) {
            System.out.println(minutes + " minutes is the third quarter of an hour");
        } else if (46 <= minutes && minutes <= 59) {
            System.out.println(minutes + " minutes is the fourth quarter of an hour");
        } else {
            System.out.println(minutes + " minutes is invalid value");
        }
    }
}
