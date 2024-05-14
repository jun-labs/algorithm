package boj.boj_3896

import kotlin.math.sqrt

private const val MAX_NUM = 1_299_709

fun main() {
    val input = readln().toInt()
    val numbers = ArrayList<Int>(input)
    for (idx in 0 until input) {
        numbers.add(readln().toInt())
    }

    val check = BooleanArray(MAX_NUM + 1) { true }
    check[0] = false
    check[1] = false

    for (idx in 2 until sqrt(MAX_NUM.toDouble()).toInt()) {
        if (check[idx]) {
            for (subIdx in idx * idx..MAX_NUM step idx) {
                check[subIdx] = false
            }
        }
    }

    val primes = ArrayList<Int>()
    for (idx in 2..MAX_NUM) {
        if (check[idx]) {
            primes.add(idx)
        }
    }

    for (number in numbers) {
        if (check[number]) {
            println("0")
        } else {
            val idx = primes.binarySearch(number)
            val trueIdx = if (idx >= 0) idx else -idx - 1
            println(primes[trueIdx] - primes[trueIdx - 1])
        }
    }
}

