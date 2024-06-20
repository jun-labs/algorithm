package boj.boj_11403.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int x = 0; x < n; x++) {
            int[] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            map[x] = temp;
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int z = 0; z < n; z++) {
                    if (map[y][x] == 1 && map[x][z] == 1) {
                        map[y][z] = 1;
                    }
                }
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
    }
}
