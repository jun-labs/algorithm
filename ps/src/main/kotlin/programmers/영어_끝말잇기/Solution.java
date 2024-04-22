package programmers.영어_끝말잇기;

import java.util.*;

public class Solution {
    private static final int START = 0;
    private final Set<String> usedWords = new HashSet<>();

    public int[] solution(int n, String[] words) {
        String lastWord = words[0];
        usedWords.add(lastWord);

        for (int index = 1; index < words.length; index++) {
            String word = words[index];
            int id = index % n;

            if (!isLinked(lastWord, word) || isDuplicated(word)) {
                return new int[]{id + 1, index / n + 1};
            }

            usedWords.add(word);
            lastWord = word;
        }
        return new int[]{0, 0};
    }

    private static boolean isLinked(
        String lastWord,
        String currentWord
    ) {
        return lastWord.charAt(lastWord.length() - 1) == currentWord.charAt(START);
    }

    private boolean isDuplicated(String currentWord) {
        return usedWords.contains(currentWord);
    }
}
