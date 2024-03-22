package programmers.같은_숫자는_싫어;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int number : arr) {
            if (stack.isEmpty() || stack.peek() != number) {
                stack.push(number);
            }
        }

        int[] answer = new int[stack.size()];
        for (int index = answer.length - 1; index >= 0; index--) {
            answer[index] = stack.pop();
        }
        return answer;
    }
}
