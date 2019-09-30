public class Main {
    public static void main(String[] args) {
        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();

        String str1 = "First string";
        String str2 = "Second string";
        String str3 = "3 string";

        queue.enqueue(str1);
        queue.enqueue(str2);
        queue.enqueue(str3);

        System.out.println(queue);

        String res = queue.dequeue();

        System.out.println(res);
    }
}
