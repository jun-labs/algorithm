package boj.boj_2075

fun main() {
    val allNumbers = mutableListOf<Int>()
    val n = readln().toInt()
    for (idx in 0 until n) {
        val numbers = readln().split(" ")
            .map { it.toInt() }
            .toIntArray()
        allNumbers.addAll(numbers.toList())
    }

    allNumbers.sortDescending()
    for (idx in 0 until allNumbers.size) {
        if (idx == n - 1) {
            println(allNumbers[idx])
            return
        }
    }
}
