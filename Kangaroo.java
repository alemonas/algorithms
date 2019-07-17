import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Kangaroo {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {

        if (x1 < 0 || x1 > 10000) {
            return "NO";
        }

        if (v1 <= 1 || v1 >= 10000) {
            return "NO";
        }

        if (v2 <= 1 || v2 >= 10000) {
            return "NO";
        }

        if (x1 > x2) {
            return "NO";
        }

        if (v2 > v1) {
            return "NO";
        }

        boolean sameNumber = false;

        int res1 = x1;
        int res2 = x2;

        while (sameNumber == false) {
            res1 += v1;
            res2 += v2;

            if (res1 == res2) {
                sameNumber = true;
                return "YES";
            }

            if (res1 > res2) {
                sameNumber = true;
                return "NO";
            }
        }

        return "YES";
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int x1 = 0;

        int v1 = 3;

        int x2 = 4;

        int v2 = 2;

        String result = kangaroo(x1, v1, x2, v2);

        System.out.print(result);
    }
}
