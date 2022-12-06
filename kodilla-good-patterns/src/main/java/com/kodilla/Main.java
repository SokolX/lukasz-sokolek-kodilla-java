package com.kodilla;

import com.kodilla.good.patterns.challenges.example0.MovieStore;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        System.out.printf(movieStore.getMovies().entrySet().stream()
                .flatMap(movie -> movie.getValue().stream())
                .collect(Collectors.joining("!")));
    }
}