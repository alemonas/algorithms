package percolation;

import java.util.Arrays;

/**
 * Index
 */
public class Index {

    public static void main(String[] args) {
        int N = 3;
        // N-by-N array, plus 2 (for top an bottom virtual sites)
        int size = (N * N) + 2;
        int topVirtualSite = 0;
        int bottomVirtualSite = size - 1;
        Percolation percolation = new Percolation(size);
        int [] a = percolation.getMyArray();
        System.out.println(Arrays.toString(a));
        percolation.setOpenSite(topVirtualSite);
        percolation.setOpenSite(bottomVirtualSite);
        percolation.union(topVirtualSite, 1);
        percolation.union(topVirtualSite, 2);
        percolation.union(topVirtualSite, 3);
        percolation.union(3, 6);
        percolation.union(6, 9);
        percolation.union(bottomVirtualSite, 9);
        percolation.union(bottomVirtualSite, 8);
        percolation.union(bottomVirtualSite, 7);
        boolean isPercolated = percolation.connected(topVirtualSite, bottomVirtualSite);
        System.out.println("*************************");
        if (isPercolated) {
            System.out.print("*** PERCOLATED");
        } else {
            System.out.print("*** NOT PERCOLATED");
        }
    }
}
