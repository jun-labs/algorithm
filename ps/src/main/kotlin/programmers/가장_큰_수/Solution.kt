package programmers.가장_큰_수

class Solution {
    fun solution(numbers: IntArray): String {
        val strNumbers = numbers.map { it.toString() }
        val sortedStrNumbers = strNumbers.sortedWith { a, b ->
            (b + a).compareTo(a + b)
        }
        val answer = sortedStrNumbers.joinToString(separator = "")
        return if (answer.startsWith("0")) return "0" else answer
    }
}
