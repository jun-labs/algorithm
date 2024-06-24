package boj.boj_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[][] map;
    private static int row;
    private static int column;
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        map = new int[n][m];
        row = n;
        column = m;

        for (int x = 0; x < n; x++) {
            int[] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            System.arraycopy(temp, 0, map[x], 0, temp.length);
        }
        dfs(0, map);
        System.out.println(answer);
    }

    private static void dfs(
        int wallCount,
        int[][] map
    ) {
        if (wallCount == 3) {
            int[][] copy = copy();
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < column; y++) {
                    if (map[x][y] == 2) {
                        spreadVirus(copy, x, y);
                    }
                }
            }
            int count = count(copy);
            answer = Math.max(count, answer);
            return;
        }

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                if (map[x][y] == 0) {
                    map[x][y] = 1;
                    dfs(wallCount + 1, map);
                    map[x][y] = 0;
                }
            }
        }
    }

    private static void spreadVirus(
        int[][] map,
        int startX,
        int startY
    ) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        map[startX][startY] = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int direction = 0; direction < 4; direction++) {
                int nextX = point.x + dx[direction];
                int nextY = point.y + dy[direction];
                if (moveable(nextX, nextY, map)) {
                    queue.add(new Point(nextX, nextY));
                    map[nextX][nextY] = 1;
                }
            }
        }
    }

    private static int count(int[][] map) {
        int count = 0;
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                if (map[x][y] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[][] copy() {
        int[][] copy = new int[row][column];
        for (int x = 0; x < row; x++) {
            System.arraycopy(map[x], 0, copy[x], 0, column);
        }
        return copy;
    }

    private static boolean moveable(
        int x,
        int y,
        int[][] map
    ) {
        return x >= 0
            && x < row
            && y >= 0
            && y < column
            && map[x][y] == 0;
    }

    static class Point {
        int x;
        int y;

        public Point(
            int x,
            int y) {
            this.x = x;
            this.y = y;
        }
    }
}
