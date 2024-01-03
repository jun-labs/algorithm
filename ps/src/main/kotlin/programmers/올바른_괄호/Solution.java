package programmers.올바른_괄호;

import java.util.Stack;

class Solution {

    private final Stack<Character> stack = new Stack<>();

    boolean solution(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        if (s.startsWith(")")) {
            return false;
        }
        for (int index = 0; index < s.length(); index++) {
            char character = s.charAt(index);
            if (stack.isEmpty()) {
                stack.push(character);
            } else if (character == '(') {
                stack.push(character);
            } else if (character == ')') {
                char peek = stack.peek();
                if (peek == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }
}

