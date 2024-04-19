package boj.boj_2468

import java.util.LinkedList

private val directions = arrayOf(
    intArrayOf(-1, 0),
    intArrayOf(1, 0),
    intArrayOf(0, -1),
    intArrayOf(0, 1)
)

private var minHeight = 100_000
private var maxHeight = -100_000

private var n: Int = 0
private lateinit var map: Array<IntArray>
private lateinit var visited: Array<BooleanArray>

fun main() {
    n = readln().toInt()
    map = Array(n) { IntArray(n) }
    visited = Array(n) { BooleanArray(n) }

    for (x in 0 until n) {
        val line = readln().split(" ")
            .map { it.toInt() }
            .toIntArray()
        map[x] = line
        for (y in 0 until n) {
            minHeight = minOf(minHeight, map[x][y])
            maxHeight = maxOf(maxHeight, map[x][y])
        }
    }

    var safeArea = -100_000
    for (height in minHeight - 1..maxHeight) {
        var count = 0
        visited = Array(n) { BooleanArray(n) }
        for (x in 0 until n) {
            for (y in 0 until n) {
                if (bfs(x, y, height, visited)) {
                    count++
                }
            }
        }
        safeArea = maxOf(safeArea, count)
    }
    println(safeArea)
}

fun bfs(
    x: Int,
    y: Int,
    height: Int,
    visited: Array<BooleanArray>,
): Boolean {
    if (isInvalid(x, y, height)) {
        return false
    }
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(x, y))
    visited[x][y] = true

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (direction in directions) {
            val nextX = x + direction[0]
            val nextY = y + direction[1]
            if (moveable(nextX, nextY, height) && !visited[nextX][nextY]) {
                queue.add(Pair(nextX, nextY))
                visited[nextX][nextY] = true
            }
        }
    }
    return true
}

fun moveable(
    x: Int,
    y: Int,
    height: Int,
): Boolean {
    return x in 0 until n && y in 0 until n && map[x][y] > height
}

fun isInvalid(
    x: Int,
    y: Int,
    height: Int,
): Boolean {
    return visited[x][y] || map[x][y] <= height
}
