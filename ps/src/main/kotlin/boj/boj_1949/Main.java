package boj.boj_1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] counts;
    static List<Integer>[] nodes;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        counts = new int[n + 1];
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        nodes = new ArrayList[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int index = 1; index <= n; index++) {
            counts[index] = Integer.parseInt(st.nextToken());
            nodes[index] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            nodes[nodeA].add(nodeB);
            nodes[nodeB].add(nodeA);
        }

        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = counts[node];

        List<Integer> linkedNode = nodes[node];
        for (int next : linkedNode) {
            if (!visited[next]) {
                dfs(next);
                dp[node][0] += Math.max(dp[next][0], dp[next][1]);
                dp[node][1] += dp[next][0];
            }
        }
    }
}
