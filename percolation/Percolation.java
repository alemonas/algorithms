package percolation;

import java.util.Arrays;

/**
 * Percolation - A model for many physical systems - N-by-N grid of sites - Each
 * site is open with probability p (or blocked with probability 1-p) - System is
 * percolates iff top and bottom are connected by open sites.
 */
public class Percolation {
    private int[] myArray;
    private int[] sz;
    private int[] sites;

    public Percolation(int N) {
        myArray = new int[N];
        sz = new int[N];
        sites = new int[N];
        for (int i = 0 ; i < N ; i++) {
            myArray[i] = i;
            sz[i] = 1;
            sites[i] = 0;
        }
    }

    public int[] getMyArray() {
        return this.myArray;
    }

    public void setOpenSite(int siteIndex) {
        sites[siteIndex] = 1;
        System.out.print("-- SITES ARRAY -> ");
		System.out.println(Arrays.toString(this.sites));
    }

    private int root(int i) {
		while (i != myArray[i]) {
			myArray[i] = myArray[myArray[i]];
			i = myArray[i];
		}
		return i;
    }
    
    public boolean connected(int p, int q) {
		return root(p) == root(q);
    }
    
    public void union(int p, int q) {
		int i = root(p);
        int j = root(q);
		System.out.println("i: " + i);
		System.out.println("j: " + j);
		if (i == j) return;
        if (sz[i] < sz[j]) { 
            myArray[i] = j;
            sz[j] += sz[i];
        } else {
            myArray[j] = i;
            sz[i] += sz[j];
		}
        this.printSz();
        this.printId();
    }
    
    public void printSz() {
		System.out.print("-- SIZE ARRAY -> ");
		System.out.println(Arrays.toString(this.sz));
	}

	public void printId() {
		System.out.print("---- ID ARRAY -> ");
		System.out.println(Arrays.toString(this.myArray));
	}

	public void printArray(int[] myArray) {
		System.out.println(Arrays.toString(myArray));
	}
}
