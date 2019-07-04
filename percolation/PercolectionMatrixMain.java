package percolation;

import java.util.Random;

/**
 * PercolectionMatrixMain
 */
public class PercolectionMatrixMain {
    public static void main(String[] args) {
        int size = 5;
        // int matrixSize = size * size;
        PercolationMatrix p = new PercolationMatrix(size);
        // Random rand = new Random(); 
        // int value = rand.nextInt(matrixSize);
        p.setOpenSite(1, 1);
        p.setOpenSite(2, 1);
        p.printMatrix(); 
    }
}
