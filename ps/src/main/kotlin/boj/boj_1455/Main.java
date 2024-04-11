package boj.boj_1455;

import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;
        map = new int[n][m];
        for (int x = 0; x < n; x++) {
            String[] tmp = br.readLine().split("");
            for (int y = 0; y < m; y++) {
                map[x][y] = Integer.parseInt(tmp[y]);
            }
        }

        for (int y = m - 1; y >= 0; y--) {
            for (int x = n - 1; x >= 0; x--) {
                if (map[x][y] == 1) {
                    reverse(x, y);
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }

    static void reverse(
        int xLimit,
        int yLimit
    ) {
        for (int x = 0; x <= xLimit; x++) {
            for (int y = 0; y <= yLimit; y++) {
                if (map[x][y] == 1) {
                    map[x][y] = 0;
                } else {
                    map[x][y] = 1;
                }
            }
        }
    }
}
