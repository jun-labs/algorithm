package programmers.가장_큰_수

class Solution {
    fun solution(numbers: IntArray): String {
        val strNumbers = numbers.map { it.toString() }
        val sortedStrNumbers = strNumbers.sortedWith { a, b ->
            (a + b).compareTo(b + a)
        }
        val answer = sortedStrNumbers.joinToString(separator = "")
        return if (answer.startsWith("0")) "0" else answer
    }
}
