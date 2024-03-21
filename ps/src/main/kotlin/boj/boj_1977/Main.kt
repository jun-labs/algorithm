package boj.boj_1977

import kotlin.math.sqrt

fun main() {
    val m = readln().toInt()
    val n = readln().toInt()
    val perfectSquares = mutableListOf<Int>()

    for (number in m..n) {
        if (isPerfectSquare(number)) {
            perfectSquares.add(number)
        }
    }

    if (perfectSquares.isEmpty()) {
        println(-1)
    } else {
        println(perfectSquares.sum())
        println(perfectSquares.min())
    }
}

fun isPerfectSquare(number: Int): Boolean {
    val squareRoot = sqrt(number.toFloat()).toInt()
    return squareRoot * squareRoot == number
}
