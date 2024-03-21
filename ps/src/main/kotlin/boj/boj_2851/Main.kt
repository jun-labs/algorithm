package boj.boj_2851

import kotlin.math.abs

fun main() {
    val mushrooms = IntArray(10) { readln().toInt() }
    var sum = 0
    var closest = 0

    for (number in mushrooms) {
        sum += number
        if (abs(100 - sum) <= abs(100 - closest)) {
            closest = sum
        }
    }
    println(closest)
}
