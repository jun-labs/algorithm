package softeer.나무_섭지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        char[][] map = new char[n][m];

        Point start = new Point(-1, -1);
        Point exit = new Point(-1, -1);
        List<Point> ghosts = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            String line = br.readLine();
            for (int y = 0; y < m; y++) {
                map[x][y] = line.charAt(y);
                if (map[x][y] == 'N') {
                    start = new Point(x, y);
                } else if (map[x][y] == 'D') {
                    exit = new Point(x, y);
                }
                if (map[x][y] == 'G') {
                    ghosts.add(new Point(x, y));
                }
            }
        }

        int namooDistance = bfs(map, start, exit, n, m, false);
        if (namooDistance == -1) {
            System.out.println("No");
            return;
        }

        Point targetGhost = new Point(-1, -1);
        int minGhostDistance = 100_000;
        for (Point ghost : ghosts) {
            int distance = Math.abs(ghost.x - exit.x) + Math.abs(ghost.y - exit.y);
            if (distance < minGhostDistance) {
                minGhostDistance = distance;
                targetGhost = ghost;
            }
        }

        int ghostDistance = bfs(map, targetGhost, exit, n, m, true);
        if (ghostDistance <= namooDistance) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        br.close();
    }

    private static int bfs(
        char[][] map,
        Point source,
        Point target,
        int n,
        int m,
        boolean isGhost
    ) {
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.add(source);
        visited[source.x][source.y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == target.x && point.y == target.y) {
                return point.distance;
            }
            for (int direction = 0; direction < 4; direction++) {
                int nextX = point.x + dx[direction];
                int nextY = point.y + dy[direction];
                if (moveable(nextX, nextY, n, m)) {
                    if ((map[nextX][nextY] != '#' || isGhost) && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new Point(nextX, nextY, point.distance + 1));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean moveable(
        int nextX,
        int nextY,
        int n,
        int m
    ) {
        return nextX >= 0
            && nextX < n
            && nextY >= 0
            && nextY < m;
    }

    static class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = 0;
        }

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
