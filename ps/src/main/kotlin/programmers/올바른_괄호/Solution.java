package programmers.올바른_괄호;

import java.util.Stack;

public class Solution {

    private final Stack<Character> stack = new Stack<>();

    public boolean solution(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        for (int index = 0; index < s.length(); index++) {
            char bracket = s.charAt(index);
            if (bracket == '(') {
                stack.push(bracket);
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                } else {
                    stack.push(bracket);
                }
            }
        }
        return stack.isEmpty();
    }
}

