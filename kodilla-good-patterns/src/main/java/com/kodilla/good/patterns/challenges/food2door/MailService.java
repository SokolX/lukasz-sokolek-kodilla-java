package com.kodilla.good.patterns.challenges.food2door;

public class MailService implements InformationService {
    @Override
    public void inform(Producer producer) {
        System.out.println("Inform " + producer.getProducerName() + " about new order");
    }
}
