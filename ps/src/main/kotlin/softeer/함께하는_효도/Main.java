package softeer.함께하는_효도;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int[][] map;
    private static int n;
    private static int m;
    private static final List<Point> friends = new ArrayList<>();
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        map = new int[n + 1][n + 1];

        for (int x = 1; x <= n; x++) {
            String[] input = br.readLine().split(" ");
            for (int y = 1; y <= n; y++) {
                map[x][y] = Integer.parseInt(input[y - 1]);
            }
        }

        int sum = 0;
        for (int index = 0; index < m; index++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            friends.add(new Point(x, y));
            sum += map[x][y];
            map[x][y] = 0;
        }

        Point friend = friends.get(0);
        dfs(0, 0, friend.x, friend.y, sum);
        System.out.println(answer);
    }

    static void dfs(
        int idx,
        int time,
        int x,
        int y,
        int sum
    ) {
        if (time > 3) {
            return;
        }
        answer = Math.max(answer, sum);
        if (time == 3 && (idx + 1) < m) {
            Point point = friends.get(idx + 1);
            dfs(idx + 1, 0, point.x, point.y, sum);
        } else {
            for (int direction = 0; direction < 4; direction++) {
                int nextX = x + dx[direction];
                int nextY = y + dy[direction];
                if (moveable(nextX, nextY)) {
                    int value = map[nextX][nextY];
                    map[nextX][nextY] = 0;
                    dfs(idx, time + 1, nextX, nextY, sum + value);
                    map[nextX][nextY] = value;
                }
            }
        }
    }

    private static boolean moveable(
        int nextX,
        int nextY
    ) {
        return nextX >= 1
            && nextX < map.length
            && nextY >= 1
            && nextY < map.length;
    }

    static class Point {
        int y;
        int x;

        public Point(
            int x,
            int y
        ) {
            this.x = x;
            this.y = y;
        }
    }
}
