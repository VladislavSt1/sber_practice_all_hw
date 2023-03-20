package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testAddAndGet() {
        LinkedList list = new LinkedList();
        list.add("one");
        list.add("two");
        list.add("three");
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
    }

    @Test
    void testGetInvalidIndex() {
        LinkedList list = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add("one");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void testSize() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());
        list.add("one");
        assertEquals(1, list.size());
        list.add("two");
        assertEquals(2, list.size());
        list.add("three");
        assertEquals(3, list.size());
    }

}
