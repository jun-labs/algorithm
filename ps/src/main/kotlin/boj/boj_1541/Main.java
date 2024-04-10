package boj.boj_1541;

import java.io.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int sum = -100_000;
        String[] minusArray = input.split("-");
        for (String element : minusArray) {
            String[] plusArray = element.split("\\+");
            int temp = 0;
            for (String subElement : plusArray) {
                int number = Integer.parseInt(subElement);
                temp += number;
            }

            if (sum == -100_000) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
