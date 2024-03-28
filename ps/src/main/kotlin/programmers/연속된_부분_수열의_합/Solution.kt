package programmers.연속된_부분_수열의_합

class Solution {
    fun solution(
        sequence: IntArray,
        k: Int
    ): IntArray {
        var start = 0
        var sum = 0

        var xPosition = 0
        var yPosition = 0
        var minLength = Int.MAX_VALUE

        for (end in sequence.indices) {
            sum += sequence[end]
            while (sum >= k) {
                if (sum == k && (end - start < minLength)) {
                    minLength = end - start
                    xPosition = start
                    yPosition = end
                }
                sum -= sequence[start++]
            }
        }
        return intArrayOf(xPosition, yPosition)
    }
}
