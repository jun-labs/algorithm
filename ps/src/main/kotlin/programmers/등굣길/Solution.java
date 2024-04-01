package programmers.등굣길;

public class Solution {
    private static final int DIVISION = 1_000_000_007;
    private int[][] map;

    public int solution(
        int m,
        int n,
        int[][] puddles
    ) {
        map = new int[n + 1][m + 1];
        for (int index = 0; index < puddles.length; index++) {
            int row = puddles[index][1];
            int column = puddles[index][0];
            map[row][column] = -1;
        }

        map[1][1] = 1;
        for (int row = 0; row < n + 1; row++) {
            for (int column = 0; column < m + 1; column++) {
                if (map[row][column] == -1) continue;
                if (row > 1 && map[row - 1][column] > 0) {
                    map[row][column] += map[row - 1][column] % DIVISION;
                }
                if (column > 1 && map[row][column - 1] > 0) {
                    map[row][column] += map[row][column - 1] % DIVISION;
                }
            }
        }
        return map[n][m] % DIVISION;
    }
}
