import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Sherlock {

    // Complete the isValid function below.
    static String isValid(String s) {

        System.out.println(s);
        return s;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static boolean isAlpha(String s) {
		return s != null && s.matches("^[a-zA-Z]*$");
	}

    public static void main(String[] args) throws IOException {
        String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        System.out.println("string size: " + s.length());
        if (s.equals("") || s == null) {
            System.out.println("NO");
        }

        if (!isAlpha(s)) {
            System.out.println("NO");
        }

        HashMap<Character, Integer> hash = new HashMap<>();
        
        char[] chars = s.toCharArray();
        float sumValues = chars.length;
        for (char c : chars) {
            if (hash.get(c) == null) {
                hash.put(c, 1);
                
            } else {
                hash.put(c, (hash.get(c) + 1));
            }
        }
        
        float size = hash.size();
        int mostUsedValue = (int) Math.round(sumValues / size);        
        Integer counter = 0;
        for (Integer x: hash.values()) {
            if ( mostUsedValue != x) {
                counter += 1;
            }
        }

        if ( counter > 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
        
        System.out.println(Arrays.asList(hash));
    }
}
