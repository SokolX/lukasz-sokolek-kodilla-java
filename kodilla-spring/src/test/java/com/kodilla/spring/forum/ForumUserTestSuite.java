package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForumUserTestSuite {

    @Test
    void testGetUsername() {
        //given
        ForumUser forumUser = new ForumUser();
        //when
        String nameFromConstructor = forumUser.getUsername();
        //then
        assertEquals("John Smith", nameFromConstructor);
    }

}