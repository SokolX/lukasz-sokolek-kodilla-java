package com.kodilla.patterns.builder.cheeseburger;

import com.kodilla.patterns.builder.bigmac.Bigmac;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheeseburgerTestSuite {

    @Test
    void testCheeseBurgerNew() {
        //given
        Cheeseburger cheeseburger = Cheeseburger
                .builder()
                .ingredient("Salat")
                .ingredient("onion")
                .ingredient("bacon")
                .ingredient("cucumber")
                .ingredient("chilli")
                .burgers(2)
                .sauce("barbecue")
                .bun("sezam bun")
                .build();

        //when
        int howManyIngredients = cheeseburger.getIngredients().size();

        //then
        assertEquals(5, howManyIngredients);

    }

    @Test
    void testCheeseBurgerRequiredArgsNew() {
        //given

        Cheeseburger cheeseburger = new Cheeseburger("bun", 2, "asdas", List.of("1231"));
        //when
        int howManyIngredients = cheeseburger.getIngredients().size();

        //then
        assertEquals(1, howManyIngredients);

    }
}