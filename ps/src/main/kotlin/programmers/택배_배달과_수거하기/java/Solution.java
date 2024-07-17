package programmers.택배_배달과_수거하기.java;

class Solution {
    public long solution(
        int cap,
        int n,
        int[] deliveries,
        int[] pickups
    ) {
        long answer = 0;
        int delivery = 0;
        int pickup = 0;
        for (int distance = n - 1; distance >= 0; distance--) {
            delivery += deliveries[distance];
            pickup += pickups[distance];
            while (delivery > 0 || pickup > 0) {
                delivery -= cap;
                pickup -= cap;
                answer += 2L * (distance + 1);
            }
        }
        return answer;
    }
}
