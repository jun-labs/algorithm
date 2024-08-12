package boj.boj_14395;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    private static long s;
    private static long t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        s = Long.parseLong(temp[0]);
        t = Long.parseLong(temp[1]);

        if (s == t) {
            System.out.println(0);
            return;
        }

        String answer = bfs();
        System.out.println(answer);
    }

    private static String bfs() {
        Queue<Number> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();
        queue.add(new Number(s, ""));
        visited.add(s);
        while (!queue.isEmpty()) {
            Number current = queue.poll();
            if (current.value == t) {
                return current.operations;
            }

            long value = current.value * current.value;
            if (value <= t && !visited.contains(value)) {
                queue.add(new Number(value, current.operations + "*"));
            }

            value = current.value + current.value;
            if (value <= t && !visited.contains(value)) {
                queue.add(new Number(value, current.operations + "+"));
            }

            value = 0;
            if (visited.add(value)) {
                queue.add(new Number(value, current.operations + "-"));
            }

            if (current.value != 0) {
                value = 1;
                if (visited.add(value)) {
                    queue.add(new Number(value, current.operations + "/"));
                }
            }
        }
        return "-1";
    }

    static class Number {
        long value;
        String operations;

        public Number(
            long value,
            String operations
        ) {
            this.value = value;
            this.operations = operations;
        }
    }
}
