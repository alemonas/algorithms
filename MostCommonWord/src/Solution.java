import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
// It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
// Words in the list of banned words are given in lowercase, and free of punctuation.
// Words in the paragraph are not case sensitive.  The answer is in lowercase.

public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet<>();
        for (String word: banned) {
            bannedWords.add(word);
        }

        HashMap<String, Integer> counts = new HashMap<>();
        String[] paragraphArray = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");

        for (String word: paragraphArray) {
            if (!bannedWords.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }

        String result = "";
        for (String key: counts.keySet()) {
            if(result.equals("") || counts.get(key) > counts.get(result)) {
                result = key;
            }
        }

        return result;
    }
}


