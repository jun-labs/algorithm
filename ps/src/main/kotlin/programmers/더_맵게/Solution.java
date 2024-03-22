package programmers.더_맵게;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    private final Queue<Long> foods = new PriorityQueue<>();

    public int solution(
        int[] scoville,
        int K
    ) {
        int turn = 0;
        for (Integer food : scoville) {
            foods.add(food.longValue());
        }

        while (!foods.isEmpty() && foods.peek() < K) {
            if (foods.size() == 1) {
                return -1;
            }

            long first = foods.poll();
            long second = foods.poll();
            long mixed = first + (second * 2);
            foods.offer(mixed);
            turn++;
        }
        return turn;
    }
}
