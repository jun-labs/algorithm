package boj.boj_14225.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int n;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        Arrays.sort(numbers);

        int target = 1;
        for (int index = 0; index < n; index++) {
            if (numbers[index] > target) {
                break;
            }
            target += numbers[index];
        }
        System.out.println(target);
    }
}
