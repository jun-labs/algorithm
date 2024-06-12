package programmers.단어_변환.java;

import java.util.Arrays;

public class Solution {
    private int answer = 100_000;
    private String[] words;
    private boolean[] visited;

    public int solution(
        String begin,
        String target,
        String[] words
    ) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        this.words = words;
        this.visited = new boolean[words.length];
        dfs(begin, target, 0);
        return answer;
    }

    private void dfs(
        String word,
        String target,
        int count
    ) {
        if (word.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int index = 0; index < words.length; index++) {
            if (!visited[index] && isDifferentOnlyOneCharacter(word, words[index])) {
                visited[index] = true;
                dfs(words[index], target, count + 1);
                visited[index] = false;
            }
        }
    }

    private boolean isDifferentOnlyOneCharacter(
        String wordA,
        String wordB
    ) {
        int count = 0;
        for (int index = 0; index < wordA.length(); index++) {
            if (wordA.charAt(index) != wordB.charAt(index)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }
}
