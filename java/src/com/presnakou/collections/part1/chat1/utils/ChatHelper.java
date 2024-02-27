package com.presnakou.collections.part1.chat1.utils;

import com.presnakou.collections.part1.chat1.Chat;

import java.util.Iterator;
import java.util.List;

public final class ChatHelper {

    private final static Integer NUMBER_OF_USERS = 1000;

    private ChatHelper() {
    }

    public static void removeChatsLessThanAThousandUsers(List<Chat> chats) {
        for (Iterator<Chat> iterator = chats.iterator(); iterator.hasNext(); ) {
            Chat next = iterator.next();
            if (next.getNumberOfUsers() < NUMBER_OF_USERS) {
                iterator.remove();
            }
        }
    }
}
