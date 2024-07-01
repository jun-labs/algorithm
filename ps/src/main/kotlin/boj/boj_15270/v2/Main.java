package boj.boj_15270.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    private static List<Integer>[] friends;
    private static boolean[] visited;
    private static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        if (m == 0) {
            System.out.println(1);
            return;
        }

        friends = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int index = 1; index <= n; index++) {
            friends[index] = new ArrayList<>();
        }

        for (int index = 0; index < m; index++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            friends[u].add(v);
            friends[v].add(u);
        }

        dfs(1, 0);
        System.out.println(answer < n ? answer + 1 : answer);
    }

    private static void dfs(
        int node,
        int count
    ) {
        if (node > n) {
            return;
        }
        answer = Math.max(answer, count);

        for (int start = node; start <= n; start++) {
            for (int friend : friends[start]) {
                if (!visited[start] && !visited[friend]) {
                    visited[start] = true;
                    visited[friend] = true;
                    dfs(start, count + 2);
                    visited[start] = false;
                    visited[friend] = false;
                }
            }
        }
    }
}
