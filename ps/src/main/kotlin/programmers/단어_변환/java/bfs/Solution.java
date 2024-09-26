package programmers.단어_변환.java.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(
        String begin,
        String target,
        String[] words
    ) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        final boolean[] visited = new boolean[words.length];
        final Word word = new Word(begin, 0);
        final Queue<Word> queue = new LinkedList<>();
        queue.add(word);
        while (!queue.isEmpty()) {
            final Word source = queue.poll();
            if (source.is(target)) {
                return source.count;
            }
            for (int index = 0; index < words.length; index++) {
                if (!visited[index] && source.isOnlyOneDifference(words[index])) {
                    visited[index] = true;
                    queue.add(new Word(words[index], source.count + 1));
                }
            }
        }
        return 0;
    }

    private static class Word {
        String value;
        int count;

        public Word(
            final String value,
            final int count
        ) {
            this.value = value;
            this.count = count;
        }

        public boolean is(final String target) {
            return this.value.equals(target);
        }

        public boolean isOnlyOneDifference(final String target) {
            int count = 0;
            for (int index = 0; index < target.length(); index++) {
                if (this.value.charAt(index) != target.charAt(index)) {
                    count++;
                }
                if (count > 1) {
                    return false;
                }
            }
            return count == 1;
        }
    }
}
