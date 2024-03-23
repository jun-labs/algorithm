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
        for (Integer value : scoville) {
            foods.add(value.longValue());
        }

        while (!foods.isEmpty() && foods.peek() < K) {
            if (foods.size() == 1) {
                return -1;
            }

            long firstFood = foods.poll();
            long secondFood = foods.poll();
            long result = firstFood + (2 * secondFood);
            foods.add(result);
            turn++;
        }
        return turn;
    }
}
