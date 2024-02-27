package boj.boj_10250

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val count = nextInt()

    for (index in 0 until count) {
        val h = nextInt()
        val w = nextInt()
        val n = nextInt()

        val floor = n % h
        val room = n / h + 1

        val currentFloor = if (floor == 0) {
            h
        } else {
            floor
        }

        val roomNumber = if (floor == 0) {
            room - 1
        } else {
            room
        }

        val answer = "${currentFloor}${if (roomNumber < 10) "0$roomNumber" else "$roomNumber"}"
        println(answer)
    }
}
