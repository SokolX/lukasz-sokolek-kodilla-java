package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTestSuite {

    @Test
    void testBasePizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasePizzaOrder();

        //When
        BigDecimal calculateCost = pizzaOrder.getPrice();

        //Then
        assertEquals(new BigDecimal(15), calculateCost);
    }

    @Test
    void testBasePizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasePizzaOrder();

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza with tomato sauce", description);
    }

    @Test
    void testCapriciosaPizzaGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasePizzaOrder();
        pizzaOrder = new CapriciosaPizzaOrderDecorator(pizzaOrder);

        //When
        BigDecimal theCost = pizzaOrder.getPrice();

        //Then
        assertEquals(new BigDecimal(35), theCost);
    }

    @Test
    void testCapriciosaPizzaGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasePizzaOrder();
        pizzaOrder = new CapriciosaPizzaOrderDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Capriciosa Pizza with tomato sauce with olive oil, oregano, tomato, olives, mozzarella", description);
    }

    @Test
    void testCapriciosaWithExtraCheesePizzaGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasePizzaOrder();
        pizzaOrder = new CapriciosaPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new CheeseDecorator(pizzaOrder);
        pizzaOrder = new CheeseDecorator(pizzaOrder);

        //When
        BigDecimal theCost = pizzaOrder.getPrice();

        //Then
        assertEquals(new BigDecimal(41), theCost);
    }

    @Test
    void testCapriciosaPizzaWithExtraCheeseGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasePizzaOrder();
        pizzaOrder = new CapriciosaPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new CheeseDecorator(pizzaOrder);
        pizzaOrder = new CheeseDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Capriciosa Pizza with tomato sauce with olive oil, oregano, tomato, olives, mozzarella + cheese + cheese", description);
    }

}