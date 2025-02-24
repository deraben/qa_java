package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParamTest {

    private final String input;
    private final List<String> expected;

    public AnimalParamTest(String input, List<String> expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Вид животного: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();
        List<String> result = animal.getFood(input);
        assertEquals(expected, result);
    }
}