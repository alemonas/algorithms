import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.sound.midi.MidiChannel;

public class FraudulentActivityNotification {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int[] frequencyArray = new int[201];
		for (int i = 0; i < d; i++) {
			frequencyArray[expenditure[i]]++;
		}
    
        int length = expenditure.length;
        int currentNot = d;
        int x = 0;
        int y = 0;
        int notCount = 0;
        boolean isEven = d % 2 == 0 ? true : false;
        boolean sw = false;
        while (currentNot < length) {
            x = 0;
            y = 0;
            
			while ((y + frequencyArray[x]) * 2 <= d) {
				y += frequencyArray[x];
				x++;
            }

            // int p = x;

            // if (isEven) {
            //     p++;
            //     while (sw == false) {
            //         if (frequencyArray[p] > 0) {
            //             sw = true;
            //         }
            //         p++;
            //     }
            //     sw = false;
            // }

            // if (expenditure[currentNot] >= (x + p)) {
            //     notCount++;
            // }

            
            int w = frequencyArray.length - 1;
			int z = 0;
			while ((z + frequencyArray[w]) * 2 <= d) {
                z += frequencyArray[w];
				w--;
			}
            
            if (expenditure[currentNot] >= (x + w)) {
                // System.out.print("x + w: " + (x + w) + " -- ");
                System.out.print("currentNot: " + currentNot + " -- ");
                System.out.println("expenditure[currentNot]: " + expenditure[currentNot]);
                notCount++;
            }

            // if (expenditure[currentNot] >= (x * 2)) {
            //     notCount++;
            // }
            
			frequencyArray[expenditure[currentNot - d]]--;
            frequencyArray[expenditure[currentNot]]++;

            currentNot++;
        }

        return notCount;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = 1066;
        // n = 5;
        // n = 5;
        int d = 20;
        // d = 4;
        // d = 3;

        n = 174;



        int[] expenditure = new int[n];

