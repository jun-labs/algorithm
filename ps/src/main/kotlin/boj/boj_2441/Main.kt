package boj.boj_2441

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    var n = nextInt()
    var blank = 0

    while (n > 0) {
        val line = " ".repeat(blank) + "*".repeat(n)
        println(line)
        n--
        blank++
    }
}
