package polishnotation;

import java.util.Stack;

/**
 * PolishNotation
 */
public class PolishNotation {
    public static void main(String[] args) {
        PolishNotation pn = new PolishNotation();
        String s = new String("74,70-2*");
        Stack<Integer> stack = new Stack<Integer>();
        char[] c = s.toCharArray();
        int x = 0;
        int y = 0;
        int z = 0;
        int res = 0;
        String currentString = new String("");
        int currentNumber = 0;

        for (int i = 0 ; i < c.length ; i++) {
            if (c[i] == ',' || pn.isOperand(c[i])) {
                currentNumber = Integer.parseInt(currentString);
                stack.push(currentNumber);
                currentString = "";
            }

            if (pn.isNumber(c[i])) {
                currentString = currentString + c[i];
                // System.out.println(currentString);
                // System.out.println(c[i]);
                // x = Character.getNumericValue(c[i]);
                
            } 
            
            if (pn.isOperand(c[i])) {
                y = stack.pop();
                z = stack.pop();
                // System.out.println(y, z);
                res = pn.makeOperation(y, z, c[i]);
                stack.push(res);
            }
        }

        stack.forEach(item->{
            System.out.println("" + item);
        });
    }

    public boolean isOperand(char ch) {
        if (ch == '*' || ch == '+' || ch == '-' || ch == '/') {
            return true;
        }
        return false;
    }

    public int makeOperation(int y, int z, char ch) {
        // if (ch == '*') {
        //     return y * z;
        // }
        int res = 0;
        switch (ch) {
            case '*':
                res = y * z;
                break;
            case '-':
                res = z - y;
                break;
            case '+':
                res = y + z;
                break;
            case '/':
                res = y / z;
                break;
            default:
                break;
        }

        return res;

    }

    public boolean isNumber(char ch) {
        return Character.isDigit(ch);
    }
}