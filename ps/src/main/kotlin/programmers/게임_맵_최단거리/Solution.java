package programmers.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int row;
    private int column;
    private boolean[][] visited;
    private int[][] map;

    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        row = maps.length;
        column = maps[0].length;
        visited = new boolean[row][column];
        map = maps;
        visited[0][0] = true;

        bfs(0, 0);
        if (map[row - 1][column - 1] == 1) {
            return -1;
        }
        return map[row - 1][column - 1];
    }

    private void bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int index = 0; index < 4; index++) {
                int nextX = point.x + dx[index];
                int nextY = point.y + dy[index];
                if (moveable(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = map[point.x][point.y] + 1;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
    }

    private boolean moveable(int x, int y) {
        return x >= 0 && x < row
            && y >= 0 && y < column
            && !visited[x][y]
            && map[x][y] == 1;
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
