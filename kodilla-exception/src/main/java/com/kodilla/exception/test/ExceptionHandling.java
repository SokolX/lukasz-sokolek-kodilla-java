package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(1.5, 5.0);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Always shows");
        }
    }
}
