public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        String result = solution.mostCommonWord(paragraph, banned);
        System.out.println(result);
    }
}
