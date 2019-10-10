package PercolationExample.src;

import java.util.Arrays;
/**
 * Weighted Quick Union with path compression
 * Data Structure
 *  - Same as QuickUnion, but maintain extra array sz[i]
 *    to count number of objects in the tree rooted at i.
 *
 * find() -> Identical to quick-union
 * union() -> Modify quick-unio to
 *  - Link root of smaller tree to root of larger tree.
 *  - Update the sz[] array.
 */
public class WQUPC {
    private int[] id;
    private int[] sz;

    public WQUPC(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        // this.printId();
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        // System.out.println("i: " + i);
        // System.out.println("j: " + j);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        // this.printSz();
    }

    public void printSz() {
        System.out.print("-- SIZE ARRAY -> ");
        System.out.println(Arrays.toString(this.sz));
    }

    public void printId() {
        System.out.print("---- ID ARRAY -> ");
        System.out.println(Arrays.toString(this.id));
    }

    public void printArray(int[] myArray) {
        System.out.println(Arrays.toString(myArray));
    }
}
