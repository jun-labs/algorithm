package boj.boj_1929

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ")
        .map { it.toInt() }

    val isPrime = BooleanArray(n + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    val max = sqrt(n.toDouble())
        .toInt()

    for (number in 2..max) {
        for (element in number * number..n step number) {
            isPrime[element] = false
        }
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for (idx in m..n) {
        if (isPrime[idx]) {
            bw.write("$idx\n")
        }
    }
    bw.flush()
    bw.close()
}
