package com.javaalgorithms.algorithms.unionfind;

/**
 *  The <tt>QuickUnion</tt> class represents a union-find data structure.
 *  It supports the <em>union</em> and <em>find</em> operations, along with
 *  methods for determinig whether two objects are in the same component
 *  and the total number of components.
 *  <p>
 *
 *  Initializing a data structure with <em>N</em> objects takes linear time.
 *  N-1 calls to union. Union is linear time (worst-case).
 *
 *  Worst-case: quadratic (union).
 *              linear (find, connected).
 *              constant (count).
 *
 *  N-1 calls to union. Union is linear time (worst-case).
 *
 *  Worst-case: quadratic
 *
 * @author rdonnarumma
 *
 */
public class QuickUnion extends AbstractUnionFind {

    public QuickUnion(int N) {
        super(N);
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
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;
        count--;
    }
}
