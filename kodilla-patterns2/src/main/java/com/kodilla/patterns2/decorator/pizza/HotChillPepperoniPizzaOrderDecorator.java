package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HotChillPepperoniPizzaOrderDecorator extends AbstractBasePizzaDecoratorOrder {

    private static final String HOT_CHILLI_PEPPERONI = "Hot Chilli Pepperoni ";
    private static final String HOT_CHILLI_PEPPERONI_INGREDIENTS = " with olive oil, oregano, tomato, olives, mozzarella";

    public HotChillPepperoniPizzaOrderDecorator(BasePizzaOrder basePizza) {
        super(basePizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(15));
    }

    @Override
    public String getDescription() {
        return HOT_CHILLI_PEPPERONI + super.getDescription() + HOT_CHILLI_PEPPERONI_INGREDIENTS;
    }
}
