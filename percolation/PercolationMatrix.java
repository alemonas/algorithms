package percolation;

/**
 * PercolationMatrix
 */
public class PercolationMatrix {
    private int[][] m;
    private int[] m2d;

    public PercolationMatrix(int N) {
        m = new int[N][N];
        // m2d = new int[N*N]
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                m[i][j] = 0;
            }
        }

        // for (int k = 0 ; k < m2d.length; k++) {
        //     m2d[k] = 0;
        // }
    }

    public void setOpenSite(int x, int y) {
        m[x][y] = 1;
        if (isOpenSite(x-1, y) && x > 0) {
            System.out.println("union(" + (x-1) + ", " + y  + ")" );
        }
    }

    public boolean isOpenSite(int x, int y) {
        if (m[x][y] == 1) {
            return true;
        }

        return false;
    }

    public void printMatrix() {
        int N = this.m.length;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                System.out.print(this.m[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("-");
    }
}
