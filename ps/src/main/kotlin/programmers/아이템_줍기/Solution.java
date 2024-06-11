package programmers.아이템_줍기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final int[][] map = new int[102][102];
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};

    public int solution(
        int[][] rectangles,
        int currentX,
        int currentY,
        int itemX,
        int itemY
    ) {
        for (int[] rectangle : rectangles) {
            for (int index = 0; index < rectangle.length; index++) {
                rectangle[index] *= 2;
            }
            for (int row = rectangle[1]; row <= rectangle[3]; row++) {
                for (int column = rectangle[0]; column <= rectangle[2]; column++) {
                    map[row][column] = 1;
                }
            }
        }

        for (int[] rectangle : rectangles) {
            for (int row = rectangle[1] + 1; row < rectangle[3]; row++) {
                for (int column = rectangle[0] + 1; column < rectangle[2]; column++) {
                    map[row][column] = 0;
                }
            }
        }

        int x = currentY * 2;
        int y = currentX * 2;
        int targetX = itemY * 2;
        int targetY = itemX * 2;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));
        map[x][y] = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int xPosition = point.x;
            int yPosition = point.y;

            if (point.arrive(targetX, targetY)) {
                break;
            }

            for (int direction = 0; direction < 4; direction++) {
                int nextX = xPosition + dx[direction];
                int nextY = yPosition + dy[direction];
                if (map[nextX][nextY] == 1) {
                    queue.add(new Point(nextX, nextY, point.count + 1));
                    map[nextX][nextY] = map[xPosition][yPosition] + 1;
                }
            }
        }
        return map[targetX][targetY] / 2;
    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(
            int x,
            int y,
            int count
        ) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public boolean arrive(
            int x,
            int y
        ) {
            return this.x == x
                & this.y == y;
        }
    }
}
