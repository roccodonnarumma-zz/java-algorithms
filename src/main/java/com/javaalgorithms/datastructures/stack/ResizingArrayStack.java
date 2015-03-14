package com.javaalgorithms.datastructures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author rdonnarumma
 *
 */
public class ResizingArrayStack<Item> implements Stack<Item>, Iterable<Item> {

    private Item[] a;
    private int N;

    public ResizingArrayStack() {
        a = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }

        a[N++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }

        Item item = a[N - 1];
        a[N - 1] = null;
        N--;

        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }

        return item;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }

        a = temp;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i;

        public ReverseArrayIterator() {
            i = N - 1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
