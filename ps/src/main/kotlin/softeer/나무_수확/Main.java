package softeer.나무_수확;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int n;
    private static int[][] map;
    private static int[][] harvest;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        harvest = new int[n][n];
        dp = new int[n][n];

        for (int x = 0; x < n; x++) {
            String[] line = br.readLine().split(" ");
            for (int y = 0; y < n; y++) {
                map[x][y] = Integer.parseInt(line[y]);
            }
        }

        bfs();
        System.out.println(dp[n - 1][n - 1]);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        harvest[0][0] = map[0][0];
        dp[0][0] = 2 * map[0][0];
        queue.add(new Point(0, 0));

        int[] dx = {1, 0};
        int[] dy = {0, 1};

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for (int direction = 0; direction < 2; direction++) {
                int nextX = x + dx[direction];
                int nextY = y + dy[direction];
                if (moveable(nextX, nextY)) {
                    int newHarvest = harvest[x][y] + map[nextX][nextY];
                    int maxHarvest = Math.max(
                        dp[x][y] + map[nextX][nextY], harvest[x][y] + 2 * map[nextX][nextY]
                    );

                    if (newHarvest > harvest[nextX][nextY]) {
                        harvest[nextX][nextY] = newHarvest;
                        queue.add(new Point(nextX, nextY));
                    }
                    if (maxHarvest > dp[nextX][nextY]) {
                        dp[nextX][nextY] = maxHarvest;
                        queue.add(new Point(nextX, nextY));
                    }
                }
            }
        }
    }

    private static boolean moveable(
        int x,
        int y
    ) {
        return x >= 0
            && x < map.length
            && y >= 0
            && y < map[0].length;
    }

    static class Point {
        int x;
        int y;

        public Point(
            int x,
            int y
        ) {
            this.x = x;
            this.y = y;
        }
    }
}
