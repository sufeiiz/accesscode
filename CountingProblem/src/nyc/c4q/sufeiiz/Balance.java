package nyc.c4q.sufeiiz;

import java.util.Stack;

/**
 * Created by sufeizhao on 10/11/15.
 */
public class Balance {
    public static final String open = "{([";

    public static void main(String[] args) {

    }

    public boolean isBalanced(String string) {
        Stack<Character> stack = new Stack<Character>();
        char current = 'a';

        for (int i = 0; i < string.length(); i++) {
            if (isOpenParen(string.charAt(i))) {
                current = getMatch(string.charAt(i));
                stack.push(string.charAt(i));
            } else if (current == string.charAt(i)) {
                stack.push(string.charAt(i));
            }
        }
        
        return false;
    }

    public boolean isOpenParen(char a) {
        return open.contains(String.valueOf(a));
    }

    public char getMatch(char a) {
        if (a == '{')
            return '}';
        else if (a == '[')
            return ']';
        else if (a == '(')
            return ')';
        else
            return ' ';
    }
}
