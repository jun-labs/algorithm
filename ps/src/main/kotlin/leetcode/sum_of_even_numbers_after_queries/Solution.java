package leetcode.sum_of_even_numbers_after_queries;

public class Solution {
    public int[] sumEvenAfterQueries(
        int[] numbers,
        int[][] queries
    ) {
        int evenSum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenSum += number;
            }
        }

        int[] answer = new int[queries.length];
        int idx = 0;

        for (int[] query : queries) {
            int value = query[0];
            int index = query[1];

            if (numbers[index] % 2 == 0) {
                evenSum -= numbers[index];
            }
            numbers[index] += value;
            if (numbers[index] % 2 == 0) {
                evenSum += numbers[index];
            }
            answer[idx++] = evenSum;
        }
        return answer;
    }
}
