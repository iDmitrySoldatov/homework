package org.example.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {
    @Test
    public void testCreateEmptyList() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testCreateListWithCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>(10);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testAddLast() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void testAddIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexThrowsException() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(-999, 5);
    }

    @Test
    public void testSet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.set(1, 999);

        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(999), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetThrowsException() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.set(0, 999);
    }

    @Test
    public void testRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);

        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveThrowsException() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.remove(0);
    }

    @Test
    public void testGet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetThrowsException() {
        MyArrayList<String> list = new MyArrayList<>();
        list.get(0);
    }

    @Test
    public void testClear() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testSize() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    public void testIsEmpty() {
        MyArrayList<String> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
        list.add("test");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        MyArrayList.sort(list, Integer::compareTo);
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void testExpandList() {
        MyArrayList<Integer> list = new MyArrayList<>(2);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

}