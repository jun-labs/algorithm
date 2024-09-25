package programmers.퍼즐_게임_챌린지;

class Solution {
    public int solution(
        int[] diffs,
        int[] times,
        long limit
    ) {
        int left = 1;
        int right = 100_000;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isSolved(diffs, times, mid, limit)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private boolean isSolved(
        int[] diffs,
        int[] times,
        int level,
        long limit
    ) {
        long totalTime = 0;
        for (int index = 0; index < diffs.length; index++) {
            if (diffs[index] <= level) {
                totalTime += times[index];
            } else {
                int mistake = Math.max(0, diffs[index] - level);
                totalTime += (long) times[index] * (mistake + 1);
                if (index > 0) {
                    totalTime += (long) mistake * times[index - 1];
                }
            }
            if (totalTime > limit) {
                return false;
            }
        }
        return totalTime <= limit;
    }
}
