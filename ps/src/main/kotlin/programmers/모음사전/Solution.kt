package programmers.모음사전

class Solution {
    companion object {
        private val letters = arrayOf('A', 'E', 'I', 'O', 'U')
        private val answers = mutableListOf<String>()
    }

    fun solution(word: String): Int {
        for (wordCount in 1..letters.size) {
            dfs(wordCount, "", 0)
        }
        answers.sort()

        var answer = 0
        for (idx in 0 until answers.size) {
            if (answers[idx] == word) {
                answer = idx + 1
                break
            }
        }
        return answer
    }

    private fun dfs(
        targetCount: Int,
        value: String,
        count: Int
    ) {
        if (targetCount == count) {
            answers.add(value)
            return
        }
        for (idx in 0 until letters.size) {
            dfs(targetCount, value + letters[idx], count + 1)
        }
    }
}

fun main() {
    val word = "AAAAE"
    val solution = Solution()
    println(solution.solution(word))
}
