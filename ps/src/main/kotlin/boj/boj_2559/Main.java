package boj.boj_2559;

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
        int[] numbers = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] sum = new int[n + 1];
        for (int index = 1; index <= n; index++) {
            sum[index] = sum[index - 1] + numbers[index - 1];
        }

        int answer = -100_000_000;
        for (int index = k; index <= n; index++) {
            answer = Math.max(answer, sum[index] - sum[index - k]);
        }
        System.out.println(answer);
    }
}
