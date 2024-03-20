package programmers.아이템_줍기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static final int EDGE = 1;
    private final int[][] map = new int[102][102];
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};

    public int solution(
        int[][] rectangle,
        int currentX,
        int currentY,
        int itemX,
        int itemY
    ) {
        currentX *= 2;
        currentY *= 2;
        itemX *= 2;
        itemY *= 2;

        for (int[] rec : rectangle) {
            for (int index = 0; index < rec.length; index++) {
                rec[index] *= 2;
            }
            for (int x = rec[0]; x <= rec[2]; x++) {
                for (int y = rec[1]; y <= rec[3]; y++) {
                    map[x][y] = 1;
                }
            }
        }

        for (int[] rec : rectangle) {
            for (int x = rec[0] + 1; x < rec[2]; x++) {
                for (int y = rec[1] + 1; y < rec[3]; y++) {
                    map[x][y] = 0;
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(currentX, currentY));
        map[currentX][currentY] = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            if (x == itemX && y == itemY) {
                break;
            }

            for (int index = 0; index < 4; index++) {
                int nextX = x + dx[index];
                int nextY = y + dy[index];

                if (map[nextX][nextY] == EDGE) {
                    queue.offer(new Point(nextX, nextY));
                    map[nextX][nextY] = map[x][y] + 1;
                }
            }
        }
        return map[itemX][itemY] / 2;
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
