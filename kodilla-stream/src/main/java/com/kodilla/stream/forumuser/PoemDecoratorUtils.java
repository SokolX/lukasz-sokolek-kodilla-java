package com.kodilla.stream.forumuser;

import com.kodilla.stream.beautifier.PoemDecorator;

public class PoemDecoratorUtils {
    public static PoemDecorator bigger = textToModify -> textToModify.toUpperCase();
    public static PoemDecorator smaller = textToModify -> textToModify.toLowerCase();
    public static PoemDecorator textBetweenABC = textToModify -> "ABC" + textToModify.toLowerCase() + "ABC";
    public static PoemDecorator noSpace = textToModify -> textToModify.replace(" ", "");
    public static PoemDecorator repeatTen = textToModify -> textToModify.repeat(10);
    public static PoemDecorator cut = textToModify -> textToModify.substring(5,10);
}
