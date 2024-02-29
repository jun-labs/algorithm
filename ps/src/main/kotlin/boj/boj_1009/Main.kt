package boj.boj_1009

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    for (index in 0 until n) {
        val a = nextInt()
        val b = nextInt()
        println(calculate(a, b))
    }
}

fun calculate(
    a: Int,
    b: Int
): Int {
    var answer = a % 10
    for (idx in 0 until b - 1) {
        answer *= a
        answer %= 10
    }
    return when {
        answer % 10 == 0 -> {
            10
        }

        else -> answer
    }
}
