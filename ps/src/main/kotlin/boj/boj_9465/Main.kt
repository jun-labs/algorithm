package boj.boj_9465

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()

        val stickers = Array(2) { IntArray(n + 1) }
        val dp = Array(2) { IntArray(n + 1) }

        for (i in 0 until 2) {
            val inputs = br.readLine().split(" ").map { it.toInt() }
            for (j in 1..n) {
                stickers[i][j] = inputs[j - 1]
            }
        }

        dp[0][1] = stickers[0][1]
        dp[1][1] = stickers[1][1]

        for (j in 2..n) {
            dp[0][j] = maxOf(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j]
            dp[1][j] = maxOf(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j]
        }
        println(maxOf(dp[0][n], dp[1][n]))
    }
}
