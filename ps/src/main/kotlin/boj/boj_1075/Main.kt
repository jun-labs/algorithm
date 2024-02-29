package boj.boj_1075

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val number = nextInt()
    val division = nextInt()

    val base = number - (number % division)
    for (value in 0 until number) {
        val temp = base + value
        if (temp % division == 0) {
            println(String.format("%02d", value))
            break
        }
    }
}
