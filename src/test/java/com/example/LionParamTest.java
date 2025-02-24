package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, ожидаем грива = {1}")
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    private void injectFeline(Lion lion, Feline feline) throws Exception {
        Field field = Lion.class.getDeclaredField("feline");
        field.setAccessible(true);
        field.set(lion, feline);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Feline realFeline = new Feline();
        Lion lion = new Lion(sex);
        injectFeline(lion, realFeline);
        assertEquals("Неверный статус гривы", expectedHasMane, lion.doesHaveMane());
    }
}
