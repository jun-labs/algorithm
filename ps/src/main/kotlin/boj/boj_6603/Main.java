package boj.boj_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("0")) {
                break;
            }

            int[] temp = Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            int k = temp[0];
            int[] numbers = new int[k];
            System.arraycopy(temp, 1, numbers, 0, k);

            Arrays.sort(numbers);
            for (int index = 0; index <= numbers.length - 6; index++) {
                dfs(numbers, index, 1, String.valueOf(numbers[index]));
            }
            System.out.println();
        }
    }

    private static void dfs(
        int[] numbers,
        int start,
        int count,
        String str
    ) {
        if (count == 6) {
            System.out.println(str);
            return;
        }
        for (int index = start + 1; index < numbers.length; index++) {
            dfs(numbers, index, count + 1, str + " " + numbers[index]);
        }
    }
}
