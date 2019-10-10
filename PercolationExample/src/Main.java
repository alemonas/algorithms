public class Main {
    public static void main(String[] args) {
        int size = 4;
        PercolationProblem p = new PercolationProblem(size);
        p.printMatrix();
        boolean isPercolated = p.isPercolated();
        if (isPercolated) {
            System.out.print((char)27 + "[32m" +"PERCOLATED");
        } else {
            System.out.println((char)27 + "[31m" + "NOT PERCOLATED");
        }
    }
}
