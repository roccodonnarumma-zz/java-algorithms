package com.javaalgorithms.algorithms.unionfind;

/**
 * @author rdonnarumma
 *
 */
public interface UnionFind {

    /**
     * Add connection between p and q
     */
    void union(int p, int q);

    /**
     * Component identifier for p
     */
    int find(int p);

    /**
     * @return true if p and q are in the same component
     */
    boolean connected(int p, int q);

    /**
     *
     * @return number of components
     */
    int count();
}
