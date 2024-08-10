package boj.boj_19236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    // 북, 북서, 서, 남서, 남, 남동, 동, 북동
    private static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    private static final Fish[][] map = new Fish[4][4];
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int x = 0; x < 4; x++) {
            String[] temp = br.readLine().split(" ");
            for (int y = 0; y < 4; y++) {
                int a = Integer.parseInt(temp[2 * y]);
                int b = Integer.parseInt(temp[2 * y + 1]) - 1;
                map[x][y] = new Fish(x, y, a, b);
            }
        }

        Fish firstFish = map[0][0];
        Shark shark = new Shark(firstFish.x, firstFish.y, firstFish.number, firstFish.direction);
        map[0][0] = null;
        dfs(map, shark);
        System.out.println(answer);
    }

    private static void dfs(
        Fish[][] map,
        Shark shark
    ) {
        answer = Math.max(answer, shark.size);
        Fish[][] copyMap = copyMap(map);
        moveFishes(copyMap, shark);

        for (int distance = 1; distance <= 3; distance++) {
            int nextX = shark.x + dx[shark.direction] * distance;
            int nextY = shark.y + dy[shark.direction] * distance;
            if (!moveable(nextX, nextY)) {
                continue;
            }
            if (copyMap[nextX][nextY] != null) {
                Fish eatenFish = copyMap[nextX][nextY];
                Shark nextShark = new Shark(nextX, nextY, shark.size + copyMap[nextX][nextY].number, eatenFish.direction);
                Fish[][] newMap = copyMap(copyMap);
                newMap[nextX][nextY] = null;
                dfs(newMap, nextShark);
            }
        }
    }

    private static void moveFishes(
        Fish[][] map,
        Shark shark
    ) {
        List<Fish> fishes = new ArrayList<>();
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (map[x][y] != null) {
                    fishes.add(map[x][y]);
                }
            }
        }

        Collections.sort(fishes);
        for (Fish fish : fishes) {
            int tryCount = 0;
            while (tryCount < 8) {
                int nextX = fish.x + dx[fish.direction];
                int nextY = fish.y + dy[fish.direction];
                if (moveable(nextX, nextY) && (nextX != shark.x || nextY != shark.y)) {
                    if (map[nextX][nextY] != null) {
                        Fish swapFish = map[nextX][nextY];
                        map[fish.x][fish.y] = swapFish;
                        map[nextX][nextY] = fish;
                        swapFish.x = fish.x;
                        swapFish.y = fish.y;
                    } else {
                        map[fish.x][fish.y] = null;
                        map[nextX][nextY] = fish;
                    }
                    fish.x = nextX;
                    fish.y = nextY;
                    break;
                } else {
                    fish.direction = (fish.direction + 1) % 8;
                }
                tryCount++;
            }
        }
    }

    private static Fish[][] copyMap(Fish[][] map) {
        Fish[][] copyMap = new Fish[map.length][map[0].length];
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (map[x][y] != null) {
                    Fish fish = new Fish(map[x][y].x, map[x][y].y, map[x][y].number, map[x][y].direction);
                    copyMap[x][y] = fish;
                }
            }
        }
        return copyMap;
    }

    private static boolean moveable(
        int x,
        int y
    ) {
        return x >= 0
            && x < 4
            && y >= 0
            && y < 4;
    }

    static class Shark {
        int x;
        int y;
        int size;
        int direction;

        public Shark(
            int x,
            int y,
            int size,
            int direction
        ) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.direction = direction;
        }
    }

    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int number;
        int direction;

        public Fish(
            int x,
            int y,
            int number,
            int direction
        ) {
            this.x = x;
            this.y = y;
            this.number = number;
            this.direction = direction;
        }

        @Override
        public int compareTo(Fish o) {
            return this.number - o.number;
        }
    }
}
