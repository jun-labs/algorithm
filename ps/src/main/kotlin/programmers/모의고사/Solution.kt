package programmers.모의고사

class Solution {
    private val aStudentPattern = intArrayOf(1, 2, 3, 4, 5)
    private val bStudentPattern = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    private val cStudentPattern = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    fun solution(answers: IntArray): IntArray {
        val result = mutableListOf<Int>()

        var aStudentAnswer = 0
        var bStudentAnswer = 0
        var cStudentAnswer = 0

        for (idx in 0 until answers.size) {
            if (aStudentPattern[idx % 5] == answers[idx]) {
                aStudentAnswer++
            }
            if (bStudentPattern[idx % 8] == answers[idx]) {
                bStudentAnswer++
            }
            if (cStudentPattern[idx % 10] == answers[idx]) {
                cStudentAnswer++
            }
        }

        val max = maxOf(aStudentAnswer, bStudentAnswer, cStudentAnswer)
        if (aStudentAnswer == max) {
            result.add(1)
        }
        if (bStudentAnswer == max) {
            result.add(2)
        }
        if (cStudentAnswer == max) {
            result.add(3)
        }
        return result.toIntArray()
    }
}

fun main() {
    val answers = intArrayOf(1, 3, 2, 4, 2)
    val solution = Solution()
    println(solution.solution(answers))
}
