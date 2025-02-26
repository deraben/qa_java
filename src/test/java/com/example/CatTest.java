package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    @Mock
    Feline felineMock; // Мок вместо реального Feline

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSound() {
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        // Настраиваем мок, чтобы eatMeat() возвращал некий список
        when(felineMock.eatMeat()).thenReturn(List.of("Курица", "Говядина"));

        Cat cat = new Cat(felineMock);
        List<String> food = cat.getFood();

        // Проверяем, что вернулся именно тот список
        assertEquals(List.of("Курица", "Говядина"), food);
        // И убеждаемся, что у мока был вызван метод eatMeat()
        verify(felineMock, times(1)).eatMeat();
    }
}