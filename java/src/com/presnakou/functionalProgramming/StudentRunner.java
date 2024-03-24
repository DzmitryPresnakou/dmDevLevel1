package com.presnakou.functionalProgramming;

import com.presnakou.functionalProgramming.utils.StudentUtil;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * <p>
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * <p>
 * 1. Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * <p>
 * 2. Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 * <p>
 * 3. Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 * <p>
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */
public class StudentRunner {

    public static void main(String[] args) {

        Student vasya = new Student("Vasya", "Vasin", 1,
                new ArrayList<>(List.of(9, 8, 7, 6, 7, 8, 9, 8, 7, 6, 7, 8, 9)));
        Student masha = new Student("Masha", "Mashova", 2,
                new ArrayList<>(List.of(5, 7, 5, 6, 5, 7, 9, 7, 5, 6, 5, 7, 8)));
        Student kolya = new Student("Kolya", "Kolin", 3,
                new ArrayList<>(List.of(7, 8, 9, 8, 7, 6, 5, 6, 7, 8, 9, 8, 7)));
        Student ivan = new Student("Ivan", "Ivanov", 4,
                new ArrayList<>(List.of(5, 8, 6, 6, 7, 7, 9, 8)));
        Student valera = new Student("Valery", "Meladze", 1,
                new ArrayList<>(List.of(9, 8)));
        Student semen = new Student("Semen", "Semenov", 2,
                new ArrayList<>(List.of(9, 8, 7, 6, 7, 8, 7, 6, 7, 8, 9)));
        Student vova = new Student("Vova", "Volodin", 3,
                new ArrayList<>(List.of(9, 8, 8, 7, 6, 6, 8, 7)));
        Student katya = new Student("Katya", "Katina", 4,
                new ArrayList<>(List.of(6, 7)));
        Student yulya = new Student("Yulya", "Yudashkina", 3,
                new ArrayList<>(List.of(7, 8, 7, 6, 7, 8, 8)));
        Student petr = new Student("Petr", "Petrov", 2,
                new ArrayList<>(List.of(5, 8, 7)));
        Student misha = new Student("Misha", "Mishin", 1,
                new ArrayList<>(List.of(6, 6, 7, 6, 7, 5, 9, 8, 7, 6, 7)));

        List<Student> students = List.of(vasya, masha, kolya, ivan, valera, semen, vova, katya, yulya, petr, misha);

        Map<Integer, Double> averageGrade = StudentUtil.getAverageGrade(students);

        Map<Integer, List<String>> studentsListByFullName = StudentUtil.getStudentsListByFullName(students);

        Map<Integer, List<Student>> studentsListByNameAndSurname = StudentUtil.getStudentsListByNameAndSurname(students);

        Map<Integer, Report> courseAndStudentNamesWithAverageGrade = StudentUtil.getCourseAndStudentNamesWithAverageGrade(studentsListByFullName, students);

        System.out.println("Ключ - номер курса,\nзначение - средняя оценка студентов этого курса,\n" +
                "количество оценок у которых больше 3-х\n" + averageGrade);

        System.out.println("Ключ - номер курса,\nзначение - список студентов данного курса\n" +
                "но только с полями Имя и Фамилия\n" + studentsListByFullName);

        System.out.println("Ключ - номер курса,\nзначение - список студентов данного курса\n" +
                "но только с полями Имя и Фамилия\n" + studentsListByNameAndSurname);

        System.out.println("Ключ - номер курса,\nзначение - Объект с двумя полями:\n" +
                " - Отсортированный список студентов с пункта 2\n" +
                " - Средняя оценка этих студентов\n" + courseAndStudentNamesWithAverageGrade);
    }
}