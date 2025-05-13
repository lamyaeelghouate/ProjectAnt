package com.app;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class calculatorTest {
    private calculator calculator;

    @Before
    public void setUp() {
        calculator = new calculator();
    }

    @Test
    public void testAddition() {
        assertEquals(15, calculator.add(10, 5));
            }
        
            private void assertEquals(int i, int j) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
            }
        
            @Test
    public void testSoustraction() {
        assertEquals(5, calculator.subtract(10, 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(50, calculator.multiply(10, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionParZero() {
        calculator.divide(10, 0);
    }
}