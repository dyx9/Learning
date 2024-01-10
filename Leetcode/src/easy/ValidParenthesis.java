package easy;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()) {
            // push corresponding close parentheses into the stack for each opening ones
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            // check if the last char is the same as the closing parenthesis
            // if the stack is empty -> extra closing parenthesis
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        // if the stack is not empty -> extra opening parenthesis
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidParenthesis("()(){[]}"));
        System.out.println(isValidParenthesis("{{[]}}"));
        System.out.println(isValidParenthesis("({)}"));
        System.out.println(isValidParenthesis("["));
    }
}
