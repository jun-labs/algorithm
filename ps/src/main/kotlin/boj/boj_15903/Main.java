package boj.boj_15903;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split(" ");
        int n = Integer.parseInt(array[0]);
        int m = Integer.parseInt(array[1]);
        List<Long> numbers = java.util.Arrays.stream(br.readLine().split(" "))
            .map(Long::valueOf)
            .collect(Collectors.toList());

        Queue<Long> queue = new PriorityQueue<>();
        queue.addAll(numbers);

        while (m > 0 && queue.size() >= 2) {
            m--;
            long number1 = queue.poll();
            long number2 = queue.poll();
            long sum = number1 + number2;
            queue.add(sum);
            queue.add(sum);
        }
        long result = queue.stream()
            .reduce(0L, Long::sum);
        System.out.println(result);
    }
}
