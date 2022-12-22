package com.kodilla.patterns.builder.cheeseburger;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class Cheeseburger {

    private String bun;
    private int burgers;
    private String sauce;
    @Singular
    private List<String> ingredients;

}
