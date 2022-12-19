package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
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
        int howManyIngredients = bigmac.getIngredients().size();

        //then
        assertEquals(5, howManyIngredients);

    }
}