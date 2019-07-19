import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.sound.midi.MidiChannel;

public class FraudulentActivityNot {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
         int[] counts = new int[201];
		for (int i = 0; i < d; i++) {
			counts[expenditure[i]]++;
		}

        int result = 0;
        System.out.println(Arrays.toString(counts));
		for (int i = d; i < expenditure.length; i++) {
            
			int lower = 0;
			int leftNum = 0;
			while ((leftNum + counts[lower]) * 2 <= d) {
				leftNum += counts[lower];
				lower++;
			}

			int upper = counts.length - 1;
			int rightNum = 0;
			while ((rightNum + counts[upper]) * 2 <= d) {
				rightNum += counts[upper];
				upper--;
			}

			if (expenditure[i] >= (lower + upper)) {
				result++;
			}

			counts[expenditure[i - d]]--;
            counts[expenditure[i]]++;
            
            System.out.println(Arrays.toString(counts));
		}
		return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = 23;
        // n = 5;
        // n = 5;
        int d = 5;
        // d = 4;
        // d = 3;


        int[] expenditure = new int[n];

        String input = "2 3 4 2 3 6 8 4 5";
        // input = "1 2 3 4 4";
        // input = "10 20 30 40 50";
        input = "45 30 64 149 156 153 54 38 175 34 87 109 63 124 54 55 187 75 94 191 192 130 33 45 30 64 149 156 153 54 38 175 34 87 109 63 124 54 55 187 75 94 191 192 130 33 45 30 64 149 156 153 54 38 175 34 87 109 63 124 54 55 187 75 94 191 192 130 33";
        // input = "1 2 3 4 4";
        // input = "10 20 30 40 50";

        String[] expenditureItems = input.split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println("notifications: " + result);

    }
}
