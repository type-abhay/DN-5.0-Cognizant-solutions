package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        assertEquals(5, 2 + 3); // Assert equals: Verifies that expected value equals actual value
        assertTrue(5 > 3);      // Assert true: Verifies that a condition evaluates to true
        assertFalse(5 < 3);     // Assert false: Verifies that a condition evaluates to false
        assertNull(null);       // Assert null: Verifies that an object reference is null
        assertNotNull(new Object()); // Assert not null: Verifies that an object reference is not null
    }
}