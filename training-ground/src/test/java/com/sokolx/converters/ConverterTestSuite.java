package com.sokolx.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTestSuite {

    Converter converter = new Converter();

    @Test
    void shouldHexadecimalFromDecimal() {
        //given & when & then
        assertEquals("A3F2", converter.convertDecimalToHexadecimal(41970));
        assertEquals("0", converter.convertDecimalToHexadecimal(0));
        assertEquals("F", converter.convertDecimalToHexadecimal(15));
    }

}