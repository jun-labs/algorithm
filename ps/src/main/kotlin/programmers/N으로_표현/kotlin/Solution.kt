package programmers.N으로_표현.kotlin

class Solution {
    fun solution(
        N: Int,
        number: Int,
    ): Int {
        if (N == number) {
            return 1
        }
        // Number를 n번 사용해 만들 수 있는 모든 숫자의 집합.
        val dp = Array<MutableSet<Int>>(9) { mutableSetOf() }
        for (i in 1 until 9) {
            val value = N.toString().repeat(i).toInt()
            dp[i].add(value)
            for (j in 1 until i) {
                for (iElement in dp[j]) {
                    for (jElement in dp[i - j]) {
                        dp[i].add(iElement + jElement)
                        dp[i].add(iElement - jElement)
                        dp[i].add(iElement * jElement)
                        if (jElement > 0) {
                            dp[i].add(iElement / jElement)
                        }
                    }
                }
            }
            for (target in dp[i]) {
                if (target == number) {
                    return i
                }
            }
        }
        return -1
    }
}

fun main() {
    val N = 5
    val number = 12
    val solution = Solution()
    solution.solution(N, number)
}
