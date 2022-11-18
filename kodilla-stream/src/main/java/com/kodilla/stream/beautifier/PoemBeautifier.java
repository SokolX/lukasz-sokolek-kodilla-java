package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String textToModify, PoemDecorator poemDecorator) {
        System.out.println(poemDecorator.decorate(textToModify));
    }
}
