package com.javaalgorithms.algorithms.unionfind;

/**
 *  The <tt>WeightedQuickUnion</tt> class represents a union-find data structure.
 *  It supports the <em>union</em> and <em>find</em> operations, along with
 *  methods for determinig whether two objects are in the same component
 *  and the total number of components.
 *  <p>
 *  This implementation uses weighted quick union by size (without path compression).
 *
 *  Initializing a data structure with <em>N</em> objects takes linear time.
 *
 *  Worst-case: logaritmic time (union, find and connected).
 *              constant (count).
 *
 * @author rdonnarumma
 *
 */
public class WeightedQuickUnion extends AbstractUnionFind {

    private int[] size;

    public WeightedQuickUnion(int N) {
        super(N);
        for (int i = 0; i < N; i++) {
            size[i] = 1;
        }
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }

        int pRoot = find(p);
        int qRoot = find(q);
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }

        count--;
    }
}
