package programmers.석유_시추.v1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 정확도는 통과하지만 효율성은 통과하지 못하는 풀이.
 */
public class Solution {
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};
    private boolean[][] visited;
    private int[][] land;

    public int solution(int[][] _land) {
        this.land = _land;
        this.visited = new boolean[land.length][land[0].length];

        for (int x = 0; x < land.length; x++) {
            for (int y = 0; y < land[0].length; y++) {
                if (land[x][y] == 0) {
                    visited[x][y] = true;
                }
            }
        }

        int answer = -1;
        for (int y = 0; y < land[0].length; y++) {
            int x = 0;
            int count = 0;
            int[][] copyLand = copyLand(land);
            boolean[][] copyVisited = copyVisited(visited);
            while (x < land.length) {
                if (copyLand[x][y] == 1 && !copyVisited[x][y]) {
                    count += count(x, y, copyLand, copyVisited);
                }
                x++;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    private int count(
        int startX,
        int startY,
        int[][] land,
        boolean[][] visited
    ) {
        visited[startX][startY] = true;
        int count = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int direction = 0; direction < 4; direction++) {
                int nextX = point.x + dx[direction];
                int nextY = point.y + dy[direction];
                if (moveable(nextX, nextY, land, visited)) {
                    queue.add(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                    land[nextX][nextY] = 0;
                    count++;
                }
            }
        }
        return count;
    }

    private boolean moveable(
        int x,
        int y,
        int[][] land,
        boolean[][] visited
    ) {
        return x >= 0
            && x < land.length
            && y >= 0
            && y < land[0].length
            && land[x][y] == 1
            && !visited[x][y];
    }

    private int[][] copyLand(int[][] land) {
        int[][] copy = new int[land.length][land[0].length];
        for (int x = 0; x < land.length; x++) {
            System.arraycopy(land[x], 0, copy[x], 0, land[0].length);
        }
        return copy;
    }

    private boolean[][] copyVisited(boolean[][] visited) {
        boolean[][] copy = new boolean[visited.length][visited[0].length];
        for (int x = 0; x < visited.length; x++) {
            System.arraycopy(visited[x], 0, copy[x], 0, visited[0].length);
        }
        return copy;
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

    public static void main(String[] args) {
        int[][] _land1 = {
            {0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0},
            {1, 1, 0, 0, 0, 1, 1, 0},
            {1, 1, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 1, 1}
        };
        int[][] _land2 = {
            {1, 0, 1, 0, 1, 1},
            {1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 1},
            {1, 0, 0, 1, 0, 0},
            {1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1}
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(_land2));
    }
}
