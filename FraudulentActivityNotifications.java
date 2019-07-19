import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.sound.midi.MidiChannel;

public class FraudulentActivityNotifications {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        // System.out.println(Arrays.toString(expenditure));
        // int[] test = Arrays.copyOfRange(expenditure, 0, 8);
        // Arrays.sort(test);
        // System.out.println(Arrays.toString(test));

        // int mod = test.length % 2; // even or odd
        // int med = test.length / 2; 
        
        // System.out.println("mod: " + mod);
        // System.out.println("med: " + med);
        // System.out.println("test.length: " + test.length);

        int[] counts = new int[201];
		for (int i = 0; i < d; i++) {
			counts[expenditure[i]]++;
		}

            
        int length = expenditure.length;
        int totalNot = length - d;
        int currentNot = 0;
        int[] currentDays = new int[d];
        boolean isEven = d % 2 == 0 ? true : false;
        int middleNumber = 0;
        // if (!isEven) {
            middleNumber = d / 2;
        // }
        float middle = 0;
        float dob = 0;
        int notCounter = 0;
        while (currentNot < totalNot) {
            currentDays = Arrays.copyOfRange(expenditure, currentNot, (currentNot + d));
            Arrays.sort(currentDays);
            // System.out.println("------------------------------------------");
            // System.out.println("current days (" + currentNot + ")" + " " + Arrays.toString(currentDays));
            // System.out.println("middle: " + middle);
            middle = currentDays[middleNumber];
            if (isEven) {
                middle = (middle + currentDays[middleNumber - 1]) / 2;
            } 
            dob = middle * 2;
            middle = currentDays[middleNumber];
            // System.out.println("dob: " + dob);
            // System.out.println("expenditure[d + currentNot -1]: " + expenditure[d + currentNot]);
            int z = expenditure[d + currentNot];
            if (z >= dob) { 
                notCounter++;
                // System.out.println("notCounter: " + notCounter);
            }
            currentNot++;
        }
        return notCounter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = 9;
        // n = 5;
        // n = 5;
        int d = 5;
        // d = 4;
        // d = 3;


        int[] expenditure = new int[n];

        String input = "2 3 4 2 3 6 8 4 5";
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
