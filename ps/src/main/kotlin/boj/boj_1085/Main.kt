package boj.boj_1085

fun main() {
    val (x, y, w, h) = readLine()!!
        .split(" ")
        .map { it.toInt() }

    val left = x
    val right = w - x
    val bottom = y
    val top = h - y

    println(minOf(left, right, bottom, top))
}
