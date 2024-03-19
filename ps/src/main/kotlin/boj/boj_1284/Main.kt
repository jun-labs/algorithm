package boj.boj_1284

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val line = br.readLine() ?: break
        if (line == "0") {
            break
        }

        var width = 1
        line.forEach { value ->
            width += when (value) {
                '1' -> 2
                '0' -> 4
                else -> 3
            } + 1
        }
        println(width)
    }
}
