package boj.boj_10817

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val numbers = mutableListOf<Int>()
    for (i in 0 until 3) {
        val number = nextInt()
        numbers.add(number)
    }

    numbers.sort()
    println(numbers[1])
}
