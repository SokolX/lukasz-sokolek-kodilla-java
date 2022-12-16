package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.TwitterPublisher;
import com.kodilla.patterns.strategy.social.user.Millenials;
import com.kodilla.patterns.strategy.social.user.User;
import com.kodilla.patterns.strategy.social.user.YGeneration;
import com.kodilla.patterns.strategy.social.user.ZGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //given
        User userGenerationY = new YGeneration("Marian");
        User userGenerationZ = new ZGeneration("Justin");
        User userMillenials = new Millenials("Alan");

        //when
        String marianShouldPosted = userGenerationY.sharePost();
        String alanShouldPosted = userMillenials.sharePost();
        String justinShouldPosted = userGenerationZ.sharePost();
        System.out.println(userGenerationY.getName() + marianShouldPosted);
        System.out.println(userMillenials.getName() + alanShouldPosted);
        System.out.println(userGenerationZ.getName() + justinShouldPosted);

        //then
        assertEquals(" share on Twitter", marianShouldPosted);
        assertEquals(" share on Facebook", alanShouldPosted);
        assertEquals(" share on Snapchat", justinShouldPosted);
    }

    @Test
    void testIndividualSharingStrategy() {
        //given
        User jessica = new ZGeneration("Jessica");

        //when
        String justinShouldPosted = jessica.sharePost();
        System.out.println(jessica.getName() + justinShouldPosted);
        jessica.setSocialPublisher(new TwitterPublisher());
        justinShouldPosted = jessica.sharePost();
        System.out.println(jessica.getName() + justinShouldPosted);

        //then
        assertEquals(" share on Twitter", justinShouldPosted);
        assertNotEquals(" share on Snapchat", justinShouldPosted);
    }
}