package boj.boj_11660

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val dp = Array(n + 1) { IntArray(n + 1) }

    for (x in 1..n) {
        val st = StringTokenizer(br.readLine())
        for (y in 1..n) {
            val value = st.nextToken().toInt()
            dp[x][y] = dp[x - 1][y] + dp[x][y - 1] - dp[x - 1][y - 1] + value
        }
    }

    val sb = StringBuilder()
    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()
        val answer = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]
        sb.append(answer)
            .append('\n')
    }
    println(sb)
}
