package com.kodilla.testing.shape;

public class Square implements Shape {

    private int a;

    public Square(int a) {
        this.a = a;
    }

    @Override
    public String getShapeName() {
        return Square.class.getSimpleName();
    }

    @Override
    public double getArea() {
        return countAreaSquare(a);
    }

    private double countAreaSquare(int a) {
        return 4 * a;
    }
}
