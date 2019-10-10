package StackOfStrings.src;

public class Main {
    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        String a = "my string";
        stack.push(a);
        a = "my new string";
        stack.push(a);
        String res = stack.pop();

        System.out.println(res);
    }
}
