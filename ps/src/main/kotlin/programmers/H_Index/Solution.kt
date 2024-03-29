package programmers.H_Index

class Solution {
    fun solution(citations: IntArray): Int {
        citations.sort()

        val length = citations.size
        for (idx in 0 until length) {
            if (citations[idx] >= length - idx) {
                return length - idx
            }
        }
        return 0
    }
}

fun main() {
    val citiations = intArrayOf(3, 0, 6, 1, 5)
    val solution = Solution()
    println(solution.solution(citiations))
}
