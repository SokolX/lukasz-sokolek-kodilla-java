package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> shapes = new ArrayList<>();


    public List<Shape> getShapes() {
        return shapes;
    }

    public void addFigure(Shape shape) {

    }
    public void removeFigure(Shape shape) {

    }

    public Shape getFigure(int n) {
        return null;
    }

    public void showFigures() {
        for (Shape shape : shapes) {
            System.out.println("Shape: " + shape.getShapeName() + ", area: " + shape.getArea());
        }
    }
}
