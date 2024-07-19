package boj.boj_12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static boolean[] robots;
    private static int[] belt;
    private static int n;
    private static int k;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        robots = new boolean[n];
        belt = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int step = 0;
        while (rotatable()) {
            step++;
            moveBelt();
            moveRobot();
            if (belt[0] >= 1) {
                belt[0] -= 1;
                robots[0] = true;
            }
        }
        System.out.println(step);
    }

    private static boolean rotatable() {
        int count = 0;
        for (int duration : belt) {
            if (duration <= 0) {
                count++;
            }
            if (count == k) {
                return false;
            }
        }
        return true;
    }

    private static void moveBelt() {
        final int last = belt[belt.length - 1];
        for (int index = belt.length - 1; index >= 1; index--) {
            belt[index] = belt[index - 1];
        }
        belt[0] = last;

        for (int index = robots.length - 1; index >= 1; index--) {
            robots[index] = robots[index - 1];
        }
        robots[0] = false;
        robots[n - 1] = false;
    }

    private static void moveRobot() {
        for (int index = robots.length - 1; index >= 1; index--) {
            if (moveable(index)) {
                robots[index] = true;
                robots[index - 1] = false;
                belt[index] -= 1;
            }
        }
    }

    private static boolean moveable(int index) {
        return belt[index] >= 1
            && !robots[index]
            && robots[index - 1];
    }
}
