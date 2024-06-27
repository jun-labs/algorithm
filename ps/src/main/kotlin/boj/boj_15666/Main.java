package boj.boj_15666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static int n;
    private static int m;
    private static int[] numbers;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        numbers = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .distinct()
            .sorted()
            .toArray();

        dfs(new ArrayList<>(), 0, 0);
        System.out.println(sb);
    }

    private static void dfs(
        List<Integer> elements,
        int count,
        int start
    ) {
        if (count == m) {
            for (Integer element : elements) {
                sb.append(element)
                    .append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int index = start; index < numbers.length; index++) {
            elements.add(numbers[index]);
            dfs(elements, count + 1, index);
            elements.remove(elements.size() - 1);
        }
    }
}
