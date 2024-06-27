package boj.boj_1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final List<Long> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int number = 0; number < 10; number++) {
            addNumber(number, 1);
        }
        Collections.sort(numbers);
        int index = Integer.parseInt(br.readLine());
        if (index >= numbers.size()) {
            System.out.println(-1);
            System.exit(0);
        }
        System.out.println(numbers.get(index));
    }

    private static void addNumber(
        long number,
        int count
    ) {
        if (count > 10) {
            return;
        }
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
        for (int index = 0; index < 10; index++) {
            if (number % 10 > index) {
                addNumber(number * 10 + index, count + 1);
            }
        }
    }
}
