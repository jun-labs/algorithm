package boj.boj_2562

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    var max = Int.MIN_VALUE
    var targetIndex = 0

    for (index in 1..9) {
        val num = nextInt()
        if (num > max) {
            max = num
            targetIndex = index
        }
    }

    println("$max\n$targetIndex")
}
