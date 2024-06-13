package boj.boj_13023

import kotlin.system.exitProcess

private lateinit var relation: Array<MutableList<Int>>
private lateinit var visited: BooleanArray

fun main() {
    val (n, m) = readln().split(" ")
        .map { it.toInt() }
    relation = Array(n + 1) { mutableListOf() }
    visited = BooleanArray(n + 1)

    for (idx in 0 until m) {
        val (a, b) = readln().split(" ")
            .map { it.toInt() }
        relation[a].add(b)
        relation[b].add(a)
    }

    for (node in 1..n) {
        dfs(node, 0)
    }
    println(0)
}

private fun dfs(
    node: Int,
    count: Int,
) {
    if (count == 5) {
        println(1)
        exitProcess(0)
    }

    val friends = relation[node]
    for (friend in friends) {
        if (!visited[friend]) {
            visited[friend] = true
            dfs(friend, count + 1)
            visited[friend] = false
        }
    }
}
