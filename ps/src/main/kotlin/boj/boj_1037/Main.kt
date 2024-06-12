package boj.boj_1037

fun main() {
    readln()
    val numbers = readln().split(" ")
        .map { it.toInt() }
    val max = numbers.max()
    val min = numbers.min()
    println(max * min)
}
