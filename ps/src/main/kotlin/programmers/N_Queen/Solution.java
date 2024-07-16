package programmers.N_Queen;

public class Solution {
    private final boolean[][] visited = new boolean[12][12];
    private final boolean[] rows = new boolean[12];
    private int answer = 0;
    private int n;

    public int solution(int n) throws Exception {
        this.n = n;
        dfs(0);
        return answer;
    }

    void dfs(int row) {
        if (row == n) {
            answer++;
            return;
        }
        for (int column = 0; column < n; column++) {
            if (isSafe(row, column)) {
                rows[column] = true;
                visited[row][column] = true;
                dfs(row + 1);
                rows[column] = false;
                visited[row][column] = false;
            }
        }
    }

    private boolean isSafe(
        int row,
        int column
    ) {
        if (rows[column]) {
            return false;
        }
        for (int directional = 1; directional <= row && row - directional >= 0; directional++) {
            if (column - directional >= 0 && visited[row - directional][column - directional]) {
                return false;
            }
            if (column + directional < n && visited[row - directional][column + directional]) {
                return false;
            }
        }
        return true;
    }
}
