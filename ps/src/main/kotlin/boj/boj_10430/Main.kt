package boj.boj_10430

fun main() {
    val (a, b, c) = readln().split(" ")
        .map { it.toInt() }

    println((a + b) % c)
    println(((a % c) + (b % c)) % c)
    println((a * b) % c)
    println(((a % c) * (b % c)) % c)
}
