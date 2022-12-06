package com.kodilla.good.patterns.challenges.example1;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Inform " + user.toString() + " about recived payments via mail");
    }
}
