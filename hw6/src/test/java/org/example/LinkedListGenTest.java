package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListGenTest {
    @Test
    void genTestAddAndGet() {
        LinkedListGen<String> list = new LinkedListGen<>();
        list.add("a");
        list.add("b");
        list.add("c");
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
    }

    @Test
    void genTestSize() {
        LinkedListGen<String> list = new LinkedListGen<>();
        assertEquals(0, list.size());
        list.add("a");
        assertEquals(1, list.size());
        list.add("b");
        assertEquals(2, list.size());
        list.add("c");
        assertEquals(3, list.size());
    }

    @Test
    void genTestGetOutOfBounds() {
        LinkedListGen<String> list = new LinkedListGen<>();
        assertNull(list.get(0));
        list.add("a");
        assertNull(list.get(1));
        assertNull(list.get(-1));
    }
}
