package boj.boj_11725.java.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] relation = new ArrayList[n + 1];
        for (int index = 1; index <= n; index++) {
            relation[index] = new ArrayList<>();
        }

        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        for (int index = 1; index < n; index++) {
            String[] input = br.readLine().split(" ");
            int nodeA = Integer.parseInt(input[0]);
            int nodeB = Integer.parseInt(input[1]);
            relation[nodeA].add(nodeB);
            relation[nodeB].add(nodeA);
        }

        dfs(relation, visited, 1, parent);

        for (int index = 2; index <= n; index++) {
            System.out.println(parent[index]);
        }
    }

    private static void dfs(
        List<Integer>[] relation,
        boolean[] visited,
        int node,
        int[] parent
    ) {
        visited[node] = true;

        List<Integer> linkedNodes = relation[node];
        for (int next : linkedNodes) {
            if (!visited[next]) {
                parent[next] = node;
                dfs(relation, visited, next, parent);
            }
        }
    }
}
