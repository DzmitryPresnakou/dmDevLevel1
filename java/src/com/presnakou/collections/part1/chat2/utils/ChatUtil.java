package com.presnakou.collections.part1.chat2.utils;

import com.presnakou.collections.part1.chat2.Chat;
import com.presnakou.collections.part1.chat2.User;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ChatUtil {

    private ChatUtil() {
    }

    public static List<User> saveUsersMoreThanEighteenYearsOld(List<Chat> chats) {
        List<User> newUsers = new LinkedList<>();
        for (Iterator<Chat> iterator = chats.iterator(); iterator.hasNext(); ) {
            Chat nextChat = iterator.next();
            for (Iterator<User> iterator2 = nextChat.getUsers().iterator(); iterator2.hasNext(); ) {
                User nextUser = iterator2.next();
                if (nextUser.getAge() >= 18) {
                    newUsers.add(nextUser);
                }
            }
        }
        return newUsers;
    }

    public static double calculateAverageUsersAge(List<User> users) {
        double sumAge = 0;
        for (User next : users) {
            sumAge += next.getAge();
        }
        return sumAge / users.size();
    }
}

