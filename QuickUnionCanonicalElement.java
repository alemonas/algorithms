import java.util.Arrays;

/**
 * Quick Union 
 * Union-find with specific canonical element. Add a method find() to the union-find data type so 
 * that find(i) returns the largest element in the connected component containing iii. 
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 * For example, if one of the connected components is {1,2,6,9}, then the find() method 
 * should return 999 for each of the four elements in the connected components.
 * 
 */
public class QuickUnionCanonicalElement {
	private int[] id;

	public static void main(String[] args) {
		QuickUnionCanonicalElement QuickUnionCanonicalElement = new QuickUnionCanonicalElement(10);
		QuickUnionCanonicalElement.printId();
        QuickUnionCanonicalElement.union(2, 1);
        QuickUnionCanonicalElement.union(6, 1);
        QuickUnionCanonicalElement.union(9, 1);
        QuickUnionCanonicalElement.find(6);
        QuickUnionCanonicalElement.printId();
	}

	public QuickUnionCanonicalElement(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
    }
    
    public void find(int x) {
        int maxElement = x;
        for(int i = 0; i < id.length; i++) {
            if (this.connected(i, x) && i > x) {
                maxElement = i;
            }
        }

        System.out.print("---- find(" + x + ") = ");
        System.out.println(maxElement);
    }

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}

	public void printId() {
		System.out.println(Arrays.toString(this.id));
	}
}
