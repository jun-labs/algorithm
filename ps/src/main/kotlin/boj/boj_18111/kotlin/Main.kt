package boj.boj_18111.kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, b) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    for (row in 0 until n) {
        val line = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        map[row] = line
        for (column in 0 until m) {
            min = minOf(min, map[row][column])
            max = maxOf(max, map[row][column])
        }
    }

    var time = Int.MAX_VALUE
    var height = 0

    for (blockHeight in max downTo min) {
        var blockCount = b
        var tempTime = 0

        for (row in 0 until n) {
            for (column in 0 until m) {
                if (map[row][column] > blockHeight) {
                    blockCount += (map[row][column] - blockHeight)
                    tempTime += 2 * (map[row][column] - blockHeight)
                } else if (map[row][column] < blockHeight) {
                    blockCount -= (blockHeight - map[row][column])
                    tempTime += (blockHeight - map[row][column])
                }
            }
        }

        if (blockCount >= 0 && tempTime < time) {
            time = tempTime
            height = blockHeight
        }
    }

    println("$time $height")
}
