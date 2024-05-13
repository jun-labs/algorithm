package boj.boj_1890

fun main() {
    val n = readln().toInt()
    val board = Array(n) { IntArray(n) }
    val dp = Array(n) { LongArray(n) }

    for (idx in 0 until n) {
        board[idx] = readln().split(" ")
            .map { it.toInt() }
            .toIntArray()
    }

    dp[0][0] = 1

    for (x in 0 until n) {
        for (y in 0 until n) {
            if (dp[x][y] > 0 && board[x][y] != 0) {
                val jump = board[x][y]
                if (x + jump < n) {
                    dp[x + jump][y] += dp[x][y]
                }
                if (y + jump < n) {
                    dp[x][y + jump] += dp[x][y]
                }
            }
        }
    }
    println(dp[n - 1][n - 1])
}
