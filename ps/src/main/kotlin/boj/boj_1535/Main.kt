package boj.boj_1535

fun main() {
    val n = readln().toInt()
    val life = readln().split(" ")
        .map { it.toInt() }
        .toIntArray()
    val happy = readln().split(" ")
        .map { it.toInt() }
        .toIntArray()

    val dp = Array(n + 1) { IntArray(100) }

    for (i in 1..n) {
        for (j in 0 until 100) {
            if (j >= life[i - 1]) {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - life[i - 1]] + happy[i - 1])
            } else {
                dp[i][j] = dp[i - 1][j]
            }
        }
    }

    println(dp[n][99])
}
