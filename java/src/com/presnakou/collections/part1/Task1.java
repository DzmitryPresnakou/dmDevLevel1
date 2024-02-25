package com.presnakou.collections.part1;

import com.presnakou.collections.part1.chat1.Chat;
import com.presnakou.collections.part1.chat1.comparator.ChatNumberOfUsersAndNameComparator;
import com.presnakou.collections.part1.chat1.utils.ChatHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * <p>
 * Задача:
 * <p>
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * <p>
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * <p>
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */

public class Task1 {

    public static void main(String[] args) {

        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("super chat", 2080));
        chats.add(new Chat("chat2", 1050));
        chats.add(new Chat("chat3", 2577));
        chats.add(new Chat("chat4", 147));
        chats.add(new Chat("chat5", 850));
        chats.add(new Chat("chat6", 2080));
        chats.add(new Chat("chat7", 537));
        chats.add(new Chat("a new chat", 2080));

        Collections.sort(chats);
        System.out.println(chats);

        ChatHelper.removeChatsLessThanAThousandUsers(chats);
        System.out.println(chats);

        chats.sort(new ChatNumberOfUsersAndNameComparator());
        System.out.println(chats);
    }
}
