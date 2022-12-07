package com.kodilla.good.patterns.challenges.food2door.dto;


import com.kodilla.good.patterns.challenges.food2door.model.Producer;

public class ProducerDto {

    private Producer producer;
    private boolean isProducer;

    public ProducerDto(final Producer producer, final boolean isProducer) {
        this.producer = producer;
        this.isProducer = isProducer;
    }

    public Producer getProducer() { return producer; }

    public boolean isProducer() { return isProducer; }
}
