package boj.boj_14225.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static int n;
    private static int[] numbers;
    private static final Set<Integer> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        Arrays.sort(numbers);
        dfs(0, 0);

        int target = 1;
        while (true) {
            if (!answer.contains(target)) {
                System.out.println(target);
                break;
            }
            target++;
        }
    }

    private static void dfs(
        int index,
        int sum
    ) {
        if (index == n) {
            answer.add(sum);
            return;
        }
        dfs(index + 1, sum);
        dfs(index + 1, sum + numbers[index]);
    }
}
