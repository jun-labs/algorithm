package boj.boj_1325

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var relation: MutableList<MutableList<Int>>
private lateinit var visited: BooleanArray
private lateinit var counts: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ")
        .map { it.toInt() }

    relation = MutableList(n + 1) { mutableListOf() }
    visited = BooleanArray(n + 1)
    counts = IntArray(n + 1)

    repeat(m) {
        val (nodeA, nodeB) = br.readLine().split(" ")
            .map { it.toInt() }
        relation[nodeB].add(nodeA)
    }

    for (node in 1..n) {
        visited.fill(false)
        counts[node] = dfs(node, node)
    }

    val max = counts.maxOrNull() ?: -1
    val sb = StringBuilder()
    for (node in 1..n) {
        if (counts[node] == max) {
            sb.append(node).append(" ")
        }
    }
    println(sb.toString().trim())
}

fun dfs(
    source: Int,
    target: Int,
): Int {
    visited[target] = true
    var count = 1
    for (next in relation[target]) {
        if (!visited[next]) {
            count += dfs(source, next)
        }
    }
    return count
}
