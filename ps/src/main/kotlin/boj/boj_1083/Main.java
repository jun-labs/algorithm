package boj.boj_1083;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final int[] numbers = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int s = Integer.parseInt(br.readLine());

        for (int index = 0; index < n && s > 0; index++) {
            int maxIndex = index;
            for (int subIndex = index + 1; subIndex < n && subIndex <= index + s; subIndex++) {
                if (numbers[subIndex] > numbers[maxIndex]) {
                    maxIndex = subIndex;
                }
            }
            for (int subIndex = maxIndex; subIndex > index; subIndex--) {
                final int temp = numbers[subIndex];
                numbers[subIndex] = numbers[subIndex - 1];
                numbers[subIndex - 1] = temp;
            }
            s -= (maxIndex - index);
        }
        final StringBuilder sb = new StringBuilder();
        for (final int number : numbers) {
            sb.append(number)
                .append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
