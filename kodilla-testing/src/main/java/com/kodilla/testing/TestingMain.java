package com.kodilla.testing;

import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.ShapeCollector;

public class TestingMain {

    public static void main(String[] args) {
        ShapeCollector shape = new ShapeCollector();
        shape.addFigure(new Circle(4));
        shape.addFigure(new Circle(4));
        System.out.println(shape.showFigures());
    }
}
