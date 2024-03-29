package programmers.모음사전

class Solution {
    companion object {
        private val letters = arrayOf('A', 'E', 'I', 'O', 'U')
        private val answers = mutableListOf<String>()
    }

    fun solution(word: String): Int {
        answers.clear()
        for (length in 1..5) {
            dfs(0, "", length)
        }
        answers.sort()
        return answers.indexOf(word) + 1
    }

    private fun dfs(
        depth: Int,
        word: String,
        length: Int
    ) {
        if (depth == length) {
            answers.add(word)
            return
        }

        for (letter in letters) {
            dfs(depth + 1, word + letter, length)
        }
    }
}

fun main() {
    val word = "AAAAE"
    val solution = Solution()
    solution.solution(word)
}
