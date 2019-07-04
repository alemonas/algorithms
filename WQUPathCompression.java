import java.util.Arrays;
/**
 * WeightedQuickUnion
 * Data Structure
 *  - Same as QuickUnion, but maintain extra array sz[i] 
 *    to count number of objexts in the tree rooted at i. 
 * 
 * find() -> Identical to quick-union
 * union() -> Modify quick-unio to 
 *  - Link root of smaller tree to root of larger tree.
 *  - Update the sz[] array.
 */
public class WQUPathCompression {
    private int[] id;
    private int[] sz;
    
	public static void main(String[] args) {
		WQUPathCompression wqupc = new WQUPathCompression(10);
		wqupc.printId();
		System.out.println("---- initial state ");
		wqupc.union(4, 3);
		wqupc.printId();
		wqupc.union(3, 8);
		wqupc.union(6, 5);
		wqupc.union(9, 4);
		wqupc.union(2, 1);
		wqupc.union(5, 0);
		wqupc.union(7, 2);
		wqupc.union(6, 1);
		wqupc.union(7, 3);
		wqupc.printId();

	}

	public WQUPathCompression(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
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
		System.out.println("i: " + i);
		System.out.println("j: " + j);
		if (i == j) return;
        if (sz[i] < sz[j]) { 
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
		}
		this.printSz();
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