import java.util.LinkedList

val directions = arrayOf(
    intArrayOf(0, 1),
    intArrayOf(1, 0),
    intArrayOf(-1, 0),
    intArrayOf(0, -1),
    intArrayOf(1, 1),
    intArrayOf(1, -1),
    intArrayOf(-1, 1),
    intArrayOf(-1, -1)
)

private var n = -1
private var m = -1

fun main() {
    val (N, M) = readln()
        .split(" ")
        .map { it.toInt() }
    n = N
    m = M

    val map = Array(n) { IntArray(m) }
    val queue = LinkedList<Point>()
    val visited = Array(n) { BooleanArray(m) }

    for (row in 0 until n) {
        map[row] = readln().split(" ")
            .map { it.toInt() }
            .toIntArray()
        for (column in 0 until m) {
            if (map[row][column] == 1) {
                queue.add(Point(row, column, 0))
                visited[row][column] = true
            }
        }
    }

    var result = 0
    while (queue.isNotEmpty()) {
        val point = queue.poll()

        for (direction in directions) {
            val nextX = point.x + direction[0]
            val nextY = point.y + direction[1]
            if (moveable(nextX, nextY) && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true
                queue.add(Point(nextX, nextY, point.count + 1))
                result = maxOf(result, point.count + 1)
            }
        }
    }
    println(result)
}

private fun moveable(
    x: Int,
    y: Int,
) = x in 0 until n && y in 0 until m

data class Point(
    val x: Int,
    val y: Int,
    val count: Int,
)
