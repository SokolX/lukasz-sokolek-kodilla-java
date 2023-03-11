package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HawaiiPizzaOrderDecorator extends AbstractBasePizzaDecoratorOrder {

    public static final String HAWAII = "Hawaii ";
    private static final String HAWAII_INGREDIENTS = " with cheese, cooked ham, and pineapple";

    public HawaiiPizzaOrderDecorator(BasePizzaOrder basePizza) {
        super(basePizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return HAWAII + super.getDescription() + HAWAII_INGREDIENTS;
    }
}
