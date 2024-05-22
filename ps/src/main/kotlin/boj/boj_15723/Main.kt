package boj.boj_15723

import java.io.BufferedReader
import java.io.InputStreamReader

private val words = mutableMapOf<String, MutableList<String>>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    for (idx in 0 until n) {
        val (a, _, b) = br.readLine().split(" ")
        words.getOrPut(a) { mutableListOf() }.add(b)
    }

    val m = br.readLine().toInt()
    val results = mutableListOf<String>()

    for (idx in 0 until m) {
        val (a, _, b) = br.readLine().split(" ")
        if (dfs(a, b, mutableSetOf())) {
            results.add("T")
        } else {
            results.add("F")
        }
    }

    results.forEach { println(it) }
}

fun dfs(
    source: String,
    target: String,
    visited: MutableSet<String>,
): Boolean {
    if (source == target) {
        return true
    }
    if (visited.contains(source)) {
        return false
    }

    val neighbors = words[source]
    if (neighbors.isNullOrEmpty()) {
        return false
    }
    visited.add(source)
    return neighbors.any { dfs(it, target, visited) }
}

