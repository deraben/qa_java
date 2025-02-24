package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        // Ожидаем, что вернётся список для "Хищник"
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensNoArgs() {
        Feline feline = new Feline();
        // По умолчанию в методе getKittens() вызывается getKittens(1)
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithArgs() {
        Feline feline = new Feline();
        // Проверим перегруженный метод getKittens(int kittensCount)
        assertEquals(5, feline.getKittens(5));
    }
}