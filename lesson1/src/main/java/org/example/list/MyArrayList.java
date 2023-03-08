package org.example.list;

import java.util.Comparator;

/**
 * Реализация ArrayList
 * Функционал :
 * добавление элемента в конец списка и по индексу, вставка элемента по индексу,получение по индексу,
 * удаление по индексу, очистка списка,размер списка, проверка списка на пустоту, сортировка(quick sort)
 *
 * @param <E> тип элементов в списке
 */
public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 16;

    private int size;

    private E[] elements;

    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Дополнительный конструктор с возможностью установить capacity
     *
     * @param capacity изначальная вместительность листа
     */
    public MyArrayList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    /**
     * Добавляет элемент в конец списка
     *
     * @param element элемент для добавления
     */
    public void add(E element) {
        if (size == elements.length) expand();

        elements[size++] = element;
    }

    /**
     * Добавляет элемент по индексу
     *
     * @param index   индекс куда нужно добавить элемент
     * @param element элемент для добавления
     * @throws IndexOutOfBoundsException если индекс находится за пределами списка
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (size == elements.length) expand();

        for (int i = size; i < index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * Вставка элемента по индексу
     *
     * @param index   индекс элемента
     * @param element элемент
     * @throws IndexOutOfBoundsException если индекс находится за пределами списка
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        elements[index] = element;
    }

    /**
     * Удаляет элемент по индексу
     *
     * @param index индекс удаляемого элемента
     * @throws IndexOutOfBoundsException если индекс находится за пределами списка
     */
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    /**
     * Возвращает элемент списка по индексу
     *
     * @param index индекс элемента
     * @return элемент списка
     * @throws IndexOutOfBoundsException если индекс находится за пределами списка
     */
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        return elements[index];
    }

    /**
     * Очищает список
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Возвращает размер списка
     *
     * @return размер списка
     */
    public int size() {
        return size;
    }

    /**
     * Проверка списка, есть ли в нем элементы
     *
     * @return пустой или нет
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Сортировка списка с компаратором
     *
     * @param list       лист для сортировки
     * @param comparator компаратор для сортировки
     * @param <T>        тип для листа и компаратора
     */
    public static <T> void sort(MyArrayList<T> list, Comparator<T> comparator) {
        if (list == null || list.size <= 1) return;

        quickSort(list, 0, list.size - 1, comparator);
    }

    //Алгоритм быстрой сортировки
    private static <T> void quickSort(MyArrayList<T> list, int left, int right, Comparator<T> comparator) {
        if (left >= right) return;

        int pivotIndex = partition(list, left, right, comparator);
        quickSort(list, left, pivotIndex - 1, comparator);
        quickSort(list, pivotIndex + 1, right, comparator);
    }

    //Возращает партишион и сортирует
    private static <T> int partition(MyArrayList<T> list, int left, int right, Comparator<T> comparator) {
        int wall = left - 1;
        T pivot = list.get(right);
        for (int i = left; i < right; i++) {
            if (comparator.compare(list.get(i), pivot) <= 0) {
                wall++;
                swap(list, wall, i);
            }
        }
        swap(list, wall + 1, right);
        return wall + 1;
    }

    //Обмен элементов индексами
    private static <T> void swap(MyArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    //Расширяет вместительность массива в 2 раза
    private void expand() {
        E[] newArray = (E[]) new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }
}
