package com.presnakou.collections.part1.chat1;

import java.util.Objects;

public class Chat implements Comparable<Chat> {

    private String name;
    private Integer numberOfUsers;

    public Chat(String name, Integer numberOfUsers) {
        this.name = name;
        this.numberOfUsers = numberOfUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(Integer numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(name, chat.name) && Objects.equals(numberOfUsers, chat.numberOfUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfUsers);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                '}';
    }

    @Override
    public int compareTo(Chat o) {
        return name.compareTo(o.getName());
    }
}
