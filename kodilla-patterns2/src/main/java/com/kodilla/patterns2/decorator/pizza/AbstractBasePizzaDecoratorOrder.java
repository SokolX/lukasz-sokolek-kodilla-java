package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public abstract class AbstractBasePizzaDecoratorOrder implements PizzaOrder {

    private final PizzaOrder pizzaOrder;

    public AbstractBasePizzaDecoratorOrder(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getPrice() {
        return pizzaOrder.getPrice();
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }
}
