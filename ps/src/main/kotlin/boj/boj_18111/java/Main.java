package boj.boj_18111.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int b = Integer.parseInt(firstLine[2]);

        int[][] map = new int[n][m];

        int min = 100_000;
        int max = -100_000;

        for (int x = 0; x < n; x++) {
            int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            map[x] = array;
            for (int y = 0; y < m; y++) {
                min = Math.min(min, map[x][y]);
                max = Math.max(max, map[x][y]);
            }
        }

        int time = 100_000_000;
        int height = 0;
        for (int blockHeight = max; blockHeight >= min; blockHeight--) {
            int tempTime = 0;
            int block = b;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (map[x][y] > blockHeight) {
                        tempTime += 2 * (map[x][y] - blockHeight);
                        block += (map[x][y] - blockHeight);
                    } else if (map[x][y] < blockHeight) {
                        tempTime += (blockHeight - map[x][y]);
                        block -= (blockHeight - map[x][y]);
                    }
                }
            }
            if (block >= 0 && tempTime < time) {
                time = tempTime;
                height = blockHeight;
            }
        }
        System.out.println(time + " " + height);
    }
}
