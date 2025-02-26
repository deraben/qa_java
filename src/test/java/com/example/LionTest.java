package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    Feline felineMock;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    private void injectFeline(Lion lion, Feline feline) throws Exception {
        Field field = Lion.class.getDeclaredField("feline");
        field.setAccessible(true);
        field.set(lion, feline);
    }

    @Test
    public void testLionDoesHaveManeMale() throws Exception {
        Lion lion = new Lion("Самец");
        injectFeline(lion, felineMock);
        assertTrue("У самца должна быть грива", lion.doesHaveMane());
    }

    @Test
    public void testLionDoesHaveManeFemale() throws Exception {
        Lion lion = new Lion("Самка");
        injectFeline(lion, felineMock);
        assertFalse("У самки не должно быть гривы", lion.doesHaveMane());
    }

    @Test
    public void testLionConstructorException() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Используйте допустимые значения пола животного - самей или самка");
        new Lion("Неизвестный пол");
    }

    @Test
    public void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец");
        injectFeline(lion, felineMock);

        int kittensCount = lion.getKittens();
        assertEquals(3, kittensCount);
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Мясо", "Рыба"));

        Lion lion = new Lion("Самка");
        injectFeline(lion, felineMock);

        List<String> food = lion.getFood();
        assertEquals(List.of("Мясо", "Рыба"), food);
        verify(felineMock).getFood("Хищник");
    }
}
