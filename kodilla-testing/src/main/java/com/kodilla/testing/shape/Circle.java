package com.kodilla.testing.shape;

public class Circle implements Shape {

    private int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public String getShapeName() {
        return Circle.class.getSimpleName();
    }

    @Override
    public double getArea() {
        return Math.PI * (r * r);
    }
}
