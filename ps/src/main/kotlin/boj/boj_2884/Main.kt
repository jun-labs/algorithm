package boj.boj_2884

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val inputHour = nextInt()
    val inputMinutes = nextInt()

    var time = inputHour * 60 + inputMinutes - 45
    if (time < 0) {
        time += 60 * 24
    }

    val hour = time / 60 % 24
    val minutes = time % 60
    println("$hour $minutes")
}
