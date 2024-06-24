package boj.boj_18405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static Point[][] board;
    private static int n;
    private static int k;
    private static final List<Point> virus = new ArrayList<>();
    private static final Deque<Point> queue = new LinkedList<>();

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        k = input.integer();
        visited = new boolean[n][n];
        board = new Point[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int number = input.integer();
                if (number == 0) {
                    number = -1;
                }
                Point point = new Point(x, y, number);
                board[x][y] = point;

                if (number > 0) {
                    virus.add(point);
                    visited[x][y] = true;
                }
            }
        }

        int s = input.integer();
        int x = input.integer();
        int y = input.integer();

        Collections.sort(virus);
        queue.addAll(virus);
        virus.clear();
        while (s > 0) {
            s--;
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                spread(point);
            }
            queue.addAll(virus);
            virus.clear();
        }
        if (!visited[x - 1][y - 1]) {
            System.out.println(0);
        } else {
            System.out.println(board[x - 1][y - 1].virus);
        }
    }

    static void spread(Point point) {
        int x = point.x;
        int y = point.y;
        visited[x][y] = true;
        for (int direction = 0; direction < 4; direction++) {
            int nextX = x + dy[direction];
            int nextY = y + dx[direction];
            if (!moveable(nextX, nextY)) {
                continue;
            }
            if (!visited[nextX][nextY] && board[nextX][nextY].virus == -1) {
                visited[nextX][nextY] = true;
                board[nextX][nextY].virus = point.virus;
                virus.add(new Point(nextX, nextY, point.virus));
            }
        }
    }

    static boolean moveable(int x, int y) {
        return x >= 0
            && x < n
            && y >= 0
            && y < n;
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int virus;

        public Point(int x, int y, int virus) {
            this.x = x;
            this.y = y;
            this.virus = virus;
        }

        @Override
        public int compareTo(Point o) {
            return this.virus - o.virus;
        }
    }
}
