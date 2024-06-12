package boj.boj_6588

import kotlin.math.sqrt

fun main() {
    val max = 1_000_000
    val isPrime = BooleanArray(max + 1) { true }
    val primes = mutableListOf<Int>()

    isPrime[0] = false
    isPrime[1] = false

    val sqrt = sqrt(max.toDouble())
    for (i in 2..sqrt.toInt()) {
        if (isPrime[i]) {
            primes.add(i)
            for (j in i * 2..max step i) {
                isPrime[j] = false
            }
        }
    }

    val testCases = generateSequence(::readlnOrNull)
        .map(String::toInt)
        .takeWhile { it != 0 }
        .toList()

    testCases.forEach { n ->
        var found = false
        for (prime in primes) {
            if (prime > n / 2) break
            val complement = n - prime
            if (isPrime[complement]) {
                println("$n = $prime + $complement")
                found = true
                break
            }
        }
        if (!found) println("Goldbach's conjecture is wrong.")
    }
}
