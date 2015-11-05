package nyc.c4q.sufeiiz;

import java.util.Stack;

public class Homework {
    // Show that X^62 can be computed with only 8 multiplications
    // 62 can be square rooted 8 times?

    // Majority element complexity: O(N)
    public static boolean isMajorityElement(Integer[] array, int num) {
        int count = 0;

        for (int x : array) {
            if (x == num)
                count++;
        }

        return count > array.length / 2;
    }

    // Balanced Parentheses
    public static final String open = "{([";

    public static boolean isBalanced(String string) {
        Stack<Character> stack = new Stack<Character>();
        char current;

        for (int i = 0; i < string.length(); i++) {
            current = string.charAt(i);

            if (isOpenParen(current)) {
                stack.push(current);
                continue;
            }

            if (stack.isEmpty())
                return false;
            else if (current == getMatch(stack.peek()))
                stack.pop();
            else {
                return false;
            }
        }

        return stack.size() == 0;
    }

    public static boolean isOpenParen(char a) {
        return open.contains(Character.toString(a));
    }

    public static char getMatch(char a) {
        if (a == '{')
            return '}';
        else if (a == '[')
            return ']';
        else if (a == '(')
            return ')';
        else
            return ' ';
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("([{}])"));
        System.out.println(isBalanced("{[}]"));
        System.out.println(isBalanced("(([])))"));
    }
}
