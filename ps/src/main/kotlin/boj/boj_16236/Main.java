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
    private static int n;
    private static int[][] sea;
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

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
                    shark = new Shark(x, y, 2, 0);
                    sea[x][y] = 0;
                }
            }
        }
        System.out.println(getAnswer(shark));
    }

    private static int getAnswer(Shark shark) {
        int answer = 0;
        int temp = 0;

        while (true) {
            Fish findFish = findFish(shark);
            if (findFish == null) {
                break;
            }
            sea[findFish.x][findFish.y] = 0;
            shark.x = findFish.x;
            shark.y = findFish.y;
            answer += findFish.distance;
            temp++;
            if (temp == shark.size) {
                shark.plusSize();
                temp = 0;
            }
        }
        return answer;
    }

    private static Fish findFish(Shark shark) {
        List<Fish> fishes = new ArrayList<>();
        Queue<Shark> queue = new LinkedList<>();
        queue.add(shark);
        boolean[][] visited = new boolean[n][n];
        visited[shark.x][shark.y] = true;
        int startDistance = shark.distance;
        while (!queue.isEmpty()) {
            Shark polledShark = queue.poll();
            for (int direction = 0; direction < 4; direction++) {
                int nextX = polledShark.x + dx[direction];
                int nextY = polledShark.y + dy[direction];
                if (!moveable(nextX, nextY)) {
                    continue;
                }
                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    if (sea[nextX][nextY] <= polledShark.size) {
                        int distance = polledShark.distance - startDistance + 1;
                        queue.add(new Shark(nextX, nextY, polledShark.size, distance));
                        if (sea[nextX][nextY] > 0 && sea[nextX][nextY] < polledShark.size) {
                            fishes.add(new Fish(nextX, nextY, distance));
                        }
                    }
                }
            }
        }
        return fishes.stream()
            .min(comparingInt((Fish fish) -> fish.distance)
                .thenComparingInt(fish -> fish.x)
                .thenComparingInt(fish -> fish.y)
            ).orElse(null);
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
