package com.presnakou.collections.part1.chat1.comparator;

import com.presnakou.collections.part1.chat1.Chat;

import java.util.Comparator;

public class ChatNumberOfUsersAndNameComparator implements Comparator<Chat> {

    @Override
    public int compare(Chat o1, Chat o2) {
        return (o1.getNumberOfUsers() == o2.getNumberOfUsers()) ?
                o1.getName().compareTo(o2.getName()) :
                Integer.compare(o2.getNumberOfUsers(), o1.getNumberOfUsers());
    }
}
