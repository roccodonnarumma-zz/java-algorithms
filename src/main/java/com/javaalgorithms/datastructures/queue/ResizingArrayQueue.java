package com.javaalgorithms.datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The <tt>ResizingArrayQueue</tt> class represents a first-in-first-out (FIFO)
 *  queue of generic items.
 *  It supports the usual <em>enqueue</em> and <em>dequeue</em>
 *  operations, along with methods for peeking at the first item,
 *  testing if the queue is empty, and iterating through
 *  the items in FIFO order.
 *  <p>
 *  This implementation uses a resizing array, which double the underlying array
 *  when it is full and halves the underlying array when it is one-quarter full.
 *  The <em>enqueue</em> and <em>dequeue</em> operations take constant amortized time.
 *  The <em>size</em>, <em>peek</em>, and <em>is-empty</em> operations takes
 *  constant time in the worst case.
 *
 * @author rdonnarumma
 *
 */
public class ResizingArrayQueue<Item> implements Queue<Item>, Iterable<Item> {

    private Item[] q;
    private int N;
    private int first;
    private int last;

    public ResizingArrayQueue() {
        q = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }

        return q[first];
    }

    public void enqueue(Item item) {
        if (N == q.length) {
            resize(2 * q.length);
        }

        q[last++] = item;
        if (last == q.length) {
            last = 0; // wrap around
        }
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }

        Item item = q[first];
        q[first] = null;
        N--;

        first++;
        if (first == q.length) {
            first = 0; // wrap around
        }
        if (N > 0 && N == q.length / 4) {
            resize(q.length / 2);
        }

        return item;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for(int i = 0; i < q.length; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last = N;
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
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = q[(first + i) % q.length];
            i++;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
