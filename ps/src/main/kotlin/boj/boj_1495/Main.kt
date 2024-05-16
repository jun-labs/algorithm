package boj.boj_1495

fun main() {
    val (n, s, m) = readln().split(" ")
        .map { it.toInt() }
    val v = readln().split(" ")
        .map { it.toInt() }
        .toIntArray()
    println(calculateVolume(n, s, m, v))
}

fun calculateVolume(
    n: Int,
    s: Int,
    m: Int,
    v: IntArray,
): Int {
    val dp = Array(n + 1) { BooleanArray(m + 1) }

    dp[0][s] = true
    for (i in 0 until n) {
        for (j in 0..m) {
            if (dp[i][j]) {
                if (j + v[i] <= m) {
                    dp[i + 1][j + v[i]] = true
                }
                if (j - v[i] >= 0) {
                    dp[i + 1][j - v[i]] = true
                }
            }
        }
    }

    for (volume in m downTo 0) {
        if (dp[n][volume]) {
            return volume
        }
    }
    return -1
}
