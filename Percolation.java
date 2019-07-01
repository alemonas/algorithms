/**
 * Percolation
 *  - A model for many physical systems
 *      - N-by-N grid of sites
 *      - Each site is open with probability p (or blocked with probability 1-p)
 *      - System is percolates iff top and bottom are connected by open sites.
 */
public class Percolation {
    private int[] id;

    public Percolation(int N) {
        id = new int[N];        
    }
}