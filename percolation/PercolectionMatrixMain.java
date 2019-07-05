package percolation;

/**
 * PercolectionMatrixMain
 */
public class PercolectionMatrixMain {
    public static void main(String[] args) {
        int size = 4;
        // int matrixSize = size * size;
        PercolationMatrix p = new PercolationMatrix(size);
        // Random rand = new Random(); 
        // int value = rand.nextInt(matrixSize);
        
        // p.setOpenSite(3, 0);
        // p.setOpenSite(3, 2);
        // p.setOpenSite(2, 1);
        // p.setOpenSite(3, 1);
        // p.setOpenSite(1, 1);
        // p.setOpenSite(0, 1);
        // p.setOpenSite(2, 1);
        p.printMatrix();
        p.wqupc.printId();
        boolean isPercolated = p.wqupc.connected(0, 17);
        if (isPercolated) {
            System.out.print("PERCOLATED");
        } else {
            System.out.print("NOT PERCOLATED");
        }
    }
}
