import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ClimbingLeaderboard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int aliceSize = alice.length;
        int[] res = new int[alice.length];
        ArrayList<Integer> list = new ArrayList<>();
        int currentPos = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        // for ( int i = 0 ; i < totalSize ; i++) {
            
        // }
        for (int i = 0; i < scores.length-1; i++) {   
            if (scores[i] != scores[i+1]) {    
                map.put(currentPos, scores[i]);
                currentPos++;
            }
        }
        map.put(currentPos, scores[scores.length-1]);

        int mapSize = map.size();
        int mapLastEntryValue = map.get(mapSize);
        // System.out.println("map size: "  + mapSize);
        // System.out.println("map last entry: "  + map.get(mapSize));

        int counter = 0;

        for(int j = 0; j < alice.length; j++) {
            
            if (alice[j] < mapLastEntryValue) {
                // list.add(currentPos+1);
                res[counter] = currentPos + 1;
                counter++;
                continue;
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() <= alice[j]) {
                    // list.add(entry.getKey());
                    res[counter] = entry.getKey();
                    counter++;
                    break;
                }
            }
        }

        // System.out.println(list);

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = 7;
        // scoresCount = 6;
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


        // 6
        // 100 90 90 80 75 60
        // 5
        // 50 65 77 90 102
        int[] scores = new int[scoresCount];

        String scoresItemsString = "100 100 50 40 40 20 10";
        // scoresItemsString = "100 90 90 80 75 60";
        String[] scoresItems = scoresItemsString.split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = 4;
        // aliceCount = 5;
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String aliceItemsString = "5 25 50 120";
        // aliceItemsString = "50 65 77 90 102";
        String[] aliceItems = aliceItemsString.split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println("");
            }
        }

        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
