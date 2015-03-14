package com.javaalgorithms.datastructures.bag;

/**
 * @author rdonnarumma
 *
 */
public interface Bag<Item> extends Iterable<Item> {

    void add(Item item);

    boolean isEmpty();

    int size();
}
