package programmers.N으로_표현.kt

class Solution {
    fun solution(
        N: Int,
        number: Int
    ): Int {
        if (N == number) {
            return 1
        }
        val dp = Array<MutableSet<Int>>(9) { mutableSetOf() }

        for (idx in 1 until 9) {
            dp[idx].add("$N".repeat(idx).toInt())
            for (otherIdx in 1 until idx) {
                for (element in dp[otherIdx]) {
                    for (otherElement in dp[idx - otherIdx]) {
                        dp[idx].add(element + otherElement)
                        dp[idx].add(element - otherElement)
                        dp[idx].add(element * otherElement)
                        if (otherElement > 0) {
                            dp[idx].add(element / otherElement)
                        }
                    }
                }
            }
            for (target in dp[idx]) {
                if (target == number) {
                    return idx
                }
            }
        }
        return -1
    }
}
