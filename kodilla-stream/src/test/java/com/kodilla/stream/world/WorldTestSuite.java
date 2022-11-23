package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //given

        Country poland = new Country("Poland", new BigDecimal("38000000"));
        Country germany = new Country("Germany", new BigDecimal("83000000"));
        Country france = new Country("France", new BigDecimal("67000000"));
        Continent europe = new Continent("Europe", Arrays.asList(poland, germany, france));

        Country japan = new Country("Japan", new BigDecimal("125000000"));
        Country northKorea = new Country("North Korea", new BigDecimal("25000000"));
        Country soutKorea = new Country("South Korea", new BigDecimal("51000000"));
        Continent asia = new Continent("Asia", List.of(japan, northKorea, soutKorea));

        Country morocco = new Country("Morocco", new BigDecimal("37340000"));
        Country senegal = new Country("Senegal", new BigDecimal("17200000"));
        Country egypt = new Country("Egypt", new BigDecimal("104300000"));
        Continent africa = new Continent("Africa", List.of(morocco, senegal, egypt));
        World world = new World(Arrays.asList(europe, asia, africa));
        //when
        BigDecimal counterPeople = world.getPeopleQuantity();

        //then
        BigDecimal expectedCounterPeople = new BigDecimal("547840000");
        assertEquals(expectedCounterPeople, counterPeople);
    }
}
