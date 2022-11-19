package com.kodilla;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.FunctionalCalculator;
import com.kodilla.stream.lambda.Processor;

import java.util.Locale;

public class StreamMain {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Text To Modify", textToModify -> textToModify.toUpperCase());
        poemBeautifier.beautify("Text To Modify", textToModify -> textToModify.toLowerCase());
        poemBeautifier.beautify("Text To Modify", textToModify -> "ABC" + textToModify.toLowerCase() + "ABC");
        poemBeautifier.beautify("Text To Modify", textToModify -> textToModify.replace(" ", ""));
        poemBeautifier.beautify("Text To Modify", textToModify -> textToModify.repeat(10));
        poemBeautifier.beautify("Text To Modify", textToModify -> textToModify.substring(5,10));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}