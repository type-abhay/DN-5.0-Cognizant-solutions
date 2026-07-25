package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Created a new Calculator instance.");
    }

    @After
    public void tearDown() {
        calculator.reset();
        calculator = null;
        System.out.println("Teardown: Reset and cleaned up Calculator instance.");
    }

    @Test
    public void testAdditionUsingAAA() {
        // 1. Arrange
        int numberToAdd = 10;
        int expectedResult = 10;

        // 2. Act
        calculator.add(numberToAdd);

        // 3. Assert
        assertEquals(expectedResult, calculator.getResult());
    }

    @Test
    public void testSubtractionUsingAAA() {
        // 1. Arrange
        calculator.add(20); 
        int numberToSubtract = 5;
        int expectedResult = 15;

        // 2. Act
        calculator.subtract(numberToSubtract);

        // 3. Assert
        assertEquals(expectedResult, calculator.getResult());
    }
}