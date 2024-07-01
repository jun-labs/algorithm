package programmers.석유_시추.v2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};
    private boolean[][] visited;
    private int[][] land;
    private int row;
    private int column;
    private final Map<Integer, Integer> oilMap = new HashMap<>();
    private int oilId = 2;

    public int solution(int[][] _land) {
        this.land = _land;
        this.row = land.length;
        this.column = land[0].length;
        this.visited = new boolean[row][column];

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                if (land[x][y] == 1 && !visited[x][y]) {
                    int size = bfs(x, y, oilId);
                    oilMap.put(oilId, size);
                    oilId++;
                }
            }
        }

        int answer = 0;
        for (int y = 0; y < column; y++) {
            Set<Integer> oilIds = new HashSet<>();
            int sum = 0;
            for (int x = 0; x < row; x++) {
                if (land[x][y] > 1 && !oilIds.contains(land[x][y])) {
                    sum += oilMap.get(land[x][y]);
                    oilIds.add(land[x][y]);
                }
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    private int bfs(
        int startX,
        int startY,
        int oilId
    ) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;
        land[startX][startY] = oilId;

        int count = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int direction = 0; direction < 4; direction++) {
                int nextX = point.x + dx[direction];
                int nextY = point.y + dy[direction];
                if (isMovable(nextX, nextY)) {
                    queue.add(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                    land[nextX][nextY] = oilId;
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMovable(
        int x,
        int y
    ) {
        return x >= 0
            && x < row
            && y >= 0
            && y < column
            && land[x][y] == 1
            && !visited[x][y];
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
