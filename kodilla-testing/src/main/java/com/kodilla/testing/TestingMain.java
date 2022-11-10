package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        if (calculator.add(5, 6) == 11) {
            System.out.println("test added OK");
        } else {
            System.out.println("Error added!");
        }

        if (calculator.subtract(7, 2) == -5) {
            System.out.println("test substract OK");
        } else {
            System.out.println("Error substract!");
        }
    }
}
