import java.util.Arrays;

/**
 * Quick Union Data
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
        // int parent = id[x];
        // int[] elements = new int[];
        int maxElement = x;
        // System.out.print("---- find(" + x + ") = ");
        // System.out.println(root(id[x]));
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
