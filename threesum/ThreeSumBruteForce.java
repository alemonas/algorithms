package threesum;
/**
 * ThreeSum (3-SUM) - Brute-Force algorithm
 *  - Given N distints Integers, how many triple sum to exactly zero?
 *  
 */
public class ThreeSumBruteForce {

    public static int count(int[] a) {
        int N = a.length;
        int count = 0;
        for(int i = 0 ; i < N ; i++) {
            for(int j = i+1 ; j < N ; j++) {
                for(int k = j+1 ; k < N ; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count += 1;
                    }
                }
            }   
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25, 10, 20, -30, 30, 0, 25};
        long start = System.nanoTime();
        System.out.println("count: " + count(a));
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time Elapsed: " + timeElapsed);
    }    
}