        String input = "2 3 4 2 3 6 8 4 5";
        // input = "1 2 3 4 4";
        // input = "10 20 30 40 50";
        input = "0 82 180 55 168 41 179 59 139 71 6 12 135 139 73 157 4 74 195 60 45 28 67 136 58 55 22 60 33 84 48 185 118 29 41 86 22 172 145 114 43 103 126 130 43 152 87 199 26 34 59 24 63 79 160 73 86 134 133 71 18 182 57 89 163 98 175 137 70 73 3 113 176 130 43 19 34 83 170 12 117 30 36 132 61 197 5 99 131 91 171 102 25 28 143 188 126 118 77 148 143 81 61 120 163 56 91 149 91 62 161 161 44 198 93 57 195 51 156 78 142 127 132 119 107 75 59 33 146 136 133 89 169 146 161 84 3 5 33 46 67 195 7 63 193 53 120 140 56 28 170 150 156 103 69 63 178 128 49 124 64 182 166 186 129 79 70 84 84 104 82 103 51 42 166 44 95 38 136 103 67 106 53 175 161 122 190 140 50 39 16 66 174 134 52 55 14 123 91 98 179 173 2 30 15 120 26 62 159 114 165 178 172 18 153 134 140 143 26 142 135 42 9 61 129 61 68 143 136 159 193 67 132 195 49 100 68 27 114 27 141 80 157 66 50 110 0 191 5 26 133 92 20 142 105 149 156 173 44 44 84 38 112 169 185 113 69 53 141 183 32 34 15 189 100 66 51 52 9 57 78 94 101 51 37 159 152 145 132 197 189 17 187 53 138 172 167 159 26 108 142 58 94 110 48 195 176 51 47 137 108 78 31 162 129 20 121 33 165 5 182 107 174 169 112 112 142 79 71 120 139 166 178 34 76 178 181 4 30 28 93 90 58 124 4 139 145 125 173 62 131 155 121 57 125 34 170 19 65 41 139 5 159 69 191 187 0 172 143 182 152 36 24 163 161 29 102 58 154 27 120 37 183 194 95 60 28 17 79 93 10 170 50 170 39 193 157 191 117 101 173 22 89 198 185 50 27 87 108 133 115 181 123 50 175 170 62 155 187 141 0 197 63 3 119 102 196 29 46 66 82 19 88 171 169 73 22 196 112 82 82 179 15 157 181 142 127 43 97 66 136 50 15 199 53 135 54 1 116 100 67 198 119 155 121 89 180 95 37 93 178 71 24 145 28 6 88 107 1 137 173 138 139 141 137 192 28 191 146 144 43 13 94 163 169 15 4 101 111 193 146 41 17 171 138 197 129 178 105 130 116 30 68 7 171 158 152 151 149 98 95 193 111 141 108 32 157 64 134 20 57 80 61 26 3 199 24 132 178 129 63 46 111 83 53 35 41 5 186 143 55 34 88 119 175 148 151 132 12 37 104 21 70 165 48 25 117 72 158 47 153 173 93 16 56 98 51 50 56 38 193 63 24 81 182 199 29 134 84 193 123 188 166 145 106 14 171 23 38 129 22 143 54 67 160 62 165 11 112 173 1 105 37 25 138 19 25 119 105 61 64 181 49 31 126 155 45 97 130 36 178 152 179 32 19 139 47 137 151 159 62 152 17 51 130 107 23 155 27 128 168 91 109 17 74 188 125 120 85 7 108 16 160 87 48 131 27 95 20 130 7 35 34 24 86 164 131 109 71 110 190 39 154 99 9 28 39 134 100 125 93 8 141 5 96 141 137 75 189 109 157 196 144 143 172 31 60 103 92 83 166 82 75 120 134 84 148 173 170 1 98 63 9 191 69 57 133 158 84 74 19 41 70 164 137 42 147 197 97 39 80 63 122 155 135 56 191 36 29 113 37 80 129 46 71 150 56 156 108 140 30 127 134 100 43 71 94 190 68 144 182 100 159 104 8 95 112 151 131 141 65 168 21 146 166 45 96 22 1 156 163 184 35 97 36 79 120 131 21 140 27 3 192 186 59 0 81 171 152 12 113 169 132 86 115 99 83 163 121 37 119 36 21 154 85 57 185 157 140 7 97 167 162 90 154 22 42 35 193 146 0 58 115 84 97 182 183 180 145 57 17 64 45 190 171 83 48 156 40 188 163 138 156 78 180 62 100 22 49 45 169 49 104 36 134 153 171 69 133 116 78 103 133 124 93 104 7 93 12 199 82 128 137 190 6 69 52 106 92 101 151 13 103 7 1 189 160 172 10 46 89 89 101 174 165 194 30 124 40 42 123 74 170 13 64 176 82 68 34 126 169 186 139 24 193 141 13 106 113 24 152 154 65 53 128 182 199 158 106 39 1 181 113 123 194 129 100 29 197 134 155 119 72 95 143 18 188 109 124 101 85 76 8 102 81 136 84 32 47 142 72 0 123 137 123 70 67 175 99 16 110 6 135 134 101 31 152 89 92 76 143 129 104 151 31 185 39 115 170 38 57 42 190 132 131 114 154 150 41 53 167 103 60 54 38 113 37 190 155 81 19 98 10 123 1 41 61 192 108 31 31 117 25 21 50 108 87 4 59 129 10 178 184 22 32 22 135 22 165 42 103 184 92 66 59 93";
        input = "0 82 180 55 168 41 179 59 139 71 6 12 135 139 73 157 4 74 195 60 45 28 67 136 58 55 22 60 33 84 48 185 118 29 41 86 22 172 145 114 43 103 126 130 43 152 87 199 26 34 59 24 63 79 160 73 86 134 133 71 18 182 57 89 163 98 175 137 70 73 3 113 176 130 43 19 34 83 170 12 117 30 36 132 61 197 5 99 131 91 171 102 25 28 143 188 126 118 77 148 143 81 61 120 163 56 91 149 91 62 161 161 44 198 93 57 195 51 156 78 142 127 132 119 107 75 59 33 146 136 133 89 169 146 161 84 3 5 33 46 67 195 7 63 193 53 120 140 56 28 170 150 156 103 69 63 178 128 49 124 64 182 166 186 129 79 70 84 84 104 82 103 51 42";
        // input = "0 82 180 55 168 41";

        String[] expenditureItems = input.split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(expenditureItems.length);

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println("notifications: " + result);

    }
}