package com.presnakou.functionalProgramming;

import java.util.List;
import java.util.Objects;
import java.lang.String;

public class Student {

    private final String name;
    private final String surname;
    private Integer courseNumber;
    private List<Integer> gradeList;

    public Student(String name, String surname, Integer courseNumber, List<Integer> gradeList) {
        this.name = name;
        this.surname = surname;
        this.courseNumber = courseNumber;
        this.gradeList = gradeList;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
    }

    public List<Integer> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Integer> gradeList) {
        this.gradeList = gradeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(courseNumber, student.courseNumber) && Objects.equals(gradeList, student.gradeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, courseNumber, gradeList);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", courseNumber=" + courseNumber +
                ", gradeList=" + gradeList +
                '}';
    }
}
