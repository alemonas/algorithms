import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndValidString {
    public static void main(String[] args) throws IOException {
        String s = "abcdefghhgfedecba";
        char[] ca = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for( char c: ca ) {
            hashMap.append(c, 1);
        }

        System.out.print(hashMap.toString());


        


    }
}
