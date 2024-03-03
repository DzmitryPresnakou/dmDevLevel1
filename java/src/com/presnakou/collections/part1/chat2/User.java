package com.presnakou.collections.part1.chat2;

import java.util.Objects;

public class User {

    private final Integer ID;
    private final String NAME;
    private Integer age;

    public User(Integer ID, String NAME, Integer age) {
        this.ID = ID;
        this.NAME = NAME;
        this.age = age;
    }

    public Integer getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ID, user.ID) && Objects.equals(NAME, user.NAME) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, NAME, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", age=" + age +
                '}';
    }
}
