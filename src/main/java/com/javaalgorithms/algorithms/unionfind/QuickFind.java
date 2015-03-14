package com.javaalgorithms.algorithms.unionfind;

/**
 *  The <tt>QuickFind</tt> class represents a union-find data structure.
 *  It supports the <em>union</em> and <em>find</em> operations, along with
 *  methods for determinig whether two objects are in the same component
 *  and the total number of components.
 *  <p>
 *
 *  Initializing a data structure with <em>N</em> objects takes linear time.
 *  N-1 calls to union. Union is linear time (always).
 *
 *  Worst-case: quadratic (union).
 *              constant (find, connected and count).
 *
 * @author rdonnarumma
 *
 */
public class QuickFind extends AbstractUnionFind {

    public QuickFind(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }

        int pId = find(p);
        int qId = find(q);

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }

        count--;
    }
}
