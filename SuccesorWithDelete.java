import java.util.Arrays;
import java.util.HashMap;

/**
 * SuccesorWithDelete
 */
public class SuccesorWithDelete {
    public static void main(String[] args) {
        SuccesorWithDelete swd = new SuccesorWithDelete();      
        HashMap<Integer, Integer> a = swd.getA(10);
        swd.remove2(a, 3);
    }

    private HashMap<Integer, Integer> getA(int N) {
        HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < N ; i++) {
            a.put(i, i);
        }
        System.out.print("Original : ");
        System.out.println(Arrays.asList(a));
        return a;
    }

    public void remove2(HashMap<Integer, Integer> a, int x) {
        a.remove(x);
        System.out.print("Removed : ");
        System.out.println(Arrays.asList(a));

    }
}
