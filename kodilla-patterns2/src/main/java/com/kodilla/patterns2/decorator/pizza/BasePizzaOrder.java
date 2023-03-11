package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasePizzaOrder implements PizzaOrder {

    public static final String BASE_PIZZA_ORDER_DESCRIPTION = "Pizza with tomato sauce";

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("15.00");
    }

    @Override
    public String getDescription() {
        return BASE_PIZZA_ORDER_DESCRIPTION;
    }
}
