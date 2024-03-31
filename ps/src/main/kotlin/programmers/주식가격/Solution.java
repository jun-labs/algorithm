package programmers.주식가격;

import java.util.*;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int idx = 0; idx < prices.length; idx++) {
            int count = 0;
            stack.push(prices[idx]);
            for (int subIdx = idx + 1; subIdx < prices.length; subIdx++) {
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
