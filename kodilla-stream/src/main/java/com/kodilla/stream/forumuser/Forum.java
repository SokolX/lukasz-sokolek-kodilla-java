package com.kodilla.stream.forumuser;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Forum {

    private final List<ForumUser> users = Arrays.asList(
            new ForumUser(1, "nickname", 'M', LocalDate.of(2000, 12, 12), 45),
            new ForumUser(2, "piter", 'M', LocalDate.of(2000, 1, 13), 5),
            new ForumUser(3, "maxmax", 'M', LocalDate.of(2000, 3, 11), 4),
            new ForumUser(4, "madmax", 'M', LocalDate.of(1987, 6, 1), 599),
            new ForumUser(5, "anton", 'M', LocalDate.of(2000, 4, 29), 0),
            new ForumUser(6, "sebek", 'M', LocalDate.of(1956, 12, 25), 456),
            new ForumUser(7, "nova", 'F', LocalDate.of(1999, 12, 24), 245),
            new ForumUser(8, "fiona", 'F', LocalDate.of(1976, 6, 8), 0),
            new ForumUser(9, "norbe", 'M', LocalDate.of(2005, 7, 22), 457),
            new ForumUser(10, "marga", 'F', LocalDate.of(2002, 9, 19), 0),
            new ForumUser(11, "kalix", 'M', LocalDate.of(2013, 12, 17), 475),
            new ForumUser(12, "bozena", 'F', LocalDate.of(2011, 11, 7), 0),
            new ForumUser(13, "amarc", 'M', LocalDate.of(1980, 2, 3), 445),
            new ForumUser(14, "monikk", 'F', LocalDate.of(1960, 2, 22), 41),
            new ForumUser(15, "patric", 'M', LocalDate.of(2002, 11, 19), 23),
            new ForumUser(16, "belucci", 'F', LocalDate.of(2002, 11, 21), 0)
    );

    public List<ForumUser> getUserList() {
        return new ArrayList<>(users);
    }
}
