package programmers.N으로_표현.java;

public class Solution {
    private static final int MAX = 9;
    static int answer = Integer.MAX_VALUE;

    public int solution(
        int N,
        int number
    ) {
        dfs(N, 0, 0, number);
        return answer != Integer.MAX_VALUE ? answer : -1;
    }

    public static void dfs(
        int n,
        int count,
        int value,
        int target
    ) {
        if (count >= MAX) {
            return;
        }
        if (value == target) {
            answer = Math.min(answer, count);
            return;
        }

        int temp = n;
        for (int index = 1; index < MAX - count; index++) {
            dfs(n, count + index, value + temp, target);
            dfs(n, count + index, value - temp, target);
            dfs(n, count + index, value * temp, target);
            if (temp != 0) {
                dfs(n, count + index, value / temp, target);
            }
            temp = temp * 10 + n;
        }
    }
}
