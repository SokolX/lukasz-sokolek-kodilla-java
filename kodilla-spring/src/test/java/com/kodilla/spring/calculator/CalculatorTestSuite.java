package com.kodilla.spring.calculator;

import com.kodilla.spring.library.Library;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorTestSuite {

    @Test
    void testCalculations() {
        // given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        // when & then
        assertAll(
                () -> assertEquals(4.0, calculator.add(1, 3)),
                () -> assertEquals(-2.0, calculator.sub(1, 3)),
                () -> assertEquals(18.0, calculator.mul(6, 3)),
                () -> assertEquals(2.0, calculator.div(4, 2))

        );
    }

}