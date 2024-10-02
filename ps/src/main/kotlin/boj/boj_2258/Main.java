package boj.boj_2258;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());

        final PriorityQueue<Meat> queue = new PriorityQueue<>();
        long totalWeight = 0;
        for (int index = 0; index < n; index++) {
            st = new StringTokenizer(br.readLine());
            final int weight = Integer.parseInt(st.nextToken());
            final int price = Integer.parseInt(st.nextToken());
            totalWeight += weight;
            queue.add(new Meat(price, weight));
        }
        if (totalWeight < m) {
            System.out.println(-1);
            return;
        }

        int weight = 0;
        int beforePrice = 0;
        int totalPrice = 0;
        int minPrice = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            final Meat meat = queue.poll();
            weight += meat.weight;
            if (beforePrice == meat.price) {
                totalPrice += meat.price;
            } else {
                totalPrice = meat.price;
            }
            if (weight >= m) {
                minPrice = Math.min(minPrice, totalPrice);
            }
            beforePrice = meat.price;
        }
        System.out.println(minPrice);
    }

    private static class Meat implements Comparable<Meat> {
        private final int price;
        private final int weight;

        public Meat(
            final int price,
            final int weight
        ) {
            this.price = price;
            this.weight = weight;
        }

        @Override
        public int compareTo(Meat o) {
            if (o.price == this.price) {
                return o.weight - this.weight;
            }
            return this.price - o.price;
        }
    }
}
