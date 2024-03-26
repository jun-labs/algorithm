package programmers.구명보트;

import java.util.Arrays;

public class Solution {

    public int solution(
        int[] people,
        int limit
    ) {
        int answer = 0;
        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            answer++;
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
        }
        return answer;
    }
}
