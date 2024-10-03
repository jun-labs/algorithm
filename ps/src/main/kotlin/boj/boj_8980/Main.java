package boj.boj_8980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] tempNC = br.readLine().split(" ");
        int n = Integer.parseInt(tempNC[0]);
        int c = Integer.parseInt(tempNC[1]);
        int m = Integer.parseInt(br.readLine());

        final List<Box> boxes = new ArrayList<>();
        for (int index = 0; index < m; index++) {
            final String[] temp = br.readLine().split(" ");
            final int from = Integer.parseInt(temp[0]);
            final int to = Integer.parseInt(temp[1]);
            final int boxCount = Integer.parseInt(temp[2]);
            boxes.add(new Box(from, to, boxCount));
        }

        Collections.sort(boxes);
        int answer = 0;
        final int[] counts = new int[n];
        for (final Box box : boxes) {
            int maxCount = 0;
            for (int index = box.from; index < box.to; index++) {
                maxCount = Math.max(maxCount, counts[index]);
            }
            final int availableCount = c - maxCount;
            final int loadableCount = Math.min(availableCount, box.count);
            for (int index = box.from; index < box.to; index++) {
                counts[index] += loadableCount;
            }
            answer += loadableCount;
        }
        System.out.println(answer);
    }

    private static class Box implements Comparable<Box> {
        final int from;
        final int to;
        final int count;

        public Box(
            final int from,
            final int to,
            final int count
        ) {
            this.from = from;
            this.to = to;
            this.count = count;
        }

        @Override
        public int compareTo(final Box o) {
            if (this.to == o.to) {
                return this.from - o.from;
            }
            return this.to - o.to;
        }
    }
}
