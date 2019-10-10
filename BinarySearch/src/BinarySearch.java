package BinarySearch.src;


public class BinarySearch {
    private int[] a;

    public BinarySearch(int[] a) {
        this.a = a;
    }

    public int search(int key) {
        int size = a.length;

        int low = 0;

        int high = size -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ( key < a[mid] )
                high = mid - 1;
            else if ( key > a[mid] )
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
