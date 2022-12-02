package com.kodilla.good.patterns.challanges.example;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Inform " + user.toString() + " about payments via mail");
    }
}
