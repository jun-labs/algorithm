package boj.boj_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answer = 0;
    private static int n;
    private static boolean[][] visited;
    private static boolean[] rows;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1][n + 1];
        rows = new boolean[n + 1];
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int row) {
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

    private static boolean isSafe(
        int row,
        int column
    ) {
        if (rows[column]) {
            return false;
        }
        for (int directional = 1; directional <= row; directional++) {
            if (column >= directional && visited[row - directional][column - directional]) {
                return false;
            }
            if (column + directional < n && visited[row - directional][column + directional]) {
                return false;
            }
        }
        return true;
    }
}
