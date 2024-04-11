package boj.boj_11497;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < t; idx++) {
            int n = Integer.parseInt(br.readLine());
            int[] heights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            Arrays.sort(heights);

            int[] logs = new int[n];

            int left = 0;
            int right = n - 1;
            for (int subIdx = 0; subIdx < n; subIdx++) {
                if (subIdx % 2 == 0) {
                    logs[left++] = heights[subIdx];
                } else {
                    logs[right--] = heights[subIdx];
                }
            }
            int result = calculateResult(logs);
            System.out.println(result);
        }
    }
    private static int calculateResult(int[] logs) {
        int maxDiff = Math.abs(logs[0] - logs[logs.length - 1]);
        for (int idx = 1; idx < logs.length; idx++) {
            int diff = Math.abs(logs[idx] - logs[idx - 1]);
            maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
    }
}
