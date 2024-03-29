package programmers.주식가격;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int idx = 0; idx < answer.length; idx++) {
            stack.push(prices[idx]);
            int count = 0;
            for (int subIdx = idx + 1; subIdx < answer.length; subIdx++) {
                if (stack.peek() <= prices[subIdx]) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            answer[idx] = count;
        }
        return answer;
    }
}
