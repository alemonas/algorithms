import java.util.Arrays;

/**
 * Quick Union Data
 */
public class QuickUnion {
	private int[] id;

	public static void main(String[] args) {
		QuickUnion quickUnion = new QuickUnion(10);
		quickUnion.printId();
		quickUnion.union(6, 5);
		quickUnion.printId();
		quickUnion.union(0, 1);
		quickUnion.printId();
		quickUnion.union(2, 1);
		quickUnion.printId();
		quickUnion.union(7, 1);
		quickUnion.printId();
		quickUnion.union(4, 3);
		quickUnion.printId();
		quickUnion.union(3, 8);
		quickUnion.printId();
		quickUnion.union(9, 4);
		quickUnion.printId();
	}

	public QuickUnion(int N) {
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

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}

	public void printId() {
		System.out.println(Arrays.toString(this.id));
	}
}
