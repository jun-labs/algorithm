package boj.boj_2578

private val positions = mutableMapOf<Int, Pair<Int, Int>>()
private val map = Array(5) { IntArray(5) }
private val check = Array(5) { BooleanArray(5) { false } }

fun main() {
    for (row in 0 until 5) {
        val line = readln().split(" ")
            .map { it.toInt() }
        for (col in line.indices) {
            map[row][col] = line[col]
            positions[line[col]] = Pair(row, col)
        }
    }

    val numbers = mutableListOf<Int>()
    for (idx in 0 until 5) {
        val line = readln().split(" ")
            .map { it.toInt() }
        numbers.addAll(line)
    }

    var count = 0
    for (idx in numbers) {
        count++
        val (x, y) = positions[idx]!!
        check[x][y] = true

        if (isBingo()) {
            println(count)
            return
        }
    }
}

private fun isBingo(): Boolean {
    var lines = 0

    // 가로
    for (row in 0 until 5) {
        if (check[row].all { it }) {
            lines++
        }
    }

    // 세로
    for (col in 0 until 5) {
        var flag = true
        for (row in 0 until 5) {
            if (!check[row][col]) {
                flag = false
                break
            }
        }
        if (flag) {
            lines++
        }
    }

    // 대각선 1
    var flag = true
    for (idx in 0 until 5) {
        if (!check[idx][idx]) {
            flag = false
            break
        }
    }
    if (flag) {
        lines++
    }

    // 대각선 2
    flag = true
    for (idx in 0 until 5) {
        if (!check[idx][4 - idx]) {
            flag = false
            break
        }
    }
    if (flag) {
        lines++
    }
    return lines >= 3
}
