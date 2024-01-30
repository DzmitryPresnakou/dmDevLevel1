package com.presnakou.functions;

/**
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
 *
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */
public class Exercise3 {

    public static void main(String[] args) {

        double triangle1SideA = 8.0;
        double triangle1SideB = 12.0;

        double triangle2SideA = 12.0;
        double triangle2SideB = 14.0;

        double areaOfATriangle1 = calculateTheAreaOfATriangle(triangle1SideA, triangle1SideB);
        double areaOfATriangle2 = calculateTheAreaOfATriangle(triangle2SideA, triangle2SideB);

        compareAreaOfTriangles(areaOfATriangle1, areaOfATriangle2);

    }

    private static double calculateTheAreaOfATriangle(double a, double b) {
        return (a * b) / 2;
    }

    private static void compareAreaOfTriangles(double area1, double area2) {
        if (area1 > area2) {
            System.out.println("the first triangle (" + area1 + ") is larger than the second (" + area2 + ")");
        } else if (area1 < area2) {
            System.out.println("the first triangle (" + area1 + ") is smaller than the second (" + area2 + ")");
        } else {
            System.out.println("the first triangle (" + area1 + ") is equal to the second (" + area2 + ")");
        }

    }
}
