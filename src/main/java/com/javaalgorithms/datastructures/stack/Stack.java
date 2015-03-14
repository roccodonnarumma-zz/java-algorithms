package com.javaalgorithms.datastructures.stack;

/**
 * @author rdonnarumma
 *
 */
public interface Stack<Item> extends Iterable<Item> {

    void push(Item item);

    Item pop();

    Item peek();

    boolean isEmpty();

    int size();
}
