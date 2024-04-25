package boj.boj_18870

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ")
        .map { it.toInt() }
        .toIntArray()

    val sortedNumbers = numbers.sortedArray()

    val uniqueNumbers = sortedNumbers.distinct()
    val map = mutableMapOf<Int, Int>()
    uniqueNumbers.forEachIndexed { index, value ->
        map[value] = index
    }

    val result = numbers.map { map[it]!! }
        .joinToString(" ")
    println(result)
}
