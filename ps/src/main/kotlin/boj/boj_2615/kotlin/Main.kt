package boj.boj_2615

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var board: Array<IntArray>
private val dx = arrayOf(0, 1, -1, 1)
private val dy = arrayOf(1, 0, 1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    board = Array(19) { IntArray(19) }
    for (i in 0 until 19) {
        board[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (x in 0 until 19) {
        for (y in 0 until 19) {
            if (board[x][y] > 0) {
                for (direction in 0 until 4) {
                    if (isWin(x, y, direction)) {
                        println("${board[x][y]}")
                        println("${x + 1} ${y + 1}")
                        return
                    }
                }
            }
        }
    }
    println("0")
}

fun isWin(
    x: Int,
    y: Int,
    direction: Int,
): Boolean {
    val player = board[x][y]
    var count = 1

    var nextX = x + dx[direction]
    var nextY = y + dy[direction]
    while (moveable(nextX, nextY, player)) {
        count++
        nextX += dx[direction]
        nextY += dy[direction]
    }

    if (moveable(nextX, nextY, player)) {
        return false
    }

    nextX = x - dx[direction]
    nextY = y - dy[direction]
    if (moveable(nextX, nextY, player)) {
        return false
    }

    return count == 5
}

fun moveable(
    x: Int,
    y: Int,
    player: Int,
): Boolean {
    return x in 0 until 19
            && y in 0 until 19
            && board[x][y] == player
}
