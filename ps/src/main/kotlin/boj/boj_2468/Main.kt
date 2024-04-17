package boj.boj_2468

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

private val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
private var minHeight = 100
private var maxHeight = 1
private lateinit var heights: Array<IntArray>
private lateinit var visited: Array<BooleanArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    heights = Array(n) { IntArray(n) }
    visited = Array(n) { BooleanArray(n) }

    for (x in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (y in 0 until n) {
            heights[x][y] = row[y]
            minHeight = minOf(minHeight, heights[x][y])
            maxHeight = maxOf(maxHeight, heights[x][y])
        }
    }

    var safeAreaCount = 0
    for (height in minHeight - 1..maxHeight) {
        var count = 0
        visited = Array(n) { BooleanArray(n) }
        for (x in 0 until n) {
            for (y in 0 until n) {
                if (bfs(n, x, y, height)) {
                    count++
                }
            }
        }
        safeAreaCount = maxOf(safeAreaCount, count)
    }

    println(safeAreaCount)
}

fun bfs(
    n: Int,
    startX: Int,
    startY: Int,
    height: Int,
): Boolean {
    if (isUnder(startX, startY, height)) return false
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(startX, startY))
    visited[startX][startY] = true

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (direction in directions) {
            val nextX = x + direction[0]
            val nextY = y + direction[1]
            if (moveable(n, nextX, nextY, height)) {
                visited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }
    return true
}

private fun moveable(
    n: Int,
    nextX: Int,
    nextY: Int,
    rainHeight: Int,
) =
    nextX in 0 until n && nextY in 0 until n && !visited[nextX][nextY] && heights[nextX][nextY] > rainHeight

private fun isUnder(
    x: Int,
    y: Int,
    rainHeight: Int,
) = visited[x][y] || heights[x][y] <= rainHeight
