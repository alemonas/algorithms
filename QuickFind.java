import java.util.Arrays;

/**
 * Data Structure Integer Array id[] of size N Interpretation: p and q are
 * connected iff they have the same id.
 *
 * find() -> Check if p and q have the same id union() -> To merge components
 * containing p and q, change all entries whose id equals id[p] to id[q]
 */

public class QuickFind {
	private int[] id;

	public static void main(String[] args) {
		QuickFind quickFind = new QuickFind(10);
		boolean isConnected = quickFind.connected(4, 3);
		System.out.println("(4,3) : " + isConnected);
		System.out.println(quickFind.getId());
		quickFind.union(4, 3);
		System.out.println(quickFind.getId());
		quickFind.union(3, 8);
		System.out.println(quickFind.getId());
		quickFind.union(6, 5);
		System.out.println(quickFind.getId());
		quickFind.union(9, 4);
		quickFind.union(2, 1);
		quickFind.union(5, 0);
		quickFind.union(7, 2);
		quickFind.union(6, 1);
		System.out.println(quickFind.getId());

	}

	public QuickFind(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public String getId() {
		return Arrays.toString(this.id);
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid)
				id[i] = qid;
		}
	}
}
