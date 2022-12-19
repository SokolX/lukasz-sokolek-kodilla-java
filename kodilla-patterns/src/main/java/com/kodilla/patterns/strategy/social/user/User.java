package com.kodilla.patterns.strategy.social.user;

import com.kodilla.patterns.strategy.social.publisher.SocialPublisher;

public sealed class User permits YGeneration, ZGeneration, Millenials {

    private final String name;
    SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
