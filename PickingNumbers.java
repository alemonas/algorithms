import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        System.out.println(a);
        
        for (int x: a) {
            // List list = new List(x);
            hashMap.put(x, x);
        }

        System.out.println(Arrays.asList(hashMap));
        return 0;
    }

}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = 6;

        String b = "4 6 5 3 3 1";

        List<Integer> a = Stream.of(b.split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        System.out.println(a);
        

        int result = Result.pickingNumbers(a);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedReader.close();
        // bufferedWriter.close();
    }
}
