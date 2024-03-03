package com.presnakou.collections.part1;

import com.presnakou.collections.part1.chat2.Chat;
import com.presnakou.collections.part1.chat2.User;
import com.presnakou.collections.part1.chat2.utils.ChatUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей”
 * будет список объектов типа Пользователь, который имеет 3 поля:
 * id (целочисленный идентификатор), имя и возраст.
 * <p>
 * Задача:
 * <p>
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 * <p>
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */
public class Task2 {

    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("chat1", List.of(
                new User(1, "Vasya", 24),
                new User(2, "Kirill", 16))));
        chats.add(new Chat("chat2", List.of(
                new User(3, "Vanya", 17),
                new User(4, "Masha", 19))));
        chats.add(new Chat("chat3", List.of(
                new User(5, "Kolya", 22),
                new User(6, "Misha", 20))));
        chats.add(new Chat("chat4", List.of(
                new User(7, "Venya", 26),
                new User(8, "Dima", 25))));

        System.out.println(chats);

        List<User> users = ChatUtil.saveUsersMoreThanEighteenYearsOld(chats);
        System.out.println(users);

        System.out.println(ChatUtil.calculateAverageUsersAge(users));
    }
}
