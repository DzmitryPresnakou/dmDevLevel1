package com.presnakou.functionalProgramming.utils;

import com.presnakou.functionalProgramming.Report;
import com.presnakou.functionalProgramming.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public final class StudentUtil {

    private static Integer NUMBER_OF_MINIMUM_GRADES = 3;

    private StudentUtil() {
    }

    public static Double getAverageGrade(Student student) {
        return student.getGradeList().stream()
                .mapToInt(Integer::intValue)
                .average().getAsDouble();
    }

    public static Map<Integer, Double> getAverageGrade(List<Student> students) {
        return students.stream()
                .filter(student -> student.getGradeList().size() > NUMBER_OF_MINIMUM_GRADES)
                .collect(groupingBy(Student::getCourseNumber,
                        mapping(StudentUtil::getAverageGrade, averagingDouble(Double::doubleValue))));
    }

    public static Map<Integer, List<String>> getStudentsListByFullName(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getFullName))
                .collect(groupingBy(Student::getCourseNumber,
                        mapping(Student::getFullName, toList())));
    }

    public static Map<Integer, List<Student>> getStudentsListByNameAndSurname(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getFullName))
                .collect(groupingBy(Student::getCourseNumber,
                        mapping(s -> new Student(s.getName(), s.getSurname()), Collectors.toList())));
    }

    public static Map<Integer, Report> getCourseAndStudentNamesWithAverageGrade(
            Map<Integer, List<String>> sortedStudentList,
            List<Student> students) {
        return sortedStudentList.entrySet().stream()
                .map(entry -> Map.entry(
                        entry.getKey(),
                        new Report(
                                entry.getValue(),
                                students.stream()
                                        .filter(s -> s.getCourseNumber() == entry.getKey())
                                        .mapToDouble(StudentUtil::getAverageGrade)
                                        .average().orElse(0.0)
                        )))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
