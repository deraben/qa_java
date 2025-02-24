package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class AnimalTest {

    @Test
    public void testGetFoodHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void testGetFoodPredator() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test(expected = Exception.class)
    public void testGetFoodException() throws Exception {
        Animal animal = new Animal();
        // Ожидаем, что выбросится Exception
        animal.getFood("Неизвестный вид");
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, " +
                "кошачьи, псовые, медвежьи, куньи", family);
    }
}