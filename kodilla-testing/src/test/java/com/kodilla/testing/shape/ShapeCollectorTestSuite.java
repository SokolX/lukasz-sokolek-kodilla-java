package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("TDD: ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Tests for adding figures")
    class AddFigures {
        @Test
        void shouldGetShapesWhenListIsNotEmpty() {
            //given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(4);
            Shape triangle = new Triangle(7,5,4);
            Shape circle = new Circle(4);
            //when
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(circle);
            //then
            Assertions.assertEquals(3, shapeCollector.getShapes().size());
        }

        @Test
        void shouldGetShapesWhenListIsEmpty() {
            //given
            ShapeCollector shapeCollector = new ShapeCollector();

            //when

            //then
            Assertions.assertEquals(0, shapeCollector.getShapes().size());
        }
    }
}
