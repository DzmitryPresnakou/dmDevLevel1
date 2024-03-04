package com.presnakou.functionalProgramming.utils;

import com.presnakou.functionalProgramming.Student;

public final class StudentUtil {

    private static Integer NUMBER_OF_MINIMUM_GRADES = 3;

    private StudentUtil() {
    }

    public static Double getAverageGrade(Student student) {
        return student.getGradeList().stream()
                .mapToInt(Integer::intValue)
                .average().getAsDouble();
    }
}
