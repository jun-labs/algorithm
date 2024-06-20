package boj.boj_11403.kotlin

fun main() {
    val n = readln().toInt()
    val map = Array(n) { IntArray(n) { 0 } }
    for (idx in 0 until n) {
        val line = readln().split(" ")
            .map { it.toInt() }
            .toIntArray()
        map[idx] = line
    }

    for (y in 0 until n) {
        for (x in 0 until n) {
            for (z in 0 until n) {
                if (map[x][y] == 1 || map[y][z] == 1) {
                    map[x][z] = 1
                }
            }
        }
    }

    for (row in map) {
        println(row.joinToString(" "))
    }
}
