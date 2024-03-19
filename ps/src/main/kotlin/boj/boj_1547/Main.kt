package boj.boj_1547

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val m = br.readLine().toInt()
    var ballPosition = 1

    repeat(m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        if (ballPosition == x) {
            ballPosition = y
        } else if (ballPosition == y) {
            ballPosition = x
        }
    }
    println(ballPosition)
}
