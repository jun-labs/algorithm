package boj.boj_1783;

import java.io.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int row = Integer.parseInt(temp[0]);
        int column = Integer.parseInt(temp[1]);

        if (row == 1) {
            System.out.println(1);
        } else if (row == 2) {
            System.out.println(Math.min(4, (column + 1) / 2));
        } else if (column < 7) {
            System.out.println(Math.min(4, column));
        } else {
            System.out.println(column - 2);
        }
    }
}
