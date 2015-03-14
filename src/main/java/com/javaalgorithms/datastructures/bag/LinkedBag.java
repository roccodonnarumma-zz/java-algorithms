package com.javaalgorithms.datastructures.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The <tt>LinkedBag</tt> class represents a bag (or multiset) of
 *  generic items. It supports insertion and iterating over the
 *  items in arbitrary order.
 *  <p>
 *  This implementation uses a singly-linked list with a non-static nested class Node.
 *  The <em>add</em>, <em>isEmpty</em>, and <em>size</em> operations
 *  take constant time. Iteration takes time proportional to the number of items.
 *
 * @author rdonnarumma
 *
 */
public class LinkedBag<Item> implements Bag<Item>, Iterable<Item> {

    private int N;
    private Node first;

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
        N++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
