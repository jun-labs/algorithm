package boj.boj_16236;

import static java.util.Comparator.comparingInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] sea;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sea = new int[n][n];
        Shark shark = null;

        for (int x = 0; x < n; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int y = 0; y < n; y++) {
                sea[x][y] = Integer.parseInt(st.nextToken());
                if (sea[x][y] == 9) {
                    shark = new Shark(x, y, 2);
                    sea[x][y] = 0;
                }
            }
        }
        System.out.println(getTime(shark));
    }

    static int getTime(Shark shark) {
        int answer = 0;
        int size = 0;
        while (true) {
            Fish fish = findFish(shark);
            if (fish == null) {
                break;
            }

            sea[fish.x][fish.y] = 0;
            shark.x = fish.x;
            shark.y = fish.y;
            answer += fish.distance;

            size++;
            if (size == shark.size) {
                shark.plusSize();
                size = 0;
            }
        }
        return answer;
    }

    static Fish findFish(Shark shark) {
        Queue<Shark> queue = new LinkedList<>();
        List<Fish> fishes = new ArrayList<>();
        visited = new boolean[n][n];
        visited[shark.x][shark.y] = true;
        queue.add(new Shark(shark.x, shark.y, shark.size, 0));

        while (!queue.isEmpty()) {
            Shark pollShark = queue.poll();

            for (int direction = 0; direction < 4; direction++) {
                int nextX = pollShark.x + dx[direction];
                int nextY = pollShark.y + dy[direction];
                if (moveable(nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    if (sea[nextX][nextY] <= shark.size) {
                        int distance = pollShark.distance + 1;
                        queue.add(new Shark(nextX, nextY, pollShark.size, distance));
                        if (sea[nextX][nextY] > 0 && sea[nextX][nextY] < shark.size) {
                            fishes.add(new Fish(nextX, nextY, distance));
                        }
                    }
                }
            }
        }
        return fishes.stream()
            .min(comparingInt((Fish fish) -> fish.distance)
                .thenComparingInt(fish -> fish.x)
                .thenComparingInt(fish -> fish.y))
            .orElseGet(() -> null);
    }

    private static boolean moveable(
        int nextX,
        int nextY
    ) {
        return nextX >= 0
            && nextX < n
            && nextY >= 0
            && nextY < n;
    }

    static class Fish {
        int x;
        int y;
        int distance;

        public Fish(
            int x,
            int y,
            int distance
        ) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static class Shark {
        int x;
        int y;
        int size;
        int distance;

        public Shark(
            int x,
            int y,
            int size
        ) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        public Shark(
            int x,
            int y,
            int size,
            int distance
        ) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.distance = distance;
        }

        public void plusSize() {
            this.size++;
        }
    }
}
