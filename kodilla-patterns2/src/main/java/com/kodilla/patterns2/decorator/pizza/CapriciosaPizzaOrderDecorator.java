package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class CapriciosaPizzaOrderDecorator extends AbstractBasePizzaDecoratorOrder {

    private static final String CAPRICIOSA = "Capriciosa ";
    private static final String CAPRICIOSA_INGREDIENTS = " with olive oil, oregano, tomato, olives, mozzarella";

    public CapriciosaPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(20));
    }

    @Override
    public String getDescription() {
        return CAPRICIOSA + super.getDescription() + CAPRICIOSA_INGREDIENTS;
    }
}
