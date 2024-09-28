package programmers.짝지어_제거하기;

import java.util.Stack;

class Solution {

    public int solution(String s) {
        final Stack<Character> stack = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(index)) {
                stack.pop();
            } else {
                stack.push(s.charAt(index));
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
