package boj.boj_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] numbers;
    private static int n;
    private static int s;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        s = Integer.parseInt(temp[1]);
        numbers = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        dfs(0, 0);
        if (s == 0) {
            answer--;
        }
        System.out.println(answer);
    }

    private static void dfs(
        int index,
        int sum
    ) {
        if (index == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }
        dfs(index + 1, sum);
        dfs(index + 1, sum + numbers[index]);
    }
}
