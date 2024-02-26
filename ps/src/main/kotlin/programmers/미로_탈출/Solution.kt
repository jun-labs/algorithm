package programmers.미로_탈출

import java.util.LinkedList
import java.util.Queue

class Solution {
    lateinit var array: Array<Array<Char>>
    lateinit var visited: Array<Array<Boolean>>
    private val xDirection = arrayOf(0, 0, 1, -1)
    private val yDirection = arrayOf(1, -1, 0, 0)

    fun solution(maps: Array<String>): Int {
        val rowSize = maps.size
        val columnSize = maps[0].length
        array = Array(rowSize) { row -> maps[row].toCharArray().toTypedArray() }
        visited = Array(rowSize) { Array(columnSize) { false } }

        var startPoint: Point? = null
        var lever: Point? = null
        var exit: Point? = null
        for (row in 0 until rowSize) {
            for (column in 0 until columnSize) {
                when (array[row][column]) {
                    'S' -> startPoint = Point(row, column, 0)
                    'L' -> lever = Point(row, column, 0)
                    'E' -> exit = Point(row, column, 0)
                }
            }
        }

        val timeToLever = bfs(startPoint!!, lever!!)
        if (timeToLever == -1) {
            return -1
        }

        val timeToExit = bfs(lever, exit!!)
        if (timeToExit == -1) {
            return -1
        }
        return timeToLever + timeToExit
    }

    fun bfs(
        start: Point,
        end: Point
    ): Int {
        val queue: Queue<Point> = LinkedList()
        visited[start.x][start.y] = true
        queue.add(start)

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (current.x == end.x && current.y == end.y) {
                return current.count
            }

            for (index in 0 until 4) {
                val nextX = current.x + xDirection[index]
                val nextY = current.y + yDirection[index]
                if (moveable(nextX, nextY)) {
                    visited[nextX][nextY] = true
                    queue.add(Point(nextX, nextY, current.count + 1))
                }
            }
        }
        return -1
    }

    fun moveable(x: Int, y: Int): Boolean {
        return x >= 0
                && x < array.size
                && y >= 0 && y < array[0].size
                && !visited[x][y]
                && array[x][y] != 'X'
    }
}

fun main() {
    val maps = arrayOf("SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE")
    val solution = Solution()
    println(solution.solution(maps))
}

data class Point(
    var x: Int,
    var y: Int,
    var count: Int
)

