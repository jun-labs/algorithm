package boj.boj_1247

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    repeat(3) {
        val n = br.readLine().toInt()
        var sum = BigInteger.ZERO

        repeat(n) {
            sum += br.readLine().toBigInteger()
        }
        println(
            when {
                sum > BigInteger.ZERO -> "+"
                sum < BigInteger.ZERO -> "-"
                else -> "0"
            }
        )
    }
}
