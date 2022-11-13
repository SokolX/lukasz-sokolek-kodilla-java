package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getShapeName() {
        return Triangle.class.getSimpleName();
    }

    @Override
    public double getArea() {
        if (!isTriangleValid(a, b, c)) {
            System.out.println("Sides entered cannot form a triangle!");
        }
        return countAreaTriangle(a, b, c);
    }

    private double countAreaTriangle(int a, int b, int c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private boolean isTriangleValid(int a, int b, int c) {
        if((a + b) > c && (a + c) > b && (b + c) > a) {
            return true;
        }else {
            return false;
        }
    }
}
