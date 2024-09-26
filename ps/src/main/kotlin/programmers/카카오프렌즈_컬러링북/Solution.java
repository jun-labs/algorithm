package programmers.카카오프렌즈_컬러링북;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private boolean[][] visited;
    private int[][] map;
    private int m;
    private int n;
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};

    public int[] solution(
        final int m,
        final int n,
        final int[][] picture
    ) {
        init(m, n, picture);
        int count = 0;
        int max = -100_000;
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (map[row][column] != 0 && !visited[row][column]) {
                    int s = bfs(map[row][column], row, column);
                    count++;
                    max = Math.max(max, s);
                }
            }
        }
        final int[] answer = new int[2];
        answer[0] = count;
        answer[1] = max;
        return answer;
    }

    private void init(
        final int m,
        final int n,
        final int[][] picture
    ) {
        this.m = m;
        this.n = n;
        this.visited = new boolean[picture.length][picture[0].length];
        this.map = picture;
    }

    private int bfs(
        final int color,
        final int startX,
        final int startY
    ) {
        int count = 1;
        final Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            final Point point = queue.poll();
            for (int direction = 0; direction < 4; direction++) {
                int nextX = point.x + dx[direction];
                int nextY = point.y + dy[direction];
                if (moveable(nextX, nextY) && map[nextX][nextY] == color) {
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                    count++;
                }
            }
        }
        return count;
    }

    private boolean moveable(
        final int x,
        final int y
    ) {
        return x >= 0
            && x < m
            && y >= 0
            && y < n
            && !visited[x][y];
    }

    private static class Point {
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
