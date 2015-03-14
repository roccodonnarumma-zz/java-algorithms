package com.javaalgorithms.datastructures.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The <tt>ResizingArrayBag</tt> class represents a bag (or multiset) of
 *  generic items. It supports insertion and iterating over the
 *  items in arbitrary order.
 *  <p>
 *  This implementation uses a resizing array.
 *  The <em>add</em> operation takes constant amortized time; the
 *  <em>isEmpty</em>, and <em>size</em> operations
 *  take constant time. Iteration takes time proportional to the number of items.
 *
 * @author rdonnarumma
 *
 */
public class ResizingArrayBag<Item> implements Bag<Item>, Iterable<Item> {

    private Item[] a;
    private int N;

    public ResizingArrayBag() {
        a = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }

        a[N++] = item;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < N;
        }

        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            return a[i++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
