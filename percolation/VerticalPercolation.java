public class VerticalPercolation {

    // given an n-by-n matrix of open sites, return an n-by-n matrix
    // of sites reachable from the top via a vertical path of open sites
    public static boolean[][] flow(boolean[][] isOpen) {
        int n = isOpen.length;     
        boolean[][] isFull = new boolean[n][n];

        // identify full sites in row 0
        for (int j = 0; j < n; j++) {
            isFull[0][j] = isOpen[0][j]; 
        }      

        // update remaining rows
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isFull[i][j] = isOpen[i][j] && isFull[i-1][j];
            }
        }

        return isFull;
    } 


    // does the system percolate?
    public static boolean percolates(boolean[][] isOpen) {
        int n = isOpen.length;
        boolean[][] isFull = flow(isOpen);
        for (int j = 0; j < n; j++) {
            if (isFull[n-1][j]) return true;
        }
        return false;
    }

    // draw the n-by-n boolean matrix to standard draw
    public static void show(boolean[][] a, boolean which) {
        int n = a.length;
        StdDraw.setXscale(-1, n);
        StdDraw.setYscale(-1, n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] == which)
                    StdDraw.filledSquare(j, n-i-1, 0.5);
    }

    // return a random n-by-n boolean matrix, where each entry is
    // true with probability p
    public static boolean[][] random(int n, double p) {
        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = StdRandom.bernoulli(p);
        return a;
    }

   // test client
    public static void main(String[] args) {
        boolean[][] isOpen = StdArrayIO.readBoolean2D();
        StdArrayIO.print(flow(isOpen));
        StdOut.println(percolates(isOpen));
    }       

}