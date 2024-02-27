package boj.boj_10818

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    for (i in 0 until n) {
        val num = nextInt()
        if (num < min) {
            min = num
        }
        if (num > max) {
            max = num
        }
    }

    println("$min $max")
}
