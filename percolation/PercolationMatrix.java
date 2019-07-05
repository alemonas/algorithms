package percolation;

/**
 * PercolationMatrix
 */
public class PercolationMatrix {
    private int[][] m;
    private int size;
    public WQUPC wqupc;
    public int wqupcSize = 0;

    public PercolationMatrix(int N) {
        this.size = N;
        this.wqupcSize = (N*N)+2;
        this.wqupc = new WQUPC(wqupcSize);
        this.setDefaults();
        m = new int[N][N];
        
        // m2d = new int[N*N]
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (Math.random() < 0.5) {
                    m[i][j] = 0;
                } 
                else {
                    m[i][j] = 1;
                    this.setOpenSite(i, j);
                }
            }
        }

        // this.setOpenSite(4, 4);

        // for (int k = 0 ; k < m2d.length; k++) {
        //     m2d[k] = 0;
        // }
    }

    private void setDefaults() {
        // this.wqupc.union(0, 1);
        // this.wqupc.union(0, 2);
        // this.wqupc.union(0, 3);
        // this.wqupc.union(0, 4);

        // this.wqupc.union(17, 16);
        // this.wqupc.union(17, 15);
        // this.wqupc.union(17, 14);
        // this.wqupc.union(17, 13);
    }

    private int getIndexFromMatrixToArray(int x, int y) {
        return (x * this.size) + (y + 1);
    }

    private void unionWithAdjacents(int x, int y) {
        int topX = x - 1;
        int bottomX = x + 1;
        int leftY = y - 1;
        int rightY = y + 1;

        int pos = getIndexFromMatrixToArray(x, y);
        // System.out.println("topX = " + topX);
        // System.out.println("bottomX = " + bottomX);

        if ( topX < 0) {
            this.wqupc.union(0, getIndexFromMatrixToArray(x, y));
        }

        if ( bottomX >= this.size) {
            this.wqupc.union((this.wqupcSize - 1), getIndexFromMatrixToArray(x, y));
        }
        // top
        if ( x > 0 && isOpenSite(topX, y)) {
            int topPos = getIndexFromMatrixToArray(topX, y);
            // System.out.println("TOP: union(" + pos + ", " + topPos  + ")" );
            this.wqupc.union(pos, topPos);
        }
        // bottom 
        if ( x < (this.size - 1)) {
            if (isOpenSite(bottomX, y)) {
                int bottomPos = getIndexFromMatrixToArray(bottomX, y);
                // System.out.println("BOTTOM: union(" + pos + ", " + bottomPos  + ")" );
                this.wqupc.union(pos, bottomPos);
            }
        }
        // left
        if ( y > 0 && isOpenSite(x, leftY)) {
            int leftPos = getIndexFromMatrixToArray(x, leftY);
            //System.out.println("LEFT: union(" + pos + ", " + leftPos  + ")" );
            this.wqupc.union(pos, leftPos);
        }
        // right
        if ( y < (this.size - 1) && isOpenSite(x, rightY)) {
            int rightPos = getIndexFromMatrixToArray(x, rightY);
            // System.out.println("RIGHT: union(" + pos + ", " + rightPos  + ")" );
            this.wqupc.union(pos, rightPos);
        }
    }

    public void setOpenSite(int x, int y) {
        m[x][y] = 1;
        this.unionWithAdjacents(x, y);
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
