package boj.boj_5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int f = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int g = Integer.parseInt(input[2]);
        int u = Integer.parseInt(input[3]);
        int d = Integer.parseInt(input[4]);

        if (s == g) {
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[f + 1];
        visited[s] = true;
        Queue<Floor> queue = new LinkedList<>();
        queue.add(new Floor(s, 0));

        while (!queue.isEmpty()) {
            Floor floor = queue.poll();
            if (floor.position == g) {
                System.out.println(floor.count);
                return;
            }

            int nextUp = floor.position + u;
            if (nextUp <= f && !visited[nextUp]) {
                visited[nextUp] = true;
                queue.add(new Floor(nextUp, floor.count + 1));
            }

            int nextDown = floor.position - d;
            if (nextDown >= 1 && !visited[nextDown]) {
                visited[nextDown] = true;
                queue.add(new Floor(nextDown, floor.count + 1));
            }
        }
        System.out.println("use the stairs");
    }

    static class Floor {
        int position;
        int count;

        public Floor(
            int position,
            int count
        ) {
            this.position = position;
            this.count = count;
        }
    }
}
