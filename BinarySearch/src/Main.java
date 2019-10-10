public class Main {

    public static void main(String[] args) {
        int[] a = {1,2,5,10,29,33,49,50,55,56,60,61,62,63,70};
        BinarySearch binarySearch = new BinarySearch(a);

        int key = 5;

        int res = binarySearch.search(key);

        if (res == -1) {
            System.out.println("Key not found");
        }

        System.out.print("The key was found at index: ");
        System.out.println(res);
    }
}
