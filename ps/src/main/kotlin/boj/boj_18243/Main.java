package boj.boj_18243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int[][] distance = new int[n + 1][n + 1];

        for (int index = 1; index <= n; index++) {
            Arrays.fill(distance[index], 100_000_000);
            distance[index][index] = 0;
        }

        for (int index = 0; index < k; index++) {
            String[] relation = br.readLine().split(" ");
            int from = Integer.parseInt(relation[0]);
            int to = Integer.parseInt(relation[1]);
            distance[from][to] = 1;
            distance[to][from] = 1;
        }

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                for (int j = 1; j <= n; j++) {
                    distance[x][j] = Math.min(distance[x][j], distance[x][y] + distance[y][j]);
                }
            }
        }

        boolean isSmallWorld = true;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (x != y && distance[x][y] > 6) {
                    isSmallWorld = false;
                    break;
                }
            }
        }

        if (isSmallWorld) {
            System.out.println("Small World!");
        } else {
            System.out.println("Big World!");
        }
    }
}
