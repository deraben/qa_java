package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int input;
    private final int expected;

    public FelineParamTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Количество котят: {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {10, 10}
        };
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(input));
    }
}