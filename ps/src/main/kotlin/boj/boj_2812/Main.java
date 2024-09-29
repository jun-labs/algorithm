package boj.boj_2812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 123321
public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = br.readLine().split(" ");
        final int n = Integer.parseInt(input[0]);
        final int k = Integer.parseInt(input[1]);
        final String number = br.readLine();

        final Stack<Character> stack = new Stack<>();
        int removeCount = 0;
        for (int index = 0; index < n; index++) {
            char value = number.charAt(index);
            while (!stack.isEmpty() && stack.peek() < value && removeCount < k) {
                stack.pop();
                removeCount++;
            }
            stack.push(value);
        }

        final StringBuilder sb = new StringBuilder();
        for (int index = 0; index < n - k; index++) {
            sb.append(stack.get(index));
        }
        System.out.println(sb);
    }
}
