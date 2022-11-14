package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("TDD: ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {
    @Nested
    @DisplayName("Tests for update list figures in shape collector")
    class UpdateCollectorFigures {
        @Test
        @DisplayName("Tests add shape to shapeCollector")
        void shouldAddShapeToShapeCollector() {
            //given
            ShapeCollector shapeCollector = new ShapeCollector();

            //when
            shapeCollector.addFigure(new Square(4));
            shapeCollector.addFigure(new Triangle(7,5,4));
            shapeCollector.addFigure(new Circle(4));

            //then
            Assertions.assertEquals(3, shapeCollector.getShapes().size());
        }

        @Test
        @DisplayName("Tests remove shape to shapeCollector")
        void shouldRemoveShapeToShapeCollector() {
            //given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(4);
            Shape triangle = new Triangle(7,5,4);
            Shape circle = new Circle(4);
            //when
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(circle);
            shapeCollector.removeFigure(circle);
            //then
            Assertions.assertEquals(2, shapeCollector.getShapes().size());
        }
    }

    @Nested
    @DisplayName("Tests for get list figures in shape collector")
    class GetCollectorFigures {
        @Test
        @DisplayName("Tests get shapes from shapeCollector")
        void shouldGetShapeFromShapeCollector() {
            //given
            ShapeCollector shapeCollector = new ShapeCollector();

            //when
            shapeCollector.addFigure(new Square(4));
            shapeCollector.addFigure(new Triangle(7,5,4));
            shapeCollector.addFigure(new Circle(4));
            Shape shape = shapeCollector.getFigure(1);

            //then
            Assertions.assertEquals("Triangle", shape.getShapeName());
        }

        @Test
        @DisplayName("Tests remove shape to shapeCollector")
        void shouldShowShapeFromShapeCollector() {
            //given
            ShapeCollector shapeCollector = new ShapeCollector();

            //when
            shapeCollector.addFigure(new Square(4));
            shapeCollector.addFigure(new Triangle(7,5,4));
            shapeCollector.addFigure(new Circle(4));
            String figures = shapeCollector.showFigures();

            //then
            Assertions.assertNotNull(figures);
        }
    }
}

