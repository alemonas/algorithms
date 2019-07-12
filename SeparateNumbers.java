import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SeparateNumbers {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        if ( s.charAt(0) == 0) {
            System.out.println("NO");
        }

        int length = s.length();
        int maxNumIt = Math.round(length / 2);
        int iteration = 1;
        boolean res = false;
        Long x = new Long(0);
        String sNew = new String("");

        while (iteration <= maxNumIt) {
            x = Long.parseLong(s.substring(0, iteration));
            // int sNewLength = sNew.length();
            sNew = "";
            Long num = x;
            while(sNew.length() < length) {
                sNew = sNew + Long.toString(num);
                num++;
            }
            if(sNew.equals(s)){
                System.out.println("YES " + x);
                res = true;
                break;
            }
            iteration +=1;
        } 

        if (!res) {
            System.out.println("NO");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
