package boj.boj_1072

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y) = br.readLine().split(" ").map { it.toLong() }
    val rate = (y * 100 / x).toInt()

    if (rate >= 99) {
        print(-1)
        return
    }

    var start = 0L
    var end = 2_000_000_000L
    var answer = 0L

    while (start <= end) {
        val mid = (start + end) / 2
        val newRate = ((y + mid) * 100 / (x + mid)).toInt()
        if (newRate > rate) {
            answer = mid
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    println(answer)
}
