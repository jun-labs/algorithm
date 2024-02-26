package boj.boj_2588

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val a = next()
    val b = next()
    val bArray = b.map { it - '0' }
        .toIntArray()

    val lengthB = bArray.size

    for (row in 0 until lengthB) {
        println(bArray[lengthB - 1 - row] * a.toInt())
    }
    println(a.toInt() * b.toInt())
}
