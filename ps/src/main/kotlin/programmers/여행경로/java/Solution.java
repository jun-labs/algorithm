package programmers.여행경로.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    private boolean[] visited;
    private List<String> allRoute;
    private String[][] tickets;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();
        dfs("ICN", "ICN", 0);
        Collections.sort(allRoute);
        return allRoute.get(0)
            .split(" ");
    }

    private void dfs(
        String start,
        String route,
        int count
    ) {
        if (count == tickets.length) {
            allRoute.add(route);
            return;
        }
        for (int index = 0; index < tickets.length; index++) {
            if (start.equals(tickets[index][0]) && !visited[index]) {
                visited[index] = true;
                String next = tickets[index][1];
                dfs(next, route + " " + next, count + 1);
                visited[index] = false;
            }
        }
    }
}
