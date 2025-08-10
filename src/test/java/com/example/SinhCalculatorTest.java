package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinhCalculatorTest {

    private SinhCalculatorGUI calculator;

    @BeforeEach
    public void setUp() {
        calculator = new SinhCalculatorGUI();
    }

    @Test
    public void testSinhZero() {
        double result = calculator.computeSinh(0.0,10);
        assertEquals(0.0, result, 1e-9);
    }

    @Test
    public void testSinhPositive() {
        double x = 1.0;
        double expected = Math.sinh(x); // Using Java's built-in sinh for reference
        double result = calculator.computeSinh(x,10);
        assertEquals(expected, result, 1e-9);
    }

    @Test
    public void testSinhNegative() {
        double input = -1.0;
        double expected = Math.sinh(input);
        double result = calculator.computeSinh(input,10);
        assertEquals(expected, result, 1e-9);
    }

    @Test
    public void testSinhLargeValue() {
        double input = 5.0;
        double expected = Math.sinh(input);
        double result = calculator.computeSinh(input,20);
        assertEquals(expected, result, 1e-9);
    }
}
