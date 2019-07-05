package percolation;

/**
 * PercolectionMatrixMain
 */
public class PercolectionMatrixMain {
    public static void main(String[] args) {
        int size = 5;
        PercolationMatrix p = new PercolationMatrix(size);
      
        p.printMatrix();
        // p.wqupc.printId();


        boolean isPercolated = p.isPercolated();
        if (isPercolated) {
            System.out.print((char)27 + "[32m" +"PERCOLATED");
        } else {
            System.out.println((char)27 + "[31m" + "NOT PERCOLATED");
        }

        // System.out.println((char)27 + "[31m" + " ERROR MESSAGE IN RED");
    }
}
