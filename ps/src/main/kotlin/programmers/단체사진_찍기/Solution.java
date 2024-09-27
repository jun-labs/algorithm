package programmers.단체사진_찍기;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private String[] data;
    private final Map<Character, Integer> map = new HashMap<>();
    private final int[] ch = new int[8];
    private int answer = 0;
    private final boolean[] visited = new boolean[8];

    public int solution(
        final int n,
        final String[] data
    ) {
        init(data);
        dfs(0);
        return answer;
    }

    private void dfs(final int index) {
        if (index == 8) {
            if (isPossible()) {
                answer++;
            }
        } else {
            for (int node = 0; node < 8; node++) {
                if (!visited[node]) {
                    visited[node] = true;
                    ch[index] = node;
                    dfs(index + 1);
                    visited[node] = false;
                    ch[index] = 0;
                }
            }
        }
    }

    private boolean isPossible() {
        int characterA;
        int characterB;
        int sign;
        char operation;
        for (String element : data) {
            characterA = ch[map.get(element.charAt(0))];
            characterB = ch[map.get(element.charAt(2))];
            operation = element.charAt(3);
            sign = element.charAt(4) - '0' + 1;
            if (operation == '=') {
                if (Math.abs(characterA - characterB) != sign) {
                    return false;
                }
            } else if (operation == '>') {
                if (Math.abs(characterA - characterB) <= sign) {
                    return false;
                }
            } else {
                if (Math.abs(characterA - characterB) >= sign) {
                    return false;
                }
            }
        }
        return true;
    }

    private void init(final String[] data) {
        this.data = data;
        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);
    }
}
