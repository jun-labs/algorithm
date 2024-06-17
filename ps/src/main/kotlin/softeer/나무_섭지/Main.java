package softeer.나무_섭지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
    private static int n;
    private static int m;
    private static char[][] map;
    private static int[][] nMap;
    private static int[][] gMap;
    private static final int INF = 100_000_000;
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        n = input[0];
        m = input[1];

        map = new char[n][m];
        nMap = new int[n][m];
        gMap = new int[n][m];

        for (int[] arr : nMap) {
            Arrays.fill(arr, INF);
        }
        for (int[] arr : gMap) {
            Arrays.fill(arr, INF);
        }

        Point source = null;
        Point target = null;
        List<Point> ghosts = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            map[x] = br.readLine().toCharArray();
            for (int y = 0; y < m; y++) {
                if (map[x][y] == 'N') {
                    source = new Point(x, y);
                    nMap[x][y] = 0;
                } else if (map[x][y] == 'G') {
                    ghosts.add(new Point(x, y));
                } else if (map[x][y] == 'D') {
                    target = new Point(x, y);
                }
            }
        }

        int minDistance = bfs(source, target, nMap, false);
        if (minDistance == -1) {
            System.out.println("No");
            System.exit(0);
        }

        Point targetGhost = null;
        int targetDistance = 100_000;
        for (Point ghost : ghosts) {
            int distance = Math.abs(ghost.x - target.x) + Math.abs(ghost.y - target.y);
            if (distance < minDistance) {
                targetDistance = distance;
                targetGhost = ghost;
            }
        }

        if (targetGhost != null) {
            gMap[targetGhost.x][targetGhost.y] = 0;
            bfs(targetGhost, target, gMap, true);
        }

        boolean canEscape = nMap[target.x][target.y] < gMap[target.x][target.y];
        System.out.println(canEscape ? "Yes" : "No");
    }

    private static int bfs(
        Point source,
        Point target,
        int[][] distance,
        boolean ghost
    ) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == target.x && point.y == target.y) {
                return point.distance;
            }
            for (int direction = 0; direction < 4; direction++) {
                int nextX = point.x + dx[direction];
                int nextY = point.y + dy[direction];

                if (moveable(nextX, nextY)) {
                    if (map[nextX][nextY] != '#' || ghost) {
                        int nextDist = distance[point.x][point.y] + 1;
                        if (nextDist < distance[nextX][nextY]) {
                            distance[nextX][nextY] = nextDist;
                            queue.offer(new Point(nextX, nextY, point.distance + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static boolean moveable(
        int x,
        int y
    ) {
        return x >= 0
            && x < n
            && y >= 0
            && y < m;
    }

    static class Point {
        private final int x;
        private final int y;
        private final int distance;

        Point(
            int x,
            int y
        ) {
            this.x = x;
            this.y = y;
            this.distance = 0;
        }

        public Point(
            int x,
            int y,
            int distance
        ) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
