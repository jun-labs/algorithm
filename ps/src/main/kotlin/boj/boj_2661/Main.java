package boj.boj_2661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dfs("");
    }

    private static void dfs(String str) {
        if (str.length() == n) {
            System.out.println(str);
            System.exit(0);
        }
        for (int index = 1; index <= 3; index++) {
            if (isGoodSequence(str + index)) {
                dfs(str + index);
            }
        }
    }

    private static boolean isGoodSequence(String str) {
        int len = str.length() / 2;
        for (int index = 1; index <= len; index++) {
            if (str.substring(str.length() - index).equals(str.substring(str.length() - 2 * index, str.length() - index))) {
                return false;
            }
        }
        return true;
    }
}
