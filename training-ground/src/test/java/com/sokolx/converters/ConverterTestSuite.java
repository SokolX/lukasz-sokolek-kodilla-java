package com.sokolx.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTestSuite {

    Converter converter = new Converter();

    @Test
    void shouldReturnHexadecimalFromDecimal() {
        //given & when & then
        assertEquals("A3F2", converter.convertDecimalToHexadecimal(41970));
        assertEquals("0", converter.convertDecimalToHexadecimal(0));
        assertEquals("F", converter.convertDecimalToHexadecimal(15));
    }
    @Test
    void shouldReturnBinaryNumberFromDecimal() {
        //given & when & then
        assertEquals("101001", converter.convertDecimalToBinaryNumber(41));
        assertEquals("1000", converter.convertDecimalToBinaryNumber(8));
        assertEquals("10", converter.convertDecimalToBinaryNumber(2));
        assertEquals("1000110", converter.convertDecimalToBinaryNumber(70));
    }

}