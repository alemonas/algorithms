package percolation;

/**
 * PercolectionMatrixMain
 */
public class PercolectionMatrixMain {
    public static void main(String[] args) {
        int size = 10;
        PercolationMatrix p = new PercolationMatrix(size);
        p.printMatrix();
        boolean isPercolated = p.isPercolated();
        if (isPercolated) {
            System.out.print((char)27 + "[32m" +"PERCOLATED");
        } else {
            System.out.println((char)27 + "[31m" + "NOT PERCOLATED");
        }
    }
}
