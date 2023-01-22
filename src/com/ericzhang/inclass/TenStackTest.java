package com.ericzhang.inclass;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

/**
 * @author Eric Zhang
 * @version 1.0
 */

public class TenStackTest {
    // TODO: Write JUnit tests below

    private TenStack stack;

    @BeforeEach
    public void createStack() {
        stack = new TenStack();
    }

    @Test
    public void isEmptyTest() {
//        TenStack t = new TenStack();
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void pushTest() {
        TenStack t = new TenStack();
        t.push(1);
        assertEquals(t.peek(), 1);
    }

    @Test
    public void pushException() {
        TenStack t = new TenStack();
        for (int i = 0; i < 10; i++) {
            t.push(1);
        }

        assertThrows(IllegalStateException.class, () -> {t.push(1);});

        TenStack t2 = new TenStack();

    }
}
