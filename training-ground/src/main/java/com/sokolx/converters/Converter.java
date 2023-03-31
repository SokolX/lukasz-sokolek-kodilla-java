package com.sokolx.converters;

import java.util.HashMap;
import java.util.Map;

public class Converter {

    private static final Map<Integer, String> DECIMAL_TO_HEXADECIMAL_MAP = new HashMap<>() {{
        put(0, "0");
        put(1, "1");
        put(2, "2");
        put(3, "3");
        put(4, "4");
        put(5, "5");
        put(6, "6");
        put(7, "7");
        put(8, "8");
        put(9, "9");
        put(10, "A");
        put(11, "B");
        put(12, "C");
        put(13, "D");
        put(14, "E");
        put(15, "F");
    }};

    public String convertDecimalToHexadecimal(int decimal) {
        String hexadecimalResultString = "";

        if(decimal == 0) {
            return mapIntToHex(decimal);
        }

        while(decimal != 0) {
            int rest = decimal / 16;
            int result = decimal % 16;
            decimal = rest;
            hexadecimalResultString = mapIntToHex(result) + hexadecimalResultString;
        }

        return hexadecimalResultString;
    }

    public String convertDecimalToBinaryNumber(int decimal) {

        String binaryResultString = "";
        if(decimal == 0) {
            return mapIntToHex(decimal);
        }

        while(decimal != 0) {
            int rest = decimal / 2;
            int result = decimal % 2;
            decimal = rest;
            binaryResultString = result + binaryResultString;
        }

        return binaryResultString;
    }

    private String mapIntToHex(int hex) {
        return DECIMAL_TO_HEXADECIMAL_MAP.get(hex);
    }
